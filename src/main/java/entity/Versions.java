package entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Versions {
    private Certificate certificate;
    private Package medicalPackage;
    private Dosage dosage;
}
