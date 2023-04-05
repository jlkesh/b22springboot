package dev.jlkeesh.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final AtomicInteger counter = new AtomicInteger(1);

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category dto) {
        Category post = new Category(counter.getAndIncrement(), dto.getName(), dto.getCode());
        return ResponseEntity.status(201).body(post);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(List.of(new Category(1, "Magic Category", "Magic Category Body")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        return ResponseEntity.ok(new Category(id, "Magic Category", "Magic Category Body"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category dto) {
        Category post = new Category(id, dto.getName(), dto.getCode());
        return ResponseEntity.ok(post);
    }


}
