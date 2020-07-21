<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#send_btn").click(function(){
		var data = $("#form").serialize();
		console.log(data);
		$.ajax("/note/insert_note",{data:data,success:function(){
			alert("쪽지를 보냈습니다");
			window.close();
			}});
		});

	$("#close_btn").click(function(){
		window.close();
		});
})
</script>
<body>
<h2>쪽지 보내기</h2>
<hr>
<form id="form">
받는 사람 아이디 <input type="text" name="user_id" value="${to_id }" readonly="readonly"> <br>
보내는 사람 아이디 <input type="text" name="from_id" value="${member.user_id }" readonly="readonly"><br>
제목 <input type="text" name="note_title" required="required"><br>
내용 <br>
<textarea rows="10" cols="100" name="note_content" required="required"></textarea><br><br>
<button type="button" id="send_btn">보내기</button>  <button type="button" id="close_btn">닫기</button>
</form>
</body>
</html>