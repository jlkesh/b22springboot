package dev.jlkeesh.post;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public CollectionModel<EntityModel<Post>> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<EntityModel<Post>> entityModels = posts.stream()
                .map(post -> {
                    Link link = linkTo(PostController.class).slash(post.getId()).withSelfRel();
                    return EntityModel.of(post, link);
                })
                .toList();

        URI uri = linkTo(PostController.class).withSelfRel().toUri();
        System.out.println(uri);
        return CollectionModel.of(entityModels, linkTo(PostController.class).withRel("posts"));
    }

    @GetMapping("/{id}")
    public EntityModel<Post> getPost(@PathVariable Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return EntityModel.of(post,
                Link.of("http://localhost:8080/api/posts/" + post.getId()),
                Link.of("http://localhost:8080/api/posts", "posts"));
    }
}
