package dev.jlkeesh.post;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostUpdateDto {
    private String title;
    private String body;
}
