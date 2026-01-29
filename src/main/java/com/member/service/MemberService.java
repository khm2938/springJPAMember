package com.member.service;

import java.util.List;

import com.member.domain.Member;

public interface MemberService {
	int register(Member member) throws Exception;
	Member read(Member member) throws Exception;
	int modify(Member member) throws Exception;
	int remove(Member member) throws Exception; 
	List<Member> list() throws Exception;
	List<Member> search(String searchType, String keyword)throws Exception;
	Member selectByUserId(String userId);
}
