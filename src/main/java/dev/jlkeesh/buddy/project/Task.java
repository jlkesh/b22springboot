package dev.jlkeesh.buddy.project;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tasks", schema = "springdatajpa_lesson")
@NamedQueries({
        @NamedQuery(name = "Task.existsByNameIgnoreCase", query = "select (count(t) > 0) from Task t where upper(t.name) = upper(:name)")
})
public class Task {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "created_at")
    private Instant createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_column_id")
    private ProjectColumn projectColumn;

}