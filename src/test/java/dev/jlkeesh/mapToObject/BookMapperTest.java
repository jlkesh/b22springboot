package dev.jlkeesh.mapToObject;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static dev.jlkeesh.mapToObject.BookMapper.BOOK_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    void toBook() {
        Map<String, Object> params = new HashMap<>();
        params.put("id", UUID.randomUUID().toString());
        params.put("name", "Bobomdan Qolgan Dalalar");
        params.put("author", "Primqul Qodirov");
        params.put("publishedDate", LocalDate.of(1990, 1, 1));
        Book book = BOOK_MAPPER.toBook(params);
        System.out.println("book = " + book);
    }
}