package com.smhrd.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

// 모든 메소드의 데이터를 응답하는 메소드로 인식시키는 어노테이션
// --> @ResponseBody를 붙이지 않아도 된다!
// 동기 /비동기 컨트롤러 나누어서 구현

// RestController?
// Rest API : URL 요청시 데이터를 응답해주는 API(공공데이터 포털)

// 기존 Controller는 페이지를 이동시키기 위해서 return
// ResponseBody를 붙이면 return이 데이터를 응답하기 위해서 쓰임
// 단, 응답하는 데이터는 문자열이여야한다. 

@RestController
public class BoardRestController {
	
	@Autowired
	BoardMapper boardMapper;
	
//	@RequestMapping 매개변수 
//	value : URLMapping
//	produces : 응답의 형식(response.setContextType)
	@ResponseBody
	@RequestMapping(value="/ajax01",produces="text/html; charset=UTF-8")
	public String ajax01(int num1){
//		비동기요청이 들어왔을 때 
//		데이터 수집은 동일하게 진행
		System.out.println("전송받은 데이터: " + num1);
		
		return "안녕하세요";
	}
	
//	요청이 들어왔을 때 
//	특정 게시글의 조회수를 1 올리기
//	"조회수 증가" 응답
	@RequestMapping(value="/count", produces="text/html; charset=UTF-8")
	   public String count(int idx) {
	      // 1. 데이터 수집
	      // 2. 기능 실행
	      boardMapper.count(idx);
	      // 3. 데이터 리턴(응답)
	      return "조회수 증가";
	   }
	
	
	@RequestMapping("/ajax02")
	public List<Board> ajax02() {
		// 1. 데이터 수집
		// 2. 기능 실행
		List<Board> list= boardMapper.boardList();
		// 3. 데이터 리턴(json)
		// JSON :{"key" : "value"}
		// JSON Array : [{},{},{}...]
//		String json = "[";
//		for(Board board:list)
//		{
//			json +="{";
//			json += "\"idx\" :\""+board.getIdx()+"\",";
//			json += "\"title\" :\""+board.getTitle()+"\",";
//			json += "\"writer\" :\""+board.getWriter()+"\",";
//			json += "\"content\" :\""+board.getContent()+"\",";
//			json += "\"indate\" :\""+board.getIndate()+"\",";
//			json += "\"count\" :\""+board.getCount()+"\"";
//			json +="}";	
//		}
//		
//		json += "]";
//		
//		return json;
		
//		데이터를 바꾸는 방법 
//		1)Gson
//		Java Object => JSON
//		JSON = Java Object(WebSocket)
		
		return list;
		
//		2) Jackson databind 
//		Java Object => JSON
		
	
	}
//	게시물 검색 기능 
	@RequestMapping("/select")
	public List<Board> select(String selval) {
		
		selval = "%"+selval+"%";
		List<Board> list = boardMapper.select(selval);
		
		return list;
}
	
	
	
}
