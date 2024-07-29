package com.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
//	사용자가 ~~~/temp라고 요청하면 
//	temp.jsp가 응답되도록
	@RequestMapping("/temp")
	public String temp() {
//		1. 데이터 수집
//		2. 기능 실행
//		3. view 선택(페이지 이동)
		
		return "temp";
	}
	
	
}
