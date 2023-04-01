package dev.jlkeesh.jparepository;

import jakarta.validation.constraints.Past;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    /*@Query("from Post t where t.userId = ?1")*/
    /*@Query(value = "select t.* from post t where t.userId = ?1", nativeQuery = true)*/
    /*@Query(nativeQuery = true, name = "get_posts_by_userid")*/
    @Query(name = "get_posts_by_userid_jpql")
    List<Post> findAlByUserId(@Param("userId") Integer userId);

    @Query(name = "get_posts_by_userids_jpql")
    List<Post> findAlByUsers(@Param("userIds") Collection<Integer> userIds);

    @Query(value = "from Post t where t.userId <> 3")
    Page<Post> getAll(Pageable pageable);

    @Query(nativeQuery = true,
            value = "select * from post",
            countQuery = "select count(0) from post"
    )
    Page<Post> getAllWithNativeQuery(Pageable pageable);


}
