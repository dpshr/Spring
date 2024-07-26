<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<h1>Spring 게시판 만들기</h1>
			<p>Spring을 활용한 게시판 만들기</p>
		</div>
		<div class="card">
			<div class="card-header">게시판</div>
			<div class="card-body">
				<!-- 
					사용자가 게시글을 선택하면 내용을 보여주는 페이지
				 -->
				 
				<!-- 
					사용자가 게시글 내용을 변경하고 수정하기 버튼을 누르면 
					해당 게시글의 정보가 수정되고, list.jsp로 돌아가는 기능
				 -->
				<form action="modify" method="post">
					<input value="${view.idx}" name="idx" type="hidden">
					<div class="form-group">
						<label for="title">TITLE :</label><input value="${view.title}" name="title" type="text"
							class="form-control" placeholder="Enter title" id="title">
					</div>

					<div class="form-group">
						<label for="writer">WRITER :</label><input value="${view.writer}" name="writer" type="text"
							class="form-control" placeholder="Enter writer" id="writer">
					</div>

					<div class="form-group">
						<label for="content">CONTENT :</label><textarea name="content" rows="15" class="form-control" id="content">${view.content}</textarea>
					</div>

					<button type="submit" class="btn btn-warning">수정하기</button>
					<a class = "btn btn-success" href="list">게시물 목록</a>
				</form>
			</div>
			<div class="card-footer">DCX기반 빅데이터 분석 서비스 개발자 과정</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.1.js" type="text/javascript"></script>
   <script src="resources/js/count.js" type="text/javascript"></script>
</body>
</html>
	
