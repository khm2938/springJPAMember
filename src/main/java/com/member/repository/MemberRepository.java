package com.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
