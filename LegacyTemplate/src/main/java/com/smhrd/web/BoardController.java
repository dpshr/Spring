package com.smhrd.web;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

// Spring이 해당 파일을 POJO로 인식하기 위한 어노테이션
@Controller
public class BoardController {
	
//	IoC : 제어역전/객체의 생성, 관리를 프로그래머가 수행하는것이 아닌 프레임워크가 수행
	
//	@Autowired : Spring 이 가지고 있는 bean 중에서 해당 변수에 집어넣을 수 있는 bean 자동으로 주입
//	의존성 주입
	
	@Autowired
	BoardMapper boardMapper;
	
//	사용자가 "/list"를 요청을 처리하고 list.jsp 보여주기
	
//	메소드를 만들어서 사용자의 요청을 처리
//	@RequestMapping : URLMapping 지정
//	"/list"라는 요청이 들어오면 list()
	@RequestMapping("/list")
	public String list(HttpServletRequest request,HttpSession session, Model model){
//		코드를 작성하다가 request, model, session 과 같이 받아와야하는 경우 
//		메소드의 매개변수에 자동완성 해볼 것!
//		자동완성했는데 나왔다 == spring이 알아서 집어넣어주니까 선언만 하면 된다!
		
//		게시글 목록 데이터
		ArrayList<Board> list = (ArrayList<Board>) boardMapper.boardList();
		
//		위 데이터를 list.jsp로 이동하려면?
		
//		객체 바인딩 
//		: 데이터를 scope에 잠시 맡겨두고 이동 후에 다시 꺼내서 사용하는 방법 
//		page: 하나의 jsp page에서 유지되는 영역 , JSTL에서 지역변수 처럼 사용
//		request : 요청이 시작되고, 사용자가 응답을 받기 직전까지 유지
//		session : 하나의 브라우저 내에서 유지
//		application : 하나의 웹 어플리케이션이 유지 되는 동안, 어플리케이션당 하나의 영역만 존재
		
//		Model: 다이어트한 request, 객체 바인딩 기능만 남긴 request
//		request 영역에 저장되기 때문에 꺼낼 때 request에서 꺼내야함!
		model.addAttribute("list",list);
//		view 선택(jsp파일로 이동)
//		controller -> jsp : forward 
//		controller -> controller : redirect
		
//		String url = "WEB-INF/views/list.jsp";
//		RequestDispatcher rd= request.getRequestDispatcher(url);
//		rd.forward(request,response);
		
		
		return "list"; // 확장자를 제외한 jsp 파일의 이름 
	}
	
//	게시글 작성하러가기
	@RequestMapping("/goWrite")
	public String gowrite() {
//		1. 사용자가 요청에 보낸 데이터를 수집-생략가능
//		2. 기능 수행 - 생략가능
//		3. view 선택 
		
		
		return "write";
	}
	
//	게시글 작성하기
	@RequestMapping("/write")
	public String write(Board board) {
//		1. 데이터 수집
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");

//		메소드의 매개변수에 데이터를 받을 변수를 선언해두면 Spring이 알아서 데이터 수집 
//		** input name  == 매개변수의 변수명 
		
		
//		Board board = new Board();
//		board.setTitle(title);
//		board.setWriter(writer);
//		board.setContent(content);
//		2. 기능 수행
		boardMapper.write(board);
//		3. view 선택 
//		redirect 방식을 이용해서 /list 다시 요청
//		redirect:/를 앞에 붙이면 forword 이동 대신 
//		redirect가 일어난다!
		return "redirect:/list";
	}
	
//	게시글 삭제
	@RequestMapping("/delete")
	public String delete(int idx) {
		
		boardMapper.delete(idx);
		
		
		return "redirect:/list";
	}
	
//	게시물 상세보기
	@RequestMapping("/view")
	public String view(int idx,Model model) {
		
		Board view = boardMapper.view(idx);
		model.addAttribute("view",view);
		
//		view 선택
//		view.jsp
//		retrun "view";
//		만약 void로 리턴타입을 지정했다면, URLMapping을 jsp파일로 
//		
		return "view";
	}
	
	
	@RequestMapping("/modify")
	public String modify(Board board) {
		
		boardMapper.modify(board);
		
		return "redirect:/list";
	}
	
	
	
}
