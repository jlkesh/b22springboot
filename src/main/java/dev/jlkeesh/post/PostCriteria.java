package dev.jlkeesh.post;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springdoc.core.annotations.ParameterObject;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ParameterObject
public class PostCriteria {
    private String title;
    private String body;
    private LocalDateTime publishedAt;
    private boolean published;
    private Boolean archived;
    private PostType type;
    @Parameter(required = true, example = "1")
    @Min(10)
    private int wordCount;

    public enum PostType {
        SPORT, HEALTH, EDUCATION, TECHNOLOGIES
    }
}
