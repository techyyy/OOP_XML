package constants;

public final class XmlConstants {
    public static final String VALID_XML_FILE = "input.xml";
    public static final String INVALID_XML_FILE = "invalid-input.xml";
    public static final String VALIDATION = "http://xml.org/sax/features/validation";
    public static final String VALIDATION_SCHEMA = "http://apache.org/xml/features/validation/schema";
    private static final String LINE_SPLIT = "------------------------------------------%n";
    public static final String VALID_OUTPUT = LINE_SPLIT + "Available medicals: %s%n" + LINE_SPLIT;
    public static final String INVALID_OUTPUT = LINE_SPLIT
            + "Validation has failed: %s%n"
            + "Available medicals: %s%n"
            + LINE_SPLIT;
}
