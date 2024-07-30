package com.smhrd.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Board {


//	자료형 선언시, 기본자료형 보다는 참조자료형으로 선언하는 것이 안전하다 
//	int<--> Integer
//	long <--> Long
//	insertable : insert문이 자동으로 완성될 때 , 해당 컬럼을 포함할지 여부
//	insert into Board(title,writer,content, img)
//	values(?,?,?,?);
//	updatable : update문의 set절에 포함 될지 안될지
//	update Board
//	set idx= ?, (X)
	
//	글번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 
	@Column(insertable = false,updatable = false)
	private Long idx;
//	제목
	@Column(length = 100,nullable = false)
	private String title;
//	내용
	@Column(length = 1000)
	private String content;
//	이미지
	private String img;
//	작성일
//	ColumDefinition : 자료형~제약조건(default)까지 직접 작성
	@Column(columnDefinition = "datetime default now()",insertable = false, updatable = false)
	private Date indate;
//	조회수
	@Column(columnDefinition = "int default 0",insertable = false)
	private Long count;
//	작성자
//	FK를 구현할 때 , 관계에 따라서 
//	@ManyToOne, @OneToOne 등의 어노테이션을 사용하게 된다.
//	어떤 테이블과 관계 있는지는 자료형을 통해서 나타냄
	@ManyToOne
	private Member writer;
	@Override
	public String toString() {
		return "Board 객체";
	}
//	JPA 심각한 버그가 있음
//	FK관계를 만들었을 때, lombok이 자동으로 toString을 만들다가 
//	MemoryOverflow 발생하는 오류가 있음
//	해당 문제를 발생시키지 않기위해 , toString 메소드를 직접 오버라이딩 해야함
	
}
