package dev.jlkeesh.nestedmappers;

import lombok.*;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDTO {
    private String id;
    private String name;
    private String ts;
    private List<ProjectColumnDTO> projectColumns;
    private String createdAt;
}
