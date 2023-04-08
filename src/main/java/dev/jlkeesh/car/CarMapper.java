package dev.jlkeesh.car;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.io.File;

@Mapper
public interface CarMapper {

    @Mapping(source = "carName", target = "name")
    @Mapping(source = "logo", target = "logo", qualifiedByName = "logoToFile")
    Car toEntity(CarDTO carDTO);

    @InheritInverseConfiguration
    @Mapping(source = "logo", target = "logo", qualifiedByName = "fileToLogo")
    CarDTO toDto(Car car);

    @Named("fileToLogo")
    default String fileToLogo(File file) {
        if (file == null) {
            return null;
        }
        return file.getName();
    }

    @Named("logoToFile")
    default File logoToFile(String logo) {
        if (logo == null) {
            return null;
        }
        return new File(logo);
    }



    /*default Car toMagicEntity(CarDTO dto) {
        if (dto == null) {
            return null;
        }
        Car car = new Car();
        car.setId(dto.getId());
        car.setName(dto.getName().toUpperCase());
        car.setPrice(dto.getPrice() * 0.3);
        return car;
    }*/

}
