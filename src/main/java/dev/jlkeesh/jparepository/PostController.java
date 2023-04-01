package dev.jlkeesh.jparepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @GetMapping(produces = {"application/json", "application/xml"})
    public List<Post> postList() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post postList(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/{userId}")
    public List<Post> postsByUserID(@PathVariable Integer userId) {
        return postRepository.findAlByUserId(userId);
    }


}
