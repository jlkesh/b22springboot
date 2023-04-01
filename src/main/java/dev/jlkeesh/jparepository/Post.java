package dev.jlkeesh.jparepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
