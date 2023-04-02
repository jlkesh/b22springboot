package dev.jlkeesh.buddy.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * A DTO for the {@link dev.jlkeesh.buddy.Project} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProjectDTO implements Serializable {
    private Long id;
    private String name;
    private String path;
}