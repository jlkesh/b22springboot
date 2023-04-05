package dev.jlkeesh.item;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final AtomicInteger counter = new AtomicInteger(1);

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item dto) {
        Item post = new Item(counter.getAndIncrement(), dto.getName(), dto.getDescription(), dto.getPrice());
        return ResponseEntity.status(201).body(post);
    }

    @GetMapping("/")
    public ResponseEntity<List<Item>> getAll() {
        return ResponseEntity.ok(List.of(new Item(1, "Magic Item", "Magic Item Body", 500.40)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable Integer id) {
        return ResponseEntity.ok(new Item(id, "Magic Item", "Magic Item Body", 500.40));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Integer id, @RequestBody Item dto) {
        Item post = new Item(counter.getAndIncrement(), dto.getName(), dto.getDescription(), dto.getPrice());
        return ResponseEntity.ok(post);
    }


}
