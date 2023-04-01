package dev.jlkeesh.jparepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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

    @GetMapping("/users/{userIds}")
    public List<Post> postsByUsers(@PathVariable Collection<Integer> userIds) {
        return postRepository.findAlByUsers(userIds);
    }

    @GetMapping("/sort")
    public List<Post> postsSort1() {
        Sort sort = Sort.by(Sort.Direction.DESC, "userId")
                .and(Sort.by(Sort.Direction.DESC, "title"));
        Sort sortWithOrder = Sort.by(Sort.Order.desc("userId"));
        return postRepository.findAll(sortWithOrder);
    }

    @GetMapping("/pagination")
    public Page<Post> page(@RequestParam(required = false, defaultValue = "10") Integer size,
                           @RequestParam(required = false, defaultValue = "0") Integer page) {
        Sort sort = Sort.by(Sort.Direction.DESC, "user_id" /*"userId" => JPQL*/)
                .and(Sort.by(Sort.Direction.DESC, "title"));
        Pageable pageable = PageRequest.of(page, size, sort);
        /*return postRepository.findAll(pageable);*/
        /*return postRepository.getAll(pageable);*/
        return postRepository.getAllWithNativeQuery(pageable);
    }


}
