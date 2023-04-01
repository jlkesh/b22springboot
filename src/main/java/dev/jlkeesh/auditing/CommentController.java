package dev.jlkeesh.auditing;

import dev.jlkeesh.AbstractController;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController extends AbstractController<CommentRepository, Comment> {

    public CommentController(CommentRepository repository) {
        super(repository);
    }

    @GetMapping
    public List<Comment> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Comment save(Comment entity) {
        return repository.save(entity);
    }
}
