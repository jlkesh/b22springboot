package dev.jlkeesh;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HomeController {

    private AtomicInteger counter = new AtomicInteger(1);
    private List<Todo> todos = new ArrayList<>() {{
        add(new Todo(counter.getAndIncrement(), "Read A Book About Titanic", "HIGH"));
        add(new Todo(counter.getAndIncrement(), "Watch Quantamania", "MEDIUM"));
    }};

    @GetMapping(value = "/todo/all",
            produces = {"application/xml", "application/json"}
    )
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok()
                /*.contentLength(300000)*/
                /*.contentType(MediaType.APPLICATION_XML)*/
                .body(todos);
    }

    @GetMapping(value = "/todo/{id}", produces = {"application/xml", "application/json"})
    public ResponseEntity<Todo> get(@PathVariable Integer id) {
        var todo = todos.stream().filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Todo not found"));
        return ResponseEntity.ok()
                .body(todo);
    }

    @PostMapping(value = "/todo", consumes = "application/json")
    /*@ResponseStatus(HttpStatus.CREATED)*/
    public ResponseEntity<Todo> create(@Valid @RequestBody Todo todo) {
        todo.setId(counter.getAndIncrement());
        todos.add(todo);
//        return new ResponseEntity<>(todo, HttpStatus.CREATED);
        return ResponseEntity.status(201).body(todo);
    }

    /*   @ExceptionHandler(ItemNotFoundException.class)
       public ResponseEntity<Object> handler_404(ItemNotFoundException e, HttpServletRequest request) {
           String requestURI = request.getRequestURI();
           Map<String, Object> error = new HashMap<>();
           error.put("error_core", 404);
           error.put("error_message", e.getMessage());
           error.put("error_path", requestURI);
           error.put("timestamp", LocalDateTime.now());
           return ResponseEntity.status(404).body(error);
       }
   */



}

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Todo {
    private Integer id;

    @Size(min = 10)
    @NotBlank
    private String title;
    @NotBlank
    private String level;
}