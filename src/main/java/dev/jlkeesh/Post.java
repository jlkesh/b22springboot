package dev.jlkeesh;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Post {
    private UUID id;
    private String title;
    private String body;
}
