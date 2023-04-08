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
public class Project {
    private String id;
    private String name;
    private Path ts;
    private List<ProjectColumn> projectColumns;
    private LocalDateTime createdAt;
}
