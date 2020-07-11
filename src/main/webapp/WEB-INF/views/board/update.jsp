<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>수정하기</h2>
<a href="/board/notice_list">공지사항</a>
<a href="/board/free_list">자유게시판</a>
<a href="/board/faq_list">FAQ</a>
<hr>
<form action="/board/update_board">
<input type="hidden" name="b_no" value="${detail.b_no }">
제목 <input type="text" name="b_title" value="${detail.b_title }"><br>
내용 <br>
<textarea rows="10" cols="10" name="b_content">${detail.b_content }</textarea><br>
<button>수정</button>
<a href="/board/detail?b_no=${detail.b_no }">취소</a>
</form>
</body>
</html>