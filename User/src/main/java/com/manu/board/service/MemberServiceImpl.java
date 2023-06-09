package com.manu.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.manu.board.dto.MemberDTO;
import com.manu.board.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper membermapper;
	
	@Override
    public void memberJoin(MemberDTO memberDTO) throws Exception {
		
		membermapper.memberJoin(memberDTO);
		
	}
	
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return membermapper.memberLogin(memberDTO);
	}
}
