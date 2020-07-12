<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>FAQ 목록</h2>
<a href="/board/notice_list">공지사항</a>
<a href="/board/free_list">자유게시판</a>
<a href="/board/faq_list">FAQ</a>
<hr>
<table border="1" width="60%">
	<tr>
		<th>게시물 번호</th>
		<th>카테고리</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${list_faq }" var="b">
		<tr onclick="location.href='/board/detail?b_no=${b.b_no }'">
			<td>${b.b_no }</td>
			<td>${b.b_category_sub }</td>
			<td>${b.b_title } [${b.cm_cnt }]</td>
			<td>${b.user_id }</td>
			<td>${b.b_date }</td>
			<td>${b.b_hit }</td>
		<tr>
	</c:forEach>
</table>
<hr>
<a href="/board/insert_faq_form">등록</a>
</body>
</html>