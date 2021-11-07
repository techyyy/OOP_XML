package controlller;

import constants.XmlConstants;
import helpers.XmlStreamReader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class Parser extends XmlStreamReader {

    protected final String fileName;

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true);
        if (validate) {
            saxParserFactory.setFeature(XmlConstants.VALIDATION, true);
            saxParserFactory.setFeature(XmlConstants.VALIDATION_SCHEMA, true);
        }
        SAXParser parser = saxParserFactory.newSAXParser();
        parser.parse(fileName, new SAXHandler());
    }

    private class SAXHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            medicines = new ArrayList<>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            thisElement = qName.trim();
            processCurrentElement();
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String data = new String(ch, start, length).trim();
            processDataForCurrentElement(data);
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName) {
            thisElement = "";
        }

        @Override
        public void error(SAXParseException e) throws SAXParseException {
            throw e;
        }
    }

}
