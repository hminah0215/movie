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
<a href="/note/send_note_list?user_id=${member.user_id }">보낸 쪽지</a>   <a href="/note/reseive_note_list?user_id=${member.user_id }">받은 쪽지</a>
<hr>
</body>
</html>