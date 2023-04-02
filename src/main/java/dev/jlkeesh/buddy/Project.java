package dev.jlkeesh.buddy;


import dev.jlkeesh.buddy.project.ProjectColumn;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @NotBlank(message = "Project Code can not be black")
    @Column(name = "code", unique = true)
    private String code;

    @NotBlank(message = "can not be blank")
    @Column(name = "path", unique = true)
    private String path;

    @OneToMany(mappedBy = "project", orphanRemoval = true)
    private Collection<ProjectColumn> projectColumns = new ArrayList<>();

}
