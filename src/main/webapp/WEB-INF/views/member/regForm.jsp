<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>	
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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

function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           // 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
        // 우편번호와 주소 정보를 해당 필드에 넣는다.
           document.getElementById('addr').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('addr2').value = fullRoadAddr;
        
       }
    }).open();
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
  					<input class="form-control" style="width: 20%; display: inline;" placeholder="우편번호" name="addr" id="addr" type="text" readonly="readonly" >
 					<button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
					<input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="addr2" id="addr2" type="text" readonly="readonly" />
					<input class="form-control" placeholder="상세주소" name="addr3" id="addr3" type="text"  />
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