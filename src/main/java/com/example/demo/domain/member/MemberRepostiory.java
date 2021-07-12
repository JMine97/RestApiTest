package com.example.demo.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepostiory extends JpaRepository<Member, Long> {
}
