<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 등록</h2>
<hr>
<form action="/board/insert_board">
<input type="hidden" name="b_category" value="자유게시판">
	카테고리 : <select name="b_category_sub">
				<option value="자유">자유</option>
				<option value="질문">질문</option>	
			</select><br>
	작성자 : <input type="text" name="user_id"><br>
	제목 : <input type="text" name="b_title"><br>
	내용<br>
	<textarea rows="10" cols="80" name="b_content"></textarea><br>
	<button>등록</button>
	<a href="/board/list">취소</a>
</form>
</body>
</html>