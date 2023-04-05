package dev.jlkeesh.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Post Create DTO", description = "This DTO used to create new POST")
public class PostCreateDto {
    private String title;
    private String body;
}
