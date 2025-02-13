package com.smhrd.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.smhrd.entity.Board;

@Mapper
public interface BoardMapper {
	// 주의! xml, interface의 파일 이름이 동일할 것 	
	// 주의! scan이 원활하게 되게하기 위해서는 @Mapper 어노테이션 붙이기
	
	// 1. DB연결
	// DBCP(DataBase Connection Pool)
	// 처음 시작할 때 지정된 개수만크 미리 Connection을 생성 
	// 기능이 실행되면 생성된 Connection을 빌려와서 실행하고 
	// 완료후 반납
	// --> 한번에 DB쿼리를 사용하는 횟수를 제한
	// root-context.sml에서 기술해서 bean 생성
	
	// 2. 기능 구현
	// 추상 메소드로 선언만 해주면 된다.
	// 1) 메소드이름 == id 
	// 2) 리턴타입 == resultType 
	// 3) 매개변수 == parameterType 동일한 자료형의 변수 선언
	
	
	public List<Board> boardList();
//	{
//		// 1) sqlSession 받아오기 
//		SqlSession session	= sqlSessionFactory.openSession();
//		// 2) SQL 문장 실행
//		 List<Board> list = session.selectList("boardList");
//		// 3) session 반납
//		session.close();
//		
//		// 4) 실행결과 리턴
//		return list;
//	}
	
	
//	게시물 작성 메소드
	public int write(Board board);
	
//	게시물 삭제 메소드
	public int delete(int idx);
	
//	게시물 조회 메소드
	public Board view(int idx);
	
//	게시물 수정 메소드

	public int modify(Board board);
	
//	게시물 조회수 
	public int count(int idx);
	
//	게시물 검색
	public List<Board>select(String selval);
	
}