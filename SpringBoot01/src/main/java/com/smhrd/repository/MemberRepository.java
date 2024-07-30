package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Member;

// Scan이 이루어질 수 있도록 Repository 어노테이션 붙어야함
@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
//	Repository 생성 시 , JpaRepository<T, ID>를 상속받아야만 함
//	T : table 역할을 하는 (과 연결된) 클래스가 누군지
//	ID : 해당 클래스에서 ID(PK)가 붙어있는 변수의 자료형 
	
//	인터페이스(추상메소드) --> hibernate --> DAO를 Bean으로 등록
	
//	SQL문을 정의하지 않음 --> SQL문을 자동으로 작성해서 메소드를 구현
//	개발자가 SQL문을 한글자도 안적어도 , DB를 활용하는 기능을 구현할 수 있음
//	>> 개발이 편리해지고 개발기간 단축
//	
//	단점 
//	실행시간이 오래걸림
//	SQL문이 효율적이지 않을 수도 있음 >> DB 자원 소모가 많아질 수 있음
	
//	======================================================
	
//	추상메소드 정의 방법 
	
//	1. 정의를 안하는 것
//	JPARepository 인터페이스에 기본 CRUD 메소드가 미리 정의되어 있음.
//	기본 CRUD를 사용하고자 하는 경우에는 따로 정의하는 과정없이 사용할 수 있음 
//	save(Entity S) 
//	PK 기준으로 select 
//	>(만약 없으면)insert
//	>(만약 존재하면)update
	
//	2. 쿼리 메소드
//	정해진 규칙대로 메소드의 이름을 만들면 , 메소드 이름을 가지고 SQL 쿼리를 자동생성 
//	select * from MEMBER
//	where email = :email ---> findByID
//	and pw = :pw ---> 기본 메소드 중 존재 X
//	규칙 1. 카멜 기법으로 작성해야함 
//	규칙 2. By 를 이용해서 조건으로 거는 컬럼을 정의 
//	규칙 3. And, Or을 이용해서 여러개의 조건이 되는 컬럼을 나열 
//	규칙 4. 양식에 맞춰서 연산자를 사용 
//		   ex)where email like 'admin%'
//				>> findByEmailStartWith
//	규칙 5. 매개변수에 데이터를 집어넣을 떄 ,묶지 않고 각각 집어넣어 주어야함
public Member findByEmailAndPw(String email,String pw);


//	쿼리 메소드만으로는 서브쿼리를 포함하거나, join이 들어가는 복잡한 sql문을 
//	정의할 수 없다.
//	join --> 따로 해결법이 존재
// 	3. 자동완성을 포기하고 , 직접 SQL문을 정의 
//	메소드에 @Query를 붙이고 
//	문자열로 sql문을 직접 정의 
//	>> 가급적 """ """ (docstring)을 사용해서 정의할 것
//	sql 문 중간에 변수값을 집어넣어야하는 경우 " : 변수명" 양식으로 작성
//		매개변수에 선언한 변수명을 그대로 작성할 것***
//	테이블명은 '첫 글자만' 대문자, 나머지는 전부 소문자로 작성
//	** '*'는 사용할 수 없음
//	전체 컬럼을 조회하고자 하는 경우 >> 테이블에 alias 부여 
//								테이블의 alias를 컬럼절에 적으면
//								전체컬럼 조회
@Query("""
		select m from Member m
		where m.email = :email
		and m.pw = :pw
		""")
public Member login(String email,String pw);
	
	
}
