package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Member;
import com.smhrd.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository repo;
	
//	사용자가 ~~~/temp라고 요청하면 
//	temp.jsp가 응답되도록
	@RequestMapping("/temp")
	public String temp() {
//		1. 데이터 수집
//		2. 기능 실행
//		3. view 선택(페이지 이동)
		
		return "temp";
	}
	
	@RequestMapping("/main")
	public String goMain() {
		
		return "main";
	}
	@RequestMapping("/join")
	public String join(Member member) {
		repo.save(member);
		
		
		return "redirect:/main";
	}	
	
	@RequestMapping("/login")
	public String login(String email,String pw, HttpSession session) {
		
		Member member = repo.findByEmailAndPw(email, pw);
//		Spring Boot 2.x : javax
//		Spring Boot 3.x : jakarta
//		HttpSession 임포트 시 , 패키지 명을 잘 확인하고 임포트 하거나 
//		ctrl + shift + o 단축키로 임포트해서 
		if(member !=null) {
			session.setAttribute("user", member);
		}
		
		return "redirect:/main";
	}
	
//	GetMapping : Get 방식의 요청을 받도록 하는 Mapping
	@GetMapping("/update")
	public void update() {
		// return type 을 void로 지정해도 괜찮다.
		// 단! 
		// return type 이 void인 경우
		// url mapping을 view의 이름으로 간주 
	}
	@PostMapping("/update")
	public String UpdateUser(Member member,HttpSession session) {
		Member user = (Member)session.getAttribute("user");
		member.setEmail(user.getEmail());
		
		repo.save(member);
		session.setAttribute("user", member);
		
		
		return "redirect:/main";
	}
	
	
	
}
