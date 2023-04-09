package dev.jlkeesh.enummapping;

import org.junit.jupiter.api.Test;

import static dev.jlkeesh.enummapping.WeekdaysMapper.WEEKDAYS_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class WeekdaysMapperTest {

    @Test
    void toEn() {
        System.out.println("weekdays = " + WEEKDAYS_MAPPER.toEn(HAFTAKUNLARI.CHORSHANBA));
        System.out.println("weekdays = " + WEEKDAYS_MAPPER.toEn(HAFTAKUNLARI.DUSHANBA));
        System.out.println("weekdays = " + WEEKDAYS_MAPPER.toEn(HAFTAKUNLARI.YAKSHANBA));
        System.out.println(WEEKDAYS_MAPPER.map(CheeseType.ROQUEFORT));
        System.out.println(WEEKDAYS_MAPPER.map(CheeseTypeSuffixed.BRIE_TYPE));
    }
}