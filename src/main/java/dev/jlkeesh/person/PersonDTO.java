package dev.jlkeesh.person;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {
    private String name;
    private String age;
}
