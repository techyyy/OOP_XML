import constants.XmlConstants;
import controlller.Parser;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class ParserTest {

    @Test
    public void parserTestValid() throws ParserConfigurationException, IOException, SAXException {
        Parser parser = new Parser(XmlConstants.VALID_XML_FILE);
        parser.parse(true);
        assertNotNull(parser.getMedicines());
    }

    @Test
    public void parserTestShouldThrowIllegalArgumentException() {
        Parser parser = new Parser(XmlConstants.INVALID_XML_FILE);
        assertThrows(IllegalArgumentException.class, () -> parser.parse(true));
    }

}
