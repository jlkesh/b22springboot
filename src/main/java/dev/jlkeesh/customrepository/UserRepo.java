package dev.jlkeesh.customrepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {


    private final EntityManager entityManager;

    public UserRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public List<User> saveAll(List<User> users) {
        users.forEach(this::save);
        return users;
    }

    public List<User> getAll() {
        return entityManager.createQuery("from User ", User.class)
                .getResultList();
    }
}
