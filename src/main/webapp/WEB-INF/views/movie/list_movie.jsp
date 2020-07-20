<%@page import="com.movie.demo.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function a(m_no){
		if(m_no == 1){
			window.location = "/movie/theatherList?m_no="+m_no;
			
		}else{
			alert("상영중인 상영관이 없습니다.")
		}
	}

	function insert_wishlist(m_no, user_id){
		//alert("영화번호 : " + m_no + "아이디 : " + user_id);
		var data = {m_no:m_no,user_id:user_id};
		var chk = confirm("위시리스트에 추가할까요?");
		if(chk == true){
		$.ajax("/wishlist/insert_wishlist",{data:data,success:function(){
			window.location.reload(true);
			}});
		}
	}
	
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

	function login(){
		var chk = confirm("로그인 하시겠습니까?");
		if(chk == true){
			window.location.href="/member/login_form";
		}
	}
</script>

</head>
<body>
<c:if test="${member != null}">
	<a href="/wishlist/list_wishlist?user_id=${member.user_id }">위시리스트</a><br><br>
</c:if>
<%-- ${listMovie } --%>
<c:forEach items="${listMovie }" var="movie" varStatus="status">
	영화제목 : ${movie.m_title }<br>
	나이제한 : ${movie.m_age }<br>
	영화평점 : ${movie.m_score }<br>
	영화예매율 : ${movie.m_advance_rate }<br>
	영화장르 : ${movie.m_genre }<br>
	러닝타임 : ${movie.m_running_time }<br>
	개봉일 : ${movie.m_opendate }<br>
	영화감독 : ${movie.m_director }<br>
	출연배우 : ${movie.m_actors }<br>
	영화포스터 : <img src="${movie.m_main_poster }"><br>
	<div>
	<button type="button" id="${movie.m_no }" onclick="a(${movie.m_no })"><b style="color: red;">예약하기</b></button>
	
		<c:choose>
			<c:when test="${member != null}">
				<c:choose>
					<c:when test="${wishlist[status.index] > 0 }">
						<button type="button" onclick="delete_wishlist(${movie.m_no},'${member.user_id }')">위시리스트 제거</button>
					</c:when>
					<c:otherwise>
						<button type="button" onclick="insert_wishlist(${movie.m_no},'${member.user_id }')">위시리스트 추가</button>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<button type="button" onclick="login()">위시리스트 추가</button>
			</c:otherwise>	
		</c:choose>	
		
	</div>
</c:forEach>
</body>
</html>