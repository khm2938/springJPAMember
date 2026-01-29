package com.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.member.dao.MemberDAO;
import com.member.domain.Member;
import com.member.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	@Transactional
	public int register(Member m) throws Exception {
		Member member = memberRepository.save(m);
		return (member != null) ? 1 : 0;
	}

	@Override
	@Transactional(readOnly = true)
	public Member read(Member m) throws Exception {
		return memberRepository.findById(m.getNo()).orElse(null);
	}

	@Override
	@Transactional
	public int modify(Member m) throws Exception {
		Member member = memberRepository.getReferenceById(m.getNo());
		member.setPassword(m.getPassword());
		return (member != null) ? 1 : 0;
	}

	@Override
	@Transactional
	public int remove(Member m) throws Exception {
		int count = 0;
		try {
			if (memberRepository.existsById(b.getNo())) {
				memberRepository.deleteById(b.getNo());
	            count = 1; 
	        }
		} catch (Exception e) {
			log.info(e.toString());
			count = 0;
		}
		return count;
	}
	
	@Override
	public List<Member> list() throws Exception {
		List<Member> memberList = memberRepository.findAll(Sort.by(Direction.DESC, "no"));
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Member> search(String searchType, String keyword) throws Exception {
		// searchType = {userId, name}
		if (searchType.equals("userId")) {
			return memberRepository.findByUserIdContaining(keyword);
		} else if (searchType.equals("name")) {
			return memberRepository.findByNameContaining(keyword);
		} 
		return memberRepository.findAll(Sort.by(Direction.DESC,"no"));
	}

	@Override
	public Member selectByUserId(String userId) {
		return memberDAO.selectByUserId(userId);
	}

}
