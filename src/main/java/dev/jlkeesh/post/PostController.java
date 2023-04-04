package dev.jlkeesh.post;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;
    private final PagedResourcesAssembler<Post> pagedResourcesAssembler;
    private final PostModelAssembler postModelAssembler;

    public PostController(PostRepository postRepository,
                          PagedResourcesAssembler<Post> pagedResourcesAssembler,
                          PostModelAssembler postModelAssembler) {
        this.postRepository = postRepository;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.postModelAssembler = postModelAssembler;
    }

    @GetMapping("/")
    public CollectionModel<EntityModel<Post>> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return postModelAssembler.toCollectionModel(posts);
    }

    @GetMapping("/{id}")
    public EntityModel<Post> getPost(@PathVariable Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return postModelAssembler.toModel(post);
    }

    @GetMapping("/paged")
    public PagedModel<EntityModel<Post>> getPageable(
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> postPage = postRepository.findAll(pageable);
        return pagedResourcesAssembler.toModel(postPage, postModelAssembler);
    }


    /*@GetMapping("/rm/{id}")
    public Post getRmPost(@PathVariable Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        post.add(linkTo(methodOn(PostController.class).getRmPost(post.getId())).withSelfRel(),
                linkTo(methodOn(PostController.class).getRmAllPost()).withRel("posts"));
        return post;
    }

    @GetMapping("/rm/")
    public CollectionModel<Post> getRmAllPost() {
        List<Post> posts = postRepository.findAll();
        List<Post> postList = posts.stream()
                .peek(post -> post.add(linkTo(methodOn(PostController.class).getRmPost(post.getId())).withSelfRel()))
                .toList();
        return CollectionModel.of(postList, linkTo(methodOn(PostController.class).getRmAllPost()).withRel("posts"));
    }*/
}

@Component
class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {

    public EntityModel<Post> toModel(@NonNull Post post) {
        return EntityModel.of(post,
                linkTo(methodOn(PostController.class).getPost(post.getId())).withSelfRel(),
                linkTo(methodOn(PostController.class).getAllPosts()).withRel("posts"));
    }

    @Override
    public CollectionModel<EntityModel<Post>> toCollectionModel(Iterable<? extends Post> entities) {
        List<EntityModel<Post>> postsEntityModel = new ArrayList<>();
        entities.forEach(post -> postsEntityModel.add(toModel(post)));
        return CollectionModel.of(postsEntityModel,
                linkTo(methodOn(PostController.class).getAllPosts()).withRel("posts"));
    }
}

