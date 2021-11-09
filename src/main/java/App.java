import constants.XmlConstants;
import controlller.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        // Valid XML input
        Parser saxParser = new Parser(XmlConstants.VALID_XML_FILE);

        // Execute parsing with validation enabled
        saxParser.parse(true);
        System.out.printf(XmlConstants.VALID_OUTPUT, saxParser.getMedicines());

        // Parsing an invalid XML
        try {
            saxParser = new Parser(XmlConstants.INVALID_XML_FILE);
            saxParser.parse(true);
        } catch (Exception e) {
            System.err.printf(XmlConstants.INVALID_OUTPUT, e.getMessage(), saxParser.getMedicines());
        }

    }
}
