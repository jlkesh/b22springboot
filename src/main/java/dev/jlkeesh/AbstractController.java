package dev.jlkeesh;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractController<R, E> {
    protected final R repository;

    public abstract List<E> getAll();

    public abstract E save(@RequestBody E entity);
}
