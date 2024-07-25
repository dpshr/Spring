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

				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<td>글번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${list}">
						<tr>
							<td>${board.idx}</td>
							<td>${board.title}</td>
							<td>${board.writer}</td>
							<td>${board.indate}</td>
							<td>${board.count}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>







			</div>
			<div class="card-footer">DCX기반 빅데이터 분석 서비스 개발자 과정</div>
		</div>
	</div>