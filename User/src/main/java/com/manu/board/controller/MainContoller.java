package com.manu.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainContoller {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@GetMapping("/main")
	public String home() {
		logger.info("홈페이지 진입");
		return "main";
	}
}
