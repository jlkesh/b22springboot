package dev.jlkeesh.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "postlar", collectionResourceRel = "postlar")
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByTitleIgnoreCase(String title);
}