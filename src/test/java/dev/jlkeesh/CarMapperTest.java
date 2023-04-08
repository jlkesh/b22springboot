package dev.jlkeesh;

import dev.jlkeesh.car.Car;
import dev.jlkeesh.car.CarDTO;
import dev.jlkeesh.car.CarMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.io.File;

class CarMapperTest {

    @Test
    void toEntity() {
        CarMapper carMapper = Mappers.getMapper(CarMapper.class);
        Car car = new Car(1, "Cobalt", "GM", 16000.0, new File("file.txt"));
        CarDTO dto = carMapper.toDto(car);
        System.out.println("dto = " + dto);
        Car magicEntity = carMapper.toEntity(dto);
        System.out.println("magicEntity = " + magicEntity);
    }
}