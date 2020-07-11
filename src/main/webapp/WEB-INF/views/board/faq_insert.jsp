<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>FAQ 등록</h2>
<a href="/board/notice_list">공지사항</a>
<a href="/board/free_list">자유게시판</a>
<a href="/board/faq_list">FAQ</a>
<hr>
<form action="insert_faq">
<input type="hidden" name="b_category" value="faq">
<input type="hidden" name="user_id" value="admin">
	카테고리 : <select name="b_category_sub">
				<option value="사이트 이용">사이트 이용</option>
				<option value="계정 이용">계정 이용</option>	
			</select><br>
	제목 : <input type="text" name="b_title"><br>
	내용<br>
	<textarea rows="10" cols="80" name="b_content"></textarea><br>
	<button>등록</button>
	<a href="/board/faq_list">취소</a>
</form>
</body>
</html>