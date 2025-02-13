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
					form태그를 사용해서 데이터를 받아준 다음 요청을 보내는 방법
					1. name : input 데이터에 붙이는 이름
					2. action : 요청할 URL
					3. submit : 언제 요청이 가게 할 것인지
					
				 -->
				<form action="write" method="post">
					<div class="form-group">
						<label for="title">TITLE :</label> <input name="title" type="text"
							class="form-control" placeholder="Enter title" id="title">
					</div>

					<div class="form-group">
						<label for="writer">WRITER :</label> <input name="writer" type="text"
							class="form-control" placeholder="Enter writer" id="writer">
					</div>

					<div class="form-group">
						<label for="content">CONTENT :</label> 
						<textarea name="content" rows="15" class="form-control" id="content"></textarea>
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			
			
			
			
			<div class="card-footer">DCX기반 빅데이터 분석 서비스 개발자 과정</div>
		</div>
	</div>