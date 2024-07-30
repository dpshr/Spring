package com.smhrd.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity // 해당 클래스가 Scan이 되어지고, Entity역할로써 기능하기 위한 어노테이션
@Data
public class Member {
	
//	ORM
//	java에서 DTO를 만드는 것으로, 테이블을 생성할 수 있다. 
//	개발 초기에, entity 내의  변경 사항을 테이블에 반영하기 쉬움
//	개발 기간 단축, 관리 용이
//	입문 난이도 낮음(개발자가 SQL문을 입력할 필요가 없기에 , 공부하기가 편하고 
//				개발기간을 추가로 단축시킬 수 있음)
	
	
	
//	이메일
//	@ID 어노테이션을 붙여 , 해당 컬럼에 primary key 부여ㅑ할 수있음
//	자동으로 테이블이 생성되기 위해서 , 최소 하나의 컬럼에 PK가 걸려 있어야함
	@Id
	private String email;
//	비밀번호
//	@Column 어노테이션을 이용해서 컬럼의 길이 , 제약조건 등 상세설정 가능
//	nallable 값을 통해, not null 제약조건을 부여할 수 있
	@Column(length = 50,nullable = false)
	private String pw;
//	전화번호
	private String tel;
//	집주소
	private String address;
	
//	일대다 관계를 표현
//	mappedBy 라는 속성을 이용해서 어떤 컬럼과의 관계를 형성하는지 명시
//	새로운 만들게 됨
	@OneToMany(mappedBy = "writer")
	private List<Board> board;
	
//	해당 관계를 정의했을 경우 
//	회원 조회시 --> 각 사용자가 작성한 게시글 조회 
//	조인을 이용해서 데이터를 가져올 필요X, 항상 회원과 게시글 정보를 쉽게 조회
	
//	Jackson Databind 가 자동으로 json으로 변환하는 기능에서 문제가 발생
//	>> 만들고자 하는 기능에 맞춰서 넣을 지 말지를 선택
	@Override
	public String toString() {
		return "Member 객체";
	}

}
