<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>쪽지함</h2>
<a href="/mypage/main">마이페이지 메인</a>   <a href="/mypage/update_form">내 정보 수정</a>  <a href="/mypage/board">작성한 글</a>  <a href="/wishlist/list_wishlist?user_id=${member.user_id }">위시리스트</a>  <a href="/goods/list_cart?user_id=${member.user_id }">장바구니</a>  <a href="/mypage/pay">결제내역</a>  <a href="/note/list_note?user_id=${member.user_id }">쪽지함</a><br>
<a href="/note/send_note_list?user_id=${member.user_id }">보낸 쪽지</a>   <a href="/note/reseive_note_list?user_id=${member.user_id }">받은 쪽지</a>
<hr>
</body>
</html>