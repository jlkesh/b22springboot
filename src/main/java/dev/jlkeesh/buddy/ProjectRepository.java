package dev.jlkeesh.buddy;

import dev.jlkeesh.buddy.dtos.ProjectDTO;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProjectRepository extends ListCrudRepository<Project, Long>, JpaSpecificationExecutor<Project> {
    @Query("select new dev.jlkeesh.buddy.dtos.ProjectDTO(p.id, p.name, p.path) from Project p")
    List<ProjectDTO> projectsInfo();
}