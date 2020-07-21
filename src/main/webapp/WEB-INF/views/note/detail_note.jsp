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
function send_note(from_id, to_id){
	//alert("쪽지 보내는 아이디 : " + from_id + " 쪽지 받는 아이디 : " + to_id);
	window.close();
	window.open("/note/insert_note_form?from_id="+from_id+"&to_id="+to_id, "쪽지 보내기", "width=800,height=500,left=0,top=0");
}

function close_note(){
	window.close();
}
</script>
<h2>쪽지 상세보기</h2>
<hr>
보낸사람 ${detail.from_id } <br>
제목 ${detail.note_title } <br>
내용<br>
<textarea rows="10" cols="100">${detail.note_content }</textarea><br>
<c:if test="${detail.user_id eq member.user_id }">
<button onclick="send_note('${member.user_id}','${detail.from_id }')">답장 보내기</button>
</c:if>
<button onclick="close_note()">닫기</button>
</body>
</html>