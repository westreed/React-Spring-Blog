package com.spring.springtest.member.repository;

import com.spring.springtest.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager entityManager;

    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // PK 값인 id로 조회하기 때문에 find 메소드로 찾을 수 있음
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = entityManager.createQuery("select m from Member m where m.username = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public Member delete(Member member) {
        if (entityManager.contains(member)) {
            entityManager.remove(member);
        }
        else{
            entityManager.remove(entityManager.merge(member));
        }
        return member;
    }

    @Override
    public Optional<Member> deleteById(Long id) {
        Optional<Member> user = findById(id);
        user.ifPresent(this::delete);
        return user;
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        List<Member> result = entityManager.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();

        return result.stream().findAny();
    }
}
