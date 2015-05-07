package parser;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Nataly on 07.05.2015.
 */
public class CountParser extends DefaultHandler {
    private String elementForCounting;
    private int count;

    public void setElementForCounting(String elementForCounting) {
        this.elementForCounting = elementForCounting;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(elementForCounting.trim())) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
