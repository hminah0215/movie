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
	<a href="/movie/list">영화목록</a><br>
	<a href="/board/main">커뮤니티</a><br>
	<a href="/goods/list_goods">상품</a><br>
	<a href="/note/list_note">쪽지함</a><br>
	<a href="/mypage/main">마이페이지</a><br>
	<c:if test="${member != null }"><a href="/member/logout">로그아웃</a></c:if>
	<c:if test="${member == null }"><a href="/member/login_form">로그인</a></c:if>
	
	<br>
	<c:if test="${member != null}">
			<p>${member.user_id}님 안녕하세요.</p>
	</c:if>
	
	<!--알림  -->
	<c:if test="${member != null}">

			<c:if test="${comment ne null }">
				${comment }개의 새로운 댓글이 있습니다
				<br>
			</c:if>
			
			<c:if test="${note ne null }">
				${note }개의 새로운 쪽지가 있습니다
				<br>
			</c:if>

	</c:if>
</body>
</html>