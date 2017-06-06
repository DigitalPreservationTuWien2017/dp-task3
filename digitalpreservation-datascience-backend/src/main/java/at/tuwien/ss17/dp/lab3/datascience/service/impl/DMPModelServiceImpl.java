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

    private final String XSD_LOCATION = "classpath:dmp.xsd";
    private SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    private static final String TEMPLATE_XSD_FILE_NAME = new String("dmp.xsd");

    @Override
    public DmpModel validateAndUnmarshalModelInstance(String xml) throws DataModelInstanceValidationException {

        // VALIDATE
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


        // UNMARSHAL
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

        // CREATE MODEL
        // TODO transform unmarshalled xml to "at.tuwien.ss17.dp.lab3.datascience.model.dmp.json" and return it

        return transform(dmp);



    }

    private DmpModel transform(DataManagementPlan dmpXml){

        int id = 0;
        int locX = 120;
        int locY = 120;
        final int X_OFFSET = 140;
        final int Y_OFFSET = 140;

        DmpModel dmpJson = new DmpModel();

        if (dmpXml != null){

            dmpJson.setNodeKeyProperty("id");
            dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX)+" "+String.valueOf(locY), "DataManagementPlan"));

            if (dmpXml.getDataRepository() != null){

                DataRepositoryType dataRepositoryType = dmpXml.getDataRepository();
                dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX)+" "+String.valueOf(locY+=Y_OFFSET), "dataRepository"));

                if (dataRepositoryType.getDoi() != null){
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX)+" "+String.valueOf(locY+Y_OFFSET), dataRepositoryType.getDoi()));
                }

                if (dataRepositoryType.getRepositoryURI() != null){
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), dataRepositoryType.getRepositoryURI()));
                }

            }

            if (dmpXml.getEthicsPrivacy() != null && !dmpXml.getEthicsPrivacy().isEmpty()){
                List<EthicsPrivacyType> ethicsPrivacyTypeList = dmpXml.getEthicsPrivacy();
                dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "ethicsPrivacy"));
                for (EthicsPrivacyType ethicsPrivacyType : ethicsPrivacyTypeList) {
                    if (ethicsPrivacyType.getIssue() != null && ethicsPrivacyType.getSolution() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), ethicsPrivacyType.getIssue()));
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), ethicsPrivacyType.getSolution()));

                    }
                }
            }

            if (dmpXml.getRolesAndResponsibilities() != null && !dmpXml.getRolesAndResponsibilities().isEmpty()){
                List<RolesAndResponsibilitiesType> rolesAndResponsibilities = dmpXml.getRolesAndResponsibilities();
                dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "rolesAndResponsibilities"));
                for (RolesAndResponsibilitiesType responsibilitiesType : rolesAndResponsibilities) {
                    if (responsibilitiesType.getRoleName() != null && responsibilitiesType.getResponsibilitiesDescription() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), responsibilitiesType.getRoleName()));
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), responsibilitiesType.getResponsibilitiesDescription()));

                    }
                }
            }

            if (dmpXml.getBudget() != null && !dmpXml.getBudget().isEmpty()){
                List<BudgetType> budgetTypeList = dmpXml.getBudget();
                dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "budget"));
                for (BudgetType budgetType : budgetTypeList) {
                    if (budgetType.getPosition() != null && budgetType.getCurrency() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), budgetType.getPosition()));
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), String.valueOf(budgetType.getCosts())));
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), budgetType.getCurrency()));

                    }
                }
            }

            if (dmpXml.getExperimentFile() != null){
                ExperimentFile experimentFile = dmpXml.getExperimentFile();
                dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "experimentFile"));

                if (experimentFile.getMetadata() != null){
                    MetadataType metadataType = experimentFile.getMetadata();
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY+=Y_OFFSET), "metadata"));
                    if (metadataType.getDcFormat() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcFormat()));
                    }
                    if (metadataType.getDcMimeType() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcMimeType()));
                    }
                    if (metadataType.getDcEncoding() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcEncoding()));
                    }
                    if (metadataType.getDcTitle() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcTitle()));
                    }
                    if (metadataType.getDcDescription() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcDescription()));
                    }
                    if (metadataType.getDcCreator() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcCreator()));
                    }
                    if (metadataType.getDcSource() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcSource()));
                    }
                    if (metadataType.getDcDate() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcDate().toString()));
                    }
                }

                if (experimentFile.getPreservation() != null){
                    PreservationType preservationType = experimentFile.getPreservation();
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "preservation"));
                    if (preservationType.getBackupStorageURI() != null && !preservationType.getBackupStorageURI().isEmpty()){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), preservationType.getBackupStorageURI()));
                    }
                    if (preservationType.getBackupsInCronFormat() != null && !preservationType.getBackupsInCronFormat().isEmpty()){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), preservationType.getBackupsInCronFormat()));
                    }
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), String.valueOf(preservationType.getRetentionDurationInDays())));
                }

                if (experimentFile.getDataVolume() != null){
                    DataVolumeType dataVolumeType = experimentFile.getDataVolume();
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "dataVolume"));
                    if (dataVolumeType.getUnit() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), dataVolumeType.getUnit().value()));
                    }
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), String.valueOf(dataVolumeType.getAmount())));
                }
                locY-=Y_OFFSET;
            }

            if (dmpXml.getSourceCode() != null){
                SourceCode sourceCode = dmpXml.getSourceCode();
                dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "sourceCode"));

                if (sourceCode.getMetadata() != null){
                    MetadataType metadataType = sourceCode.getMetadata();
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY+=Y_OFFSET), "metadata"));
                    if (metadataType.getDcFormat() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcFormat()));
                    }
                    if (metadataType.getDcMimeType() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcMimeType()));
                    }
                    if (metadataType.getDcEncoding() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcEncoding()));
                    }
                    if (metadataType.getDcTitle() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcTitle()));
                    }
                    if (metadataType.getDcDescription() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcDescription()));
                    }
                    if (metadataType.getDcCreator() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcCreator()));
                    }
                    if (metadataType.getDcSource() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcSource()));
                    }
                    if (metadataType.getDcDate() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), metadataType.getDcDate().toString()));
                    }
                }
                if (sourceCode.getPreservation() != null){
                    PreservationType preservationType = sourceCode.getPreservation();
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "preservation"));
                    if (preservationType.getBackupStorageURI() != null && !preservationType.getBackupStorageURI().isEmpty()){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), preservationType.getBackupStorageURI()));
                    }
                    if (preservationType.getBackupsInCronFormat() != null && !preservationType.getBackupsInCronFormat().isEmpty()){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), preservationType.getBackupsInCronFormat()));
                    }
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), String.valueOf(preservationType.getRetentionDurationInDays())));
                }
                if (sourceCode.getDataVolume() != null){
                    DataVolumeType dataVolumeType = sourceCode.getDataVolume();
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "dataVolume"));
                    if (dataVolumeType.getUnit() != null){
                        dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), dataVolumeType.getUnit().value()));
                    }
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), String.valueOf(dataVolumeType.getAmount())));
                }
                if (sourceCode.getDocumentation() != null){
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "documentation"));
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), sourceCode.getDocumentation().getType()));
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+=X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), sourceCode.getDocumentation().getLocation()));
                }
                if (sourceCode.getIntellectualPropertyRights() != null){
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY), "intellectualPropertyRights"));
                    dmpJson.addNodeDataArray(new NodeDataArray(id++, String.valueOf(locX+X_OFFSET)+" "+String.valueOf(locY+Y_OFFSET), sourceCode.getIntellectualPropertyRights().getLicense()));

                }
            }


        }

        dmpJson.addLinkDataArray(new LinkDataArray(0, 1, "has", -20));





        return dmpJson;
    }

}

