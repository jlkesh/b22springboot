package dev.jlkeesh.nestedmappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.nio.file.Path;

@Mapper
public interface ProjectColumnMapper {

    ProjectColumnMapper PROJECT_MAPPER = Mappers.getMapper(ProjectColumnMapper.class);

    @Mapping(source = "name", target = "pc_name")
    @Mapping(source = "order", target = "pc_order")
    @Mapping(source = "createdAt", target = "pc_createdAt",dateFormat = "YYYY-MM-dd")
    ProjectColumnDTO toDto(ProjectColumn projectColumn);

}
