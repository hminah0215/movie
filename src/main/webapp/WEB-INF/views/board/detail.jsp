<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#up{
	display: none;
}
</style>
</head>
<script type="text/javascript">
window.onload = function(){
	var btn = document.querySelectorAll(".btn");
	
	for(var i = 0; i<btn.length; i++){
		btn[i].addEventListener("click",getid);
	}
}

function getid(){
	//수정할 form으로 화면 움직임
	window.location="#up_cm_content";
	
	//선택한 노드의 id값 가져오기
	var btn_id = this.getAttribute("id");
	//내용가져올거 선택, body에서 text+id로 id를 설정함
	var text = document.querySelector("#text"+btn_id);
	//내용가져오기
	var text2 = text.value;
	//console.log(text2);
	
	//아이디 가져오기
	var user_id = document.querySelector("#id"+btn_id);
	var user_id2 = user_id.value;
	
	//글번호 가져오기
	var bno = document.querySelector("#bno"+btn_id);
	var bno2 = bno.value;
	
	//댓글번호 가져오기
	var cmno = document.querySelector("#cmno"+btn_id);
	var cmno2 = cmno.value;

	console.log(user_id2,bno2,cmno2);
	
	//수정 form 선택
	var up_div = document.querySelector("#up");
	//form 보이게
	up_div.style = "display:block";

	//기존 아이디 넣어줄 노드 선택
	var up_user_id = document.querySelector("#up_user_id");
	//기존 아이디 넣음
	up_user_id.value = user_id2;

	//기존 글번호 넣어줄 노드 선택
	var up_b_no = document.querySelector("#up_b_no");
	//기존 글번호 넣음
	up_b_no.value = bno2;
	
	//기존 댓글번호 넣어줄 노드 선택
	var up_cm_no = document.querySelector("#up_cm_no");
	//기존 댓글번호 넣음
	up_cm_no.value = cmno2;
	
	//기존 내용을 넣어줄 노드 선택
	var up_cm_content = document.querySelector("#up_cm_content");
	//기존 내용 넣음
	up_cm_content.value=text2;

	//취소 버튼 선택
	var cancle = document.querySelector("#cancle");
	cancle.addEventListener("click",can);

}

function can(){
	var up_div = document.querySelector("#up");
	up_div.style = "display:none";
}

</script>
<body>
<h2>상세보기</h2>
<a href="/board/notice_list">공지사항</a>
<a href="/board/free_list">자유게시판</a>
<a href="/board/faq_list">FAQ</a>
<hr>

글번호 ${detail.b_no }<br>
카테고리 ${detail.b_category_sub } | 작성일 ${detail.b_date } | 조회수 ${detail.b_hit } <br>
제목 ${detail.b_title }<br>
내용<br>
<textarea>${detail.b_content }</textarea><br>

<!-- 수정, 삭제 버튼은 작성자한테만 보이게 수정할 예정 -->
<a href="/board/update_board_form?b_no=${detail.b_no }" onclick="return confirm('수정하시겠습니까 ?');">수정</a>
<a href="/board/delete_board?b_no=${detail.b_no }" onclick="return confirm('삭제하시겠습니까 ?');">삭제</a>

<br><hr><br>

<!-- 댓글 등록 -->
<h2>댓글등록</h2>
<form action="/board/insert_board_comment">
<input type="hidden" name="b_no" value="${detail.b_no }">
작성자 : <input type="text" name="user_id"><br>
내용<br>
<textarea rows="10" cols="10" name="cm_content"></textarea><br>
<button onclick="return confirm('댓글을 등록하시겠습니까 ?');">댓글 등록</button>
<button type="reset">취소</button>
</form>
<hr>

<!-- 댓글 목록 -->
<h2>댓글목록</h2>
<c:forEach items="${cm_list }" var="cm">
<input type="hidden" value="${cm.user_id }" id="id${cm.cm_no }">
<input type="hidden" value="${cm.b_no }" id="bno${cm.cm_no }">
<input type="hidden" value="${cm.cm_no }" id="cmno${cm.cm_no }">

작성자 : ${cm.user_id }<br>
내용 <br>
<textarea readonly="readonly" id="text${cm.cm_no }">${cm.cm_content }</textarea><br>
작성일 : ${cm.cm_date } <br>
<div class="btn" id="${cm.cm_no }">수정</div>
<a href="/board/delete_board_comment?cm_no=${cm.cm_no }&b_no=${cm.b_no}" onclick="return confirm('삭제하시겠습니까 ?');">삭제</a>
<br><br>
</c:forEach>
<hr>

<!-- 댓글 수정 -->
<div id="up">
<h2>댓글수정</h2>
	<form action="/board/update_board_comment">
	<input type="hidden" name="user_id" id="up_user_id">
	<input type="hidden" name="b_no" id="up_b_no">
	<input type="hidden" name="cm_no" id="up_cm_no">
	내용<br>
	<textarea rows="10" cols="10" name="cm_content" id="up_cm_content"></textarea><br>
		<button>수정 완료</button>
		<div id="cancle">취소</div>
	</form>
</div>
</body>
</html>