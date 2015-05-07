package run;

import commands.CommandsFactory;
import org.xml.sax.SAXException;
import parser.CommandParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nataly on 07.05.2015.
 */
public class XMLRunner {
    public static void main(String [] arg) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            CommandParser saxp = new CommandParser();
            parser.parse(new File(arg[0]), saxp);
            CommandsFactory.getInstance().runCommand(arg[1]);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
