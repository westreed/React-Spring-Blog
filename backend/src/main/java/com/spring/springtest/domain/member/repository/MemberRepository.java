package com.spring.springtest.domain.member.repository;

import com.spring.springtest.domain.member.eneity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    Member delete(Member member);
    Optional<Member> deleteById(Long id);
    Optional<Member> findByEmail(String email);
}
