package dev.jlkeesh.mapToObject;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private String id;
    private String name;
    private String author;
    private LocalDate publishedDate;
}
