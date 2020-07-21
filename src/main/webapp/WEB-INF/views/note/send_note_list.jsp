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