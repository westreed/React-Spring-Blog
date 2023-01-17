package com.spring.springtest.repository;

import com.spring.springtest.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void findTest() {
        List<Member> result = repository.findAll();
        for(Member user : result){
            System.out.println(user.getName());
        }
    }
}
