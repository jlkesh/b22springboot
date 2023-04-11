package dev.jlkeesh;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/post")
@Slf4j
public class SimpleController {

    private List<Post> posts = new ArrayList<>();

    @PostMapping
    public Post post(@RequestBody Post post) {
        post.setId(UUID.randomUUID());
        posts.add(post);
        log.info("Post created : {}", post);
        return post;
    }

    @GetMapping
    public List<Post> getAll() {
        log.info("Posts requested");
        return posts;
    }
}
