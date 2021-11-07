package entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Certificate {
    private int number;
    private Date startDate;
    private Date expirationDate;
    private String registeredBy;
}