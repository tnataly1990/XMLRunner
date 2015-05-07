package commands.impl;

import commands.Command;
import commands.Commands;
import org.xml.sax.SAXException;
import parser.CountParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by Nataly on 07.05.2015.
 */
public class CountCommand extends Command {
    protected String xmlFilePath;
    protected String elementForCounting;

    @Override
    public void execute() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            CountParser saxp = new CountParser();
            saxp.setElementForCounting(elementForCounting);
            parser.parse(xmlFilePath, saxp);
            System.out.println(elementForCounting + " element found " + saxp.getCount() + " times.");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Commands getType() {
        return Commands.COUNT;
    }

    public String getXmlFilePath() {
        return xmlFilePath;
    }

    public void setXmlFilePath(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    public String getElementForCounting() {
        return elementForCounting;
    }

    public void setElementForCounting(String elementForCounting) {
        this.elementForCounting = elementForCounting;
    }

}
