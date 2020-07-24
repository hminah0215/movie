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
<h2>작성한 글</h2>
<hr>
<a href="/mypage/main">마이페이지 메인</a>   <a href="/mypage/update_form">내 정보 수정</a>  <a href="/mypage/board">작성한 글</a>  <a href="/wishlist/list_wishlist?user_id=${member.user_id }">위시리스트</a>  <a href="/goods/list_cart?user_id=${member.user_id }">장바구니</a>  <a href="/mypage/pay">결제내역</a>  <a href="/note/list_note?user_id=${member.user_id }">쪽지함</a>
<table border="1">
<tr>
	<th>게시물 번호</th><th>제목</th><th>작성일</th><th>조회수</th>
</tr>
<c:forEach items="${board }" var="b">
	<tr onclick="location.href='/board/detail?b_no=${b.b_no }'">
		<td>${b.b_no }</td>
		<td>${b.b_title } [${b.cm_cnt }]</td>
		<td>${b.b_date }</td>
		<td>${b.b_hit }</td>
	<tr>
</c:forEach>
</table>
</body>
</html>