package parser;

import commands.*;
import commands.impl.CountCommand;
import commands.impl.ValidateCommand;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Nataly on 07.05.2015.
 */
public class CommandParser extends DefaultHandler {
    private CommandsFactory commandsFactory = CommandsFactory.getInstance();
    private Command cmd;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Command")) {
            boolean enable = Boolean.parseBoolean(attributes.getValue("enable"));
            if (enable) {
                try {
                    Class<?> cls = Class.forName(attributes.getValue("class"));
                    cmd = (Command) cls.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                cmd = null;
            }
        } else if (qName.equalsIgnoreCase("XmlFile")) {
            if (cmd instanceof CountCommand) {
                ((CountCommand) cmd).setXmlFilePath(attributes.getValue("path"));
            } else if (cmd instanceof ValidateCommand) {
                ((ValidateCommand) cmd).setXmlFilePath(attributes.getValue("path"));
            }
        } else if (qName.equalsIgnoreCase("Scheme")) {
            if (cmd instanceof ValidateCommand) {
                ((ValidateCommand) cmd).setSchemeFilePath(attributes.getValue("path"));
            }
        } else if (qName.equalsIgnoreCase("Element")) {
            if (cmd instanceof CountCommand) {
                ((CountCommand) cmd).setElementForCounting(attributes.getValue("name"));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Command") && cmd!=null) {
            commandsFactory.addCommand(cmd);
        }
    }
}
