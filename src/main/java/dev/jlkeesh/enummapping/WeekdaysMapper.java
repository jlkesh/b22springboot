package dev.jlkeesh.enummapping;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeekdaysMapper {

    WeekdaysMapper WEEKDAYS_MAPPER = Mappers.getMapper(WeekdaysMapper.class);



    @ValueMapping(target = "MONDAY", source = "DUSHANBA")
    @ValueMapping(target = "TUESDAY", source = "SESHANBA")
    @ValueMapping(target = "WEDNESDAY", source = "CHORSHANBA")
    @ValueMapping(target = "SUNDAY", source = "YAKSHANBA")
    WEEKDAYS toEn(HAFTAKUNLARI haftakunlari);


    @EnumMapping(nameTransformationStrategy = "suffix", configuration = "_TYPE")
    CheeseTypeSuffixed map(CheeseType cheese);

    @InheritInverseConfiguration
    CheeseType map(CheeseTypeSuffixed cheese);


}
