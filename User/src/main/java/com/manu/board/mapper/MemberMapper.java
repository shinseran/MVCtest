package com.manu.board.mapper;

import com.manu.board.dto.MemberDTO;

public interface MemberMapper {
	
	public void memberJoin(MemberDTO memberDTO);
	
	public MemberDTO memberLogin(MemberDTO memberDTO);

}
