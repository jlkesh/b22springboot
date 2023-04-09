package dev.jlkeesh.mapToObject;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);

    @MapMapping(
            keyTargetType = String.class,
            valueTargetType = Object.class
    )
    Book toBook(Map<String, Object> params);

    default String ss(Object o){
        return String.valueOf(o);
    }
}
