package com.smhrd.web;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Spring이 해당 파일을 POJO로 인식하기 위한 어노테이션
@Controller
public class BoardController {
	
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
		ArrayList<String>list = new ArrayList<String>();
		list.add("박준한");
		list.add("오창민");
		list.add("윤에녹");
		list.add("김유빈");
//		위 데이터를 list.jsp로 이동하려면?
		
//		객체 바인딩 
//		: 데이터를 scope에 잠시 맡겨두고 이동 후에 다시 꺼내서 사용하는 방법 
//		page: 하나의 jsp page에서 유지되는 영역 , JSTL에서 지역변수 처럼 사용
//		request : 요청이 시작되고, 사용자가 응답을 받기 직전까지 유지
//		session : 하나의 브라우저 내에서 유지
//		application : 하나의 웹 어플리케이션이 유지 되는 동안, 어플리케이션당 하나의 영역만 존재
		
//		Model: 다이어트한 request, 객체 바인딩 기능만 남긴 request
//			   request 영역에 저장되기 때문에 꺼낼 때 request에서 꺼내야함!
		model.addAttribute("list", list);
		request.setAttribute("text", "hello world!");
		session.setAttribute("text", "session data");
		
		
		
		
		
		
		
//		view 선택(jsp파일로 이동)
//		controller -> jsp : forward 
//		controller -> controller : redirect
		
//		String url = "WEB-INF/views/list.jsp";
//		RequestDispatcher rd= request.getRequestDispatcher(url);
//		rd.forward(request,response);
		
		
		return "list"; // 확장자를 제외한 jsp 파일의 이름 
	}
	
}
