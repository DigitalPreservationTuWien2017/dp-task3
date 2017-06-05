package at.tuwien.ss17.dp.lab3.datascience.service.impl;

import at.tuwien.ss17.dp.lab3.datascience.exception.DataModelInstanceValidationException;
import at.tuwien.ss17.dp.lab3.datascience.model.dmp.javax.DataManagementPlan;
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

        return null;

    }

}
