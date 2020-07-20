<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
function delete_wishlist(m_no, user_id){
	//alert("영화번호 : " + m_no + "아이디 : " + user_id);
	var data = {m_no:m_no,user_id:user_id};
	var chk = confirm("위시리스트에 제거할까요?");
	if(chk == true){
	$.ajax("/wishlist/delete_wishlist",{data:data,success:function(){
		window.location.reload(true);;
		}});
	}
}
</script>
<body>
<h2>위시리스트 목록</h2>
<a href="/movie/list">영화목록</a><br>
<hr>
<c:forEach items="${wishlist }" var="wishlist">
<div style="border: 1px solid; width: 300px; height: 270px;" >
	<img src="${wishlist.m_main_poster }"><br>
	제목 : ${wishlist.m_title } / ${wishlist.m_now } <br>
	평점 : ${wishlist.m_score } / 예매율 : ${wishlist.m_advance_rate } <br>
	개봉일 : ${wishlist.m_opendate } / 상영시간 : ${wishlist.m_running_time }<br><br>
	<button type="button" onclick="delete_wishlist(${wishlist.m_no},'${wishlist.user_id }')">위시리스트 제거</button>
</div>
</c:forEach>
</body>
</html>