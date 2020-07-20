<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">
window.onload = function(){
	var logout = document.querySelector("#Btn_logout");
	logout.onclick = function(){
		location.href = "member/logout"
	}
	
}
	
</script>
</head>
<body>
<form method="post" action="/member/login" id="loginForm">
		<c:if test="${member == null}">
			<div>
				<label for="user_id"></label>
				<input type="text" id="user_id" name="user_id">
			</div>
			<div>
				<label for="pwd"></label>
				<input type="password" id="pwd" name="pwd">
			</div>
			<div>
				<button type="submit">로그인</button>
				<button type="button">회원가입</button>
			</div>
		</c:if>
		<c:if test="${member != null }">
			<div>
				<p>${member.user_id}님 환영 합니다.</p>
				<button id="Btn_logout" type="button">로그아웃</button>
			</div>
		</c:if>
	</form>
</body>
</html>