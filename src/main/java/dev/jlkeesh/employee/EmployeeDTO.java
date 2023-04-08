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
public class EmployeeDTO {


    private Integer id;
    private String fullName;
    private Integer age;

    private Address address;
    private Passport passport;
}
