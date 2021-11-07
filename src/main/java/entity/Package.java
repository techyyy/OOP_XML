package entity;

import lombok.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Package {
    private String packageType;
    private int amount;
    private BigDecimal price;
}