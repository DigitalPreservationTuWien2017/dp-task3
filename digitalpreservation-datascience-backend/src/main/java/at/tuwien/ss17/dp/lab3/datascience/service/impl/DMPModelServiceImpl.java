package at.tuwien.ss17.dp.lab3.datascience.service.impl;

import at.tuwien.ss17.dp.lab3.datascience.exception.DataModelInstanceValidationException;
import at.tuwien.ss17.dp.lab3.datascience.model.dmp.javax.*;
import at.tuwien.ss17.dp.lab3.datascience.model.dmp.json.LinkDataArray;
import at.tuwien.ss17.dp.lab3.datascience.model.dmp.json.NodeDataArray;
import at.tuwien.ss17.dp.lab3.datascience.service.DMPModelService;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import org.springframework.stereotype.Service;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.xml.validation.Schema;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import at.tuwien.ss17.dp.lab3.datascience.model.dmp.json.DmpModel;

@Service(value="DMPModelService")
public class DMPModelServiceImpl implements DMPModelService {

    int id = 0;
    int locX = 120;
    int locY = 120;
    int lvl0RootId = 0;
    int lvl1RootId = 0;
    int lvl2RootId = 0;
    final int X_OFFSET = 300;
    final int Y_OFFSET = 140;
    private final String XSD_LOCATION = "classpath:dmp.xsd";
    private SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    private static final String TEMPLATE_XSD_FILE_NAME = new String("dmp.xsd");

