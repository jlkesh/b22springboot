package dev.jlkeesh.person;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private String street;
    private String apartment;
}
