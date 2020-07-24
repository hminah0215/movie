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
<h2>장바구니 목록</h2>
<hr>
<a href="/mypage/main">마이페이지 메인</a>   <a href="/mypage/update_form">내 정보 수정</a>  <a href="/mypage/board">작성한 글</a>  <a href="/wishlist/list_wishlist?user_id=${member.user_id }">위시리스트</a>  <a href="/goods/list_cart?user_id=${member.user_id }">장바구니</a>  <a href="/mypage/pay">결제내역</a>  <a href="/note/list_note?user_id=${member.user_id }">쪽지함</a><br>
<a href="/goods/list_goods">상품목록</a><br><br>
<table border="1" width="60%">
<tr>
	<th>상품이름</th><th>수량</th><th>상품번호</th><th>아이디</th><th>가격</th><th>비고</th>
</tr>
<c:forEach items="${list_cart }" var="cart">
	<tr>
		<td>${cart.c_name }</td><td>${cart.c_qty }</td><td>${cart.g_no }</td><td>${cart.user_id }</td><td>${cart.c_price }</td><td><a href="/goods/delete_cart?c_no=${cart.c_no }" onclick="return confirm('장바구니에서 삭제하까요?');">삭제</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>