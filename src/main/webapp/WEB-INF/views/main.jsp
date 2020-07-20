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
	
	<c:if test="${member != null }"><a href="/member/logout">로그아웃</a></c:if>
	<c:if test="${member == null }"><a href="/member/login">로그인</a></c:if>
	
	<br>
	<c:if test="${member != null}">
			<p>${member.user_id}님 안녕하세요.</p>
	</c:if>
</body>
</html>