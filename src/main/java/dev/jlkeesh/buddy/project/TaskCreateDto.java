package dev.jlkeesh.buddy.project;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Task} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TaskCreateDto implements Serializable {
    @NotNull
    private Integer id;
    private String name;
    private Instant createdAt;
    private ProjectColumnDto projectColumn;

    /**
     * A DTO for the {@link ProjectColumn} entity
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class ProjectColumnDto implements Serializable {
        private Long id;
    }
}