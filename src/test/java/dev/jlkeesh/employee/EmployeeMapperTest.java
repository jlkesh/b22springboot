package dev.jlkeesh.employee;

import dev.jlkeesh.person.Address;
import dev.jlkeesh.person.Passport;
import org.junit.jupiter.api.Test;

import static dev.jlkeesh.employee.EmployeeMapper.EMPLOYEE_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    @Test
    void toEntity() {
        Address address = new Address("Beruniy B-1", "16-16");
        Passport passport = new Passport("1129090", "AB");
        EmployeeDTO dto = new EmployeeDTO(null, "NurIslom Xasanov", 20, address, passport);
        System.out.println("EMPLOYEE_MAPPER.toEntity(dto) = " + EMPLOYEE_MAPPER.toEntity(dto));
    }
}