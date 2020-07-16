<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
window.onload = function(){
	var userId = document.querySelector("#id"); 
	var pw1 = document.querySelector("#pw1");  
	var pw2 = document.querySelector("#pw2");

	userId.onchange = checkId;
	pw1.onchange = checkPw;
	pw2.onchange = comparePw;

	function checkId() {			
		if (userId.value.length < 4 || userId.value.length > 15) {  
			alert("4~15자리의 영문과 숫자를 사용하세요.");  
			userId.value = "";
			userId.focus();   
		}

	}

	function checkPw() {			
		if (pw1.value.length < 8) {
			alert("비밀번호는 8자리 이상이어야 합니다.");  
			pw1.value = "";  
			pw1.focus(); 
		}
	}

	function comparePw() {						
		if(pw1.value != pw2.value) {
			alert("암호가 다릅니다. 다시 입력하세요.");
			pw2.value = ""; 
			pw2.focus();   
		}
	}
}

function fn_check(){
	$.ajax({
		url : "/member/checkId",
		type : "post",
		dataType : "json",
		data : {"user_id" : $("#id").val()},
		success : function(data){
			if(data == 1){
				alert("중복된 아이디입니다.");
				$("#id").val("");
				$("#id").focus();   
			}else if(data == 0){
				$("#check").attr("value","Yes");
				alert("사용가능한 아이디입니다.")
			}
		}
	})
	
}


</script>
</head>
<body>
	<div id="container">
		<h1>회원 가입</h1>
		<form action="/member/register" method="post" id="register">
			<ul id="user-info">
				<li>
					<label for="id" class="field">아이디</label>
					<input type="text" id="id" name="user_id" placeholder="4~15자리의 영문과 숫자로 입력" required>
					<button type="button" id="check" onclick="fn_check()" value="No">아이디 중복확인</button>
				</li>
				
				<li>
					<label for="pw1" class="field">비밀번호</label>
					<input type="password" id="pw1" placeholder="8자리 이상" required>
				</li>
				<li>
					<label for="pw2" class="field">비밀번호 확인</label>
					<input type="password" id="pw2" name="pwd"  required>
				</li>
				<li>
					<label for="name" class="field">이름</label>
					<input type="text" id="name" placeholder="이름을 입력해주세요." name = "name" required>
				</li>
				<li>
					<label for="age" class="field">나이</label>
					<input type="number" id="age" name="age"  required>
				</li>
				<li>
					<label for="addr" class="field">주소</label>
					<input type="text" id="addr" name="addr" placeholder="주소를 입력해주세요." required>
				</li>
				<li>
					<label for="email" class="field">이메일</label>
					<input type="email" id="email" name="email" required>
				</li>

			</ul>
			<ul id="buttons">
				<li>
					<button type="submit">가입하기</button>					
				</li>
				<li>
					<button type="reset">취소</button>
				</li>
			</ul>
		</form>
	</div>
</body>
</html>