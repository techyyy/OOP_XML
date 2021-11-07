package constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Medicals {

    /* element names */
    MEDICINES("medicines"),
    MEDICINE("medicine"),
    NAME("name"),
    PHARMACY("pharmacy"),
    GROUP("group"),
    ANALOGUES("analogues"),
    ANALOG_NAME("analogueName"),
    VERSIONS("versions"),
    VERSION("version"),
    CERTIFICATE("certificate"),
    NUMBER("number"),
    START_DATE("startDate"),
    EXPIRATION_DATE("expirationDate"),
    REGISTERED_BY("registeredBy"),
    PACKAGE("package"),
    PACKAGE_TYPE("packageType"),
    AMOUNT("amount"),
    PRICE("price"),
    DOSAGE("dosage"),
    VALUE("value"),
    PERIOD("period");

    private final String value;

    public String value() {
        return value;
    }
}
