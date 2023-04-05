package dev.jlkeesh.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/posts")
@Tag(
        name = "Post Controller",
        description = "this controller created for playing with post entity"
)
public class PostController {
    private final AtomicInteger counter = new AtomicInteger(1);

    @Operation(summary = "This API used for creating a post",
            description = "This endpoint was designed for creating a post"
            /*,deprecated = true*/)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Post Successfully Created",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Post.class)
                            )
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    })
    })
    @PostMapping
    public ResponseEntity<Post> create(@RequestBody PostCreateDto dto) {
        Post post = new Post(counter.getAndIncrement(), dto.getTitle(), dto.getBody());
        return ResponseEntity.status(201).body(post);
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getAll(PostCriteria criteria) {
        System.out.println(criteria);
        return ResponseEntity.ok(List.of(new Post(1, "Magic Post", "Magic Post Body")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> get(@PathVariable Integer id) {
        return ResponseEntity.ok(new Post(id, "Magic Post", "Magic Post Body"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Integer id, @RequestBody PostUpdateDto dto) {
        Post post = new Post(id, dto.getTitle(), dto.getBody());
        return ResponseEntity.ok(post);
    }


}
