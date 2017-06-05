package at.tuwien.ss17.dp.lab3.datascience.service.impl;

import at.tuwien.ss17.dp.lab3.datascience.exception.DataModelInstanceValidationException;
import at.tuwien.ss17.dp.lab3.datascience.service.DMPModelService;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

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

@Service(value="DMPModelService")
public class DMPModelServiceImpl implements DMPModelService {

    private final String XSD_LOCATION = "classpath:dmp.xsd";

    @Override
    public void validateModelInstance(String xml) throws DataModelInstanceValidationException {

        try{

            URL schemaFile = new URL(XSD_LOCATION);

            ClassLoader classLoader = getClass().getClassLoader();
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

    }

}
