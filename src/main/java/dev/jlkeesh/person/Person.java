package dev.jlkeesh.person;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String fullName;
    private Integer age;

    private String streetName;
    private String apartment;

    private String passportSerial;
    private String passportNumber;
}
