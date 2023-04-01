package dev.jlkeesh.auditing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends Auditable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String body;

    @Builder(builderMethodName = "childBuilder")
    public Comment(Long createdBy, Long updateBy, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, String name, String email, String body) {
        super(createdBy, updateBy, createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }
}