    @Override
    public DmpModel validateAndUnmarshalModelInstance(String xml) throws DataModelInstanceValidationException {

        // validate xml against xsd specification
        try{

            URL schemaFile = new URL(XSD_LOCATION);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();

            final List<SAXParseException> exceptions = new LinkedList<SAXParseException>();
            validator.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    exceptions.add(exception);
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    exceptions.add(exception);
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    exceptions.add(exception);
                }
            });

            validator.validate(new StreamSource(new StringReader(xml)));

            //if validation errors found -> throw exception
            if (!exceptions.isEmpty()){
                String concat = "";
                for (SAXParseException exception : exceptions) {
                    concat += exception + "\n";
                }
                throw new DataModelInstanceValidationException(concat);
            }

        } catch (SAXException e) {
            throw new DataModelInstanceValidationException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }


        DataManagementPlan dmp = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Schema schema = sf.newSchema(new File(classLoader.getResource(TEMPLATE_XSD_FILE_NAME).getFile()));

            JAXBContext jc = JAXBContext.newInstance(DataManagementPlan.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(schema);

            //unmarshal xml
            StringReader reader = new StringReader(xml);
            dmp = (DataManagementPlan) unmarshaller.unmarshal(reader);
        }catch(Exception e){
            e.printStackTrace();
        }

        // create and return model
        return transform(dmp);
    }

    private DmpModel transform(DataManagementPlan dmpXml){

        DmpModel dmpJson = new DmpModel();

        if (dmpXml != null){

            dmpJson.setNodeKeyProperty("id");
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX)+" "+String.valueOf(locY), "DataManagementPlan"));
            lvl0RootId = id++;

            if (dmpXml.getDataRepository() != null){

                DataRepositoryType dataRepositoryType = dmpXml.getDataRepository();
                dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX)+" "+String.valueOf(locY+=Y_OFFSET), "dataRepository"));
                dmpJson.addLinkDataArray(new LinkDataArray(lvl0RootId, id, "has", -20));
                lvl1RootId = id++;

                if (dataRepositoryType.getDoi() != null){
                    dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX)+" "+String.valueOf(locY+Y_OFFSET), dataRepositoryType.getDoi()));
                    dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id++, "has", -20));
                }

                if (dataRepositoryType.getRepositoryURI() != null){
                    dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), dataRepositoryType.getRepositoryURI()));
                    dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id++, "has", -20));
                }
            }

            if (dmpXml.getEthicsPrivacy() != null && !dmpXml.getEthicsPrivacy().isEmpty()){
                List<EthicsPrivacyType> ethicsPrivacyTypeList = dmpXml.getEthicsPrivacy();
                dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "ethicsPrivacy"));
                dmpJson.addLinkDataArray(new LinkDataArray(lvl0RootId, id, "has", -20));
                lvl1RootId = id++;
                for (EthicsPrivacyType ethicsPrivacyType : ethicsPrivacyTypeList) {
                    if (ethicsPrivacyType.getIssue() != null && ethicsPrivacyType.getSolution() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), ethicsPrivacyType.getIssue()));
                        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id++, "has", -20));
                        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), ethicsPrivacyType.getSolution()));
                        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id++, "has", -20));
                    }
                }
            }

            if (dmpXml.getRolesAndResponsibilities() != null && !dmpXml.getRolesAndResponsibilities().isEmpty()){
                List<RolesAndResponsibilitiesType> rolesAndResponsibilities = dmpXml.getRolesAndResponsibilities();
                dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "rolesAndResponsibilities"));
                dmpJson.addLinkDataArray(new LinkDataArray(lvl0RootId, id, "has", -20));
                lvl1RootId = id++;
                for (RolesAndResponsibilitiesType responsibilitiesType : rolesAndResponsibilities) {
                    if (responsibilitiesType.getRoleName() != null && responsibilitiesType.getResponsibilitiesDescription() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), responsibilitiesType.getRoleName()));
                        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id++, "has", -20));
                        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), responsibilitiesType.getResponsibilitiesDescription()));
                        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id++, "has", -20));
                    }
                }
            }

            if (dmpXml.getBudget() != null && !dmpXml.getBudget().isEmpty()){
                List<BudgetType> budgetTypeList = dmpXml.getBudget();
                dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "budget"));
                dmpJson.addLinkDataArray(new LinkDataArray(lvl0RootId, id, "has", -20));
                lvl1RootId = id++;
                for (BudgetType budgetType : budgetTypeList) {
                    if (budgetType.getPosition() != null && budgetType.getCurrency() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), budgetType.getPosition()));
                        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id++, "has", -20));
                        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), String.valueOf(budgetType.getCosts())));
                        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id++, "has", -20));
                        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), budgetType.getCurrency()));
                        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id++, "has", -20));

                    }
                }
            }

            if (dmpXml.getExperimentFile() != null){
                ExperimentFile experimentFile = dmpXml.getExperimentFile();
                dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "experimentFile"));
                dmpJson.addLinkDataArray(new LinkDataArray(lvl0RootId, id, "has", -20));
                lvl1RootId = id++;

                if (experimentFile.getMetadata() != null){
                    addMetaData(experimentFile.getMetadata(), dmpJson);
                }
                if (experimentFile.getPreservation() != null){
                    addPreservaion(experimentFile.getPreservation(), dmpJson);
                }
                if (experimentFile.getDataVolume() != null){
                    addDataVolume(experimentFile.getDataVolume(), dmpJson);
                }
                locY-=Y_OFFSET;
            }

            if (dmpXml.getSourceCode() != null){
                SourceCode sourceCode = dmpXml.getSourceCode();
                dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "sourceCode"));
                dmpJson.addLinkDataArray(new LinkDataArray(lvl0RootId, id, "has", -20));
                lvl1RootId = id++;

                if (sourceCode.getMetadata() != null){
                    addMetaData(sourceCode.getMetadata(), dmpJson);
                }
                if (sourceCode.getPreservation() != null){
                    addPreservaion(sourceCode.getPreservation(), dmpJson);
                }
                if (sourceCode.getDataVolume() != null){
                    addDataVolume(sourceCode.getDataVolume(), dmpJson);
                }
                if (sourceCode.getDocumentation() != null){
                    dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "documentation"));
                    dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id, "has", -20));
                    lvl2RootId = id++;

                    dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), sourceCode.getDocumentation().getType()));
                    dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
                    dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), sourceCode.getDocumentation().getLocation()));
                    dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
                }
                if (sourceCode.getIntellectualPropertyRights() != null){
                    dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "intellectualPropertyRights"));
                    dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id, "has", -20));
                    lvl2RootId = id++;

                    dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), sourceCode.getIntellectualPropertyRights().getLicense()));
                    dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));

                }
            }

        }

        return dmpJson;
    }

    private void addMetaData(MetadataType metadataType, DmpModel dmpJson){
        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY+=Y_OFFSET), "metadata"));
        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id, "has", -20));
        lvl2RootId = id++;
        if (metadataType.getDcFormat() != null){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcFormat()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        if (metadataType.getDcMimeType() != null){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcMimeType()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        if (metadataType.getDcEncoding() != null){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcEncoding()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        if (metadataType.getDcTitle() != null){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcTitle()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        if (metadataType.getDcDescription() != null){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcDescription()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        if (metadataType.getDcCreator() != null){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcCreator()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        if (metadataType.getDcSource() != null){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcSource()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        if (metadataType.getDcDate() != null){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcDate().toString()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
    }

    private void addPreservaion(PreservationType preservationType, DmpModel dmpJson){
        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "preservation"));
        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id, "has", -20));
        lvl2RootId = id++;
        if (preservationType.getBackupStorageURI() != null && !preservationType.getBackupStorageURI().isEmpty()){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), preservationType.getBackupStorageURI()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        if (preservationType.getBackupsInCronFormat() != null && !preservationType.getBackupsInCronFormat().isEmpty()){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), preservationType.getBackupsInCronFormat()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), String.valueOf(preservationType.getRetentionDurationInDays())));
        dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
    }

    private void addDataVolume(DataVolumeType dataVolumeType, DmpModel dmpJson){
        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "dataVolume"));
        dmpJson.addLinkDataArray(new LinkDataArray(lvl1RootId, id, "has", -20));
        lvl2RootId = id++;
        if (dataVolumeType.getUnit() != null){
            dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), dataVolumeType.getUnit().value()));
            dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
        }
        dmpJson.addNodeDataArray(new NodeDataArray(id, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), String.valueOf(dataVolumeType.getAmount())));
        dmpJson.addLinkDataArray(new LinkDataArray(lvl2RootId, id++, "has", -20));
    }

}

