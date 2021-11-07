package entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum Group {

    PAINKILLER("Painkiller"),
    SLEEPING_PILLS("Sleeping pills"),
    SEDATIVE("Sedative");

    private final String value;

    public static Group fromValue(String value) {
        for (Group group : Group.values()) {
            if (group.value.equals(value)) {
                return group;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
