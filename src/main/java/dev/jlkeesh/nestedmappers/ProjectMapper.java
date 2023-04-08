package dev.jlkeesh.nestedmappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.nio.file.Path;

@Mapper(uses = {
        ProjectColumnMapper.class
})
public interface ProjectMapper {

    ProjectMapper PROJECT_MAPPER = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "ts", target = "ts", qualifiedByName = "pathToString")
    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "dd/MM/YYYY")
    ProjectDTO toDto(Project project);

    @Named("pathToString")
    default String pathToString(Path path) {
        if (path == null) {
            return null;
        }
        return path.toString();
    }

}
