package dev.jlkeesh.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "fullName", source = "personDTO.name")
    @Mapping(target = "streetName", source = "address.street")
    @Mapping(target = "apartment", source = "address.apartment")
    @Mapping(target = "passportSerial", source = "passport.serial")
    @Mapping(target = "passportNumber", source = "passport.number")
    Person toPerson(PersonDTO personDTO, Address address, Passport passport);
}
