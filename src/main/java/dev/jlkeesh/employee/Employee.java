package dev.jlkeesh.employee;

import dev.jlkeesh.person.Address;
import dev.jlkeesh.person.Passport;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    private Integer id;
    private String fullName;
    private String age;
    private Address address;
    private Passport passport;
}
