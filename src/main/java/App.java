import constants.XmlConstants;
import controlller.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        // Valid XML input
        Parser saxContr = new Parser(XmlConstants.VALID_XML_FILE);

        // Execute parsing with validation enabled
        saxContr.parse(true);
        System.out.printf(XmlConstants.VALID_OUTPUT, saxContr.getMedicines());

        // Parsing an invalid XML
        try {
            saxContr = new Parser(XmlConstants.INVALID_XML_FILE);
            saxContr.parse(true);
        } catch (Exception e) {
            System.err.printf(XmlConstants.INVALID_OUTPUT, e.getMessage(), saxContr.getMedicines());
        }

    }
}
