package dev.jlkeesh.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    /*@Query("from Post t where t.userId = ?1")*/
    @Query(value = "select t.* from post t where t.userId = ?1", nativeQuery = true)
    List<Post> findAlByUserId(Integer userId);
}
