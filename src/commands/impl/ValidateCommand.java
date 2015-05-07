package commands.impl;

import commands.Command;
import commands.Commands;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nataly on 07.05.2015.
 */
public class ValidateCommand extends Command {
    protected String xmlFilePath;
    protected String schemeFilePath;

    public String getXmlFilePath() {
        return xmlFilePath;
    }

    public void setXmlFilePath(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    public String getSchemeFilePath() {
        return schemeFilePath;
    }

    public void setSchemeFilePath(String schemeFilePath) {
        this.schemeFilePath = schemeFilePath;
    }

    @Override
    public void execute() {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(schemeFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));
            System.out.println(schemeFilePath + " file is valid.");
        } catch (IOException | SAXException e) {
            System.out.println(schemeFilePath + " file is not valid.");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Commands getType() {
        return Commands.VALIDATE;
    }
}
