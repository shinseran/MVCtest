package com.manu.board.service;




import org.springframework.stereotype.Service;

import com.manu.board.dto.MemberDTO;


@Service
public interface MemberService {
	
	
	public void memberJoin(MemberDTO memberDTO) throws Exception;
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;

	
}
