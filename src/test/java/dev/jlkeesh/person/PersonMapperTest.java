package dev.jlkeesh.person;

import org.junit.jupiter.api.Test;

import static dev.jlkeesh.person.PersonMapper.PERSON_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {

    @Test
    void toPerson() {
        Address address = new Address("Amir Temur", "A 104");
        Passport passport = new Passport("AB", "0001122");
        PersonDTO personDTO = new PersonDTO("Nodira Shorahmedova", "20");
        Person person = PERSON_MAPPER.toPerson(personDTO, address, passport);
        System.out.println("person = " + person);

    }
}