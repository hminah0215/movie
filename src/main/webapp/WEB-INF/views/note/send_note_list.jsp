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
<script type="text/javascript">
function detail(note_no){
	window.open("/note/detail_note?note_no="+note_no+"&user_id="+'${member.user_id}',"쪽지상세","width=800,height=500,left=0,top=0");
}
</script>
<h2>쪽지함</h2>
<a href="/mypage/main">마이페이지 메인</a>   <a href="/mypage/update_form">내 정보 수정</a>  <a href="/mypage/board">작성한 글</a>  <a href="/wishlist/list_wishlist?user_id=${member.user_id }">위시리스트</a>  <a href="/goods/list_cart?user_id=${member.user_id }">장바구니</a>  <a href="/mypage/pay">결제내역</a>  <a href="/note/list_note?user_id=${member.user_id }">쪽지함</a><br>
<a href="/note/send_note_list?user_id=${member.user_id }">보낸 쪽지</a>   <a href="/note/reseive_note_list?user_id=${member.user_id }">받은 쪽지</a>
<hr>
<table border="1" width="60%">
	<tr>
		<th>쪽지 번호</th><th>받는 사람</th><th>제목</th><th>확인여부</th>
	</tr>
	<c:forEach items="${send_note_list }" var="send">
	<tr onclick="detail('${send.note_no}')">
		<td>${send.note_no }</td><td>${send.user_id }</td><td>${send.note_title }</td><td>${send.note_chk }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>