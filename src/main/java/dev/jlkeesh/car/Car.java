package dev.jlkeesh.car;

import lombok.*;

import java.io.File;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    private Integer id;
    private String name;
    private String maker;
    private Double price;
    private File logo;
}
