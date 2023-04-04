package dev.jlkeesh.post.resource;

import dev.jlkeesh.post.Post;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class PostResource extends EntityModel<Post> {

    public PostResource(Post post) {
        super(post);
        add(Link.of("http://localhost:8080/api/posts/" + post.getId()),
                Link.of("http://localhost:8080/api/posts", "posts"));
    }


}
