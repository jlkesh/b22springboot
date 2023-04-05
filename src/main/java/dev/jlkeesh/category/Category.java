package dev.jlkeesh.category;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private Integer id;
    private String name;
    private String code;
}
