package com.manu.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manu.board.dto.MemberDTO;
import com.manu.board.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberservice;

	@GetMapping("/join")
	public void joinForm() {
		logger.info("회원가입페이지 진입");
		
	}
	
	@PostMapping("/join")
	public String joinPost(MemberDTO memberDTO) throws Exception{
		
		logger.info("회원가입 진입");
		
		memberservice.memberJoin(memberDTO);
		
		logger.info("회원가입 서비스 성공");
		
		return "redirect:/main";
	}
	
	@GetMapping("/login")
	public void loginForm() {
		
		logger.info("로그인페이지 진입");
		
	}
	
	 /* 로그인 */
    @PostMapping("/login")
    public String loginPOST(HttpServletRequest request, MemberDTO memberDTO, RedirectAttributes rttr) throws Exception{
        
        System.out.println("login 메서드 진입"); //성공하면 주석처리하기
        System.out.println("전달된 데이터 : " + memberDTO);//성공하면 주석처리하기
        
        HttpSession session = request.getSession();
        MemberDTO DTO =memberservice.memberLogin(memberDTO);
        
        if(DTO == null) {//일치하지 않는 아이디,비밀번호 입력경우
        	int result =0;
        	rttr.addFlashAttribute("result", result);
        	return "redirect:/member/login";
        }
        session.setAttribute("memberDTO", DTO); //로그인 성공시 
        return "redirect:/main";
        
    }
    /* 메인페이지 로그아웃 */
    @GetMapping("/logout")
    public String logoutMainGET(HttpServletRequest request) throws Exception{
    	logger.info("logoutMainGET메서드 진입");
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        return "redirect:/main"; 
    }
	
}
