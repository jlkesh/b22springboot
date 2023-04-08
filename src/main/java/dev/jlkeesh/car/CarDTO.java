package dev.jlkeesh.car;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
        private Integer id;
        private String carName;
        private Double price;
        private String logo;
}
