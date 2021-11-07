package entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Medicine {

    private String name;
    private String pharmacy;
    private Group group;
    private List<String> analogues;
    private List<Versions> versions;

    public List<String> getAnalogues() {
        if (analogues == null) {
            analogues = new ArrayList<>();
        }
        return this.analogues;
    }

    public List<Versions> getVersions() {
        if (versions == null) {
            versions = new ArrayList<>();
        }
        return this.versions;
    }

}