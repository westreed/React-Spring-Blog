package com.spring.springtest.user.repository;

import com.spring.springtest.domain.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaUserRepository implements UserRepository {

    private final EntityManager entityManager;

    public JpaUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        // PK 값인 id로 조회하기 때문에 find 메소드로 찾을 수 있음
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> result = entityManager.createQuery("select u from User u where u.username = :name", User.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public User delete(User user) {
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        }
        else{
            entityManager.remove(entityManager.merge(user));
        }
        return user;
    }

    @Override
    public Optional<User> deleteById(Long id) {
        Optional<User> user = findById(id);
        user.ifPresent(this::delete);
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> result = entityManager.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();

        return result.stream().findAny();
    }
}
