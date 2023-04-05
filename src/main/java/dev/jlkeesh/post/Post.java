package dev.jlkeesh.post;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    private Integer id;
    private String title;
    private String body;
}
