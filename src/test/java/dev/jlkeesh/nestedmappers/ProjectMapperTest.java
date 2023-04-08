package dev.jlkeesh.nestedmappers;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static dev.jlkeesh.nestedmappers.ProjectMapper.PROJECT_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class ProjectMapperTest {

    @Test
    void toDto() {
        var pcs = new ArrayList<ProjectColumn>();
        pcs.add(new ProjectColumn("1", "New", 1, LocalDateTime.now()));
        pcs.add(new ProjectColumn("2", "Doing", 2, LocalDateTime.now()));
        pcs.add(new ProjectColumn("3", "Done", 3, LocalDateTime.now()));
        pcs.add(new ProjectColumn("4", "Test", 4, LocalDateTime.now()));
        Project project = new Project("1", "Trello Task Manager", Path.of("file.pdf"), pcs, LocalDateTime.now());
        ProjectDTO dto = PROJECT_MAPPER.toDto(project);
        System.out.println("dto = " + dto);
    }
}