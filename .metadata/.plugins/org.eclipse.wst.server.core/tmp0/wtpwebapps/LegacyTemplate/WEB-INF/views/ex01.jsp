<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>목록 페이지</h1>
	<%-- 1. 객체 바인딩 된 데이터 꺼내기 --%>
	<% 
	// 각 영역에 데이터가 저장될 때 Object 형태로 업캐스팅
	// 그래서 꺼낼 때 다운캐스팅 해야한다!
	ArrayList<String>list = (ArrayList<String>)request.getAttribute("list");
	
	%>
	<%-- 2. jsp내에서 스크립트릿, 표현식은 최소화하는게 좋음
		>> EL
		${이름} : 바인딩 된 대상을 가져와서 html 요소 사이에 출력
		
		page --> application 작은 영역부터 검색
		찾는 대상이 있으면 검색을 멈추고 데이터를 가져옴
		중복된 이름이 있는 경우는 작은 영역에 있는 데이터를 가져온다 
		
		만약 특정 scope에 있는 데이터를 가져오고자 한다면 앞에 스코프명을 붙여주자!
		
	 --%>
	 <h1>${sessionScope.text}</h1>
	 <%-- 
	 	3. JSTL: 특정한 기능을 태그로 압축시켜놓은 형태 
	 	(1) JSTL 라이브러리를 추가 
	 	(2) 지시자를 이용해서 어떤 라이브러리를 쓸건지 선언
	 --%>
	 <c:forEach begin="0" end="5" step="1">
	 
	 </c:forEach>
	 <c:forEach var="name" items="${list}">
		<h2>${name}</h2>	 
	 </c:forEach>
	 
	 
</body>
</html>