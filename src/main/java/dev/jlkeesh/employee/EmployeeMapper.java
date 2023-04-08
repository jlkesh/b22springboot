package dev.jlkeesh.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Random;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id", defaultExpression = "java(generateID())")
            /*@Mapping(target = "address.street", source = "streetName"),
            @Mapping(target = "address.apartment", source = "apartment"),
            @Mapping(target = "passport.serial", source = "passportSerial"),
            @Mapping(target = "passport.number", source = "passportNumber"),*/
    })
    Employee toEntity(EmployeeDTO dto);


    default Integer generateID() {
        return new Random().nextInt(1, 1000);
    }
}
