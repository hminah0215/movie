<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상세보기</h2>
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
<form action="">

</form>
</body>
</html>