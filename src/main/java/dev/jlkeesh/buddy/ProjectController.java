package dev.jlkeesh.buddy;

import dev.jlkeesh.buddy.dtos.ProjectDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @GetMapping
    public List<ProjectDTO> getAll() {
        return projectRepository.projectsInfo();
    }

}
