package dev.jlkeesh.jparepository;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NamedQuery(
        query = "from Post t where t.userId = :userId",
        name = "get_posts_by_userid_jpql"
)
@NamedQuery(
        query = "from Post t where t.userId in (:userIds)",
        name = "get_posts_by_userids_jpql"
)
@NamedNativeQuery(
        query = "select t.* from post t where t.user_id = ?1",
        name = "get_posts_by_userid",
        resultClass = Post.class)
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
