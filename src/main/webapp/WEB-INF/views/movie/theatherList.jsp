<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/movie/theatherList">
예매선택<br>
<select name="thList" onchange="choose(this)">
	<option>선택</option>
	<option value="콤보">콤보</option>
	<option value="팝콘">팝콘</option>
	<option value="음료">음료</option>
	<option value="스낵">스낵</option>
</select><br>
사진<br>
<div id="콤보">
<img src="/img/goods/콤보01.jpg" width="100" height="100" class="img_name" id="콤보01.jpg">
<img src="/img/goods/콤보01.jpg" width="100" height="100" class="img_name" id="콤보02.jpg">
<img src="/img/goods/콤보01.jpg" width="100" height="100" class="img_name" id="콤보03.jpg">
<img src="/img/goods/콤보01.jpg" width="100" height="100" class="img_name" id="콤보04.jpg">
</div>
<div id="팝콘">
<img src="/img/goods/팝콘01.jpg" width="100" height="100" class="img_name" id="팝콘01.jpg">
<img src="/img/goods/팝콘02.jpg" width="100" height="100" class="img_name" id="팝콘02.jpg">
<img src="/img/goods/팝콘03.jpg" width="100" height="100" class="img_name" id="팝콘03.jpg">
<img src="/img/goods/팝콘04.jpg" width="100" height="100" class="img_name" id="팝콘04.jpg">
<img src="/img/goods/팝콘05.jpg" width="100" height="100" class="img_name" id="팝콘05.jpg">
<img src="/img/goods/팝콘06.jpg" width="100" height="100" class="img_name" id="팝콘06.jpg">
<img src="/img/goods/팝콘07.jpg" width="100" height="100" class="img_name" id="팝콘07.jpg">
<img src="/img/goods/팝콘08.jpg" width="100" height="100" class="img_name" id="팝콘08.jpg">
</div>
<div id="음료">
<img src="/img/goods/음료01.jpg" width="100" height="100" class="img_name" id="음료01.jpg">
<img src="/img/goods/음료02.jpg" width="100" height="100" class="img_name" id="음료02.jpg">
<img src="/img/goods/음료03.jpg" width="100" height="100" class="img_name" id="음료03.jpg">
<img src="/img/goods/음료04.jpg" width="100" height="100" class="img_name" id="음료04.jpg">
<img src="/img/goods/음료05.jpg" width="100" height="100" class="img_name" id="음료05.jpg">
</div>
<div id="스낵">
<img src="/img/goods/스낵01.jpg" width="100" height="100" class="img_name" id="스낵01.jpg">
<img src="/img/goods/스낵02.jpg" width="100" height="100" class="img_name" id="스낵02.jpg">
<img src="/img/goods/스낵03.jpg" width="100" height="100" class="img_name" id="스낵03.jpg">
<img src="/img/goods/스낵04.jpg" width="100" height="100" class="img_name" id="스낵04.jpg">
<img src="/img/goods/스낵05.jpg" width="100" height="100" class="img_name" id="스낵05.jpg">
</div>
사진이름 : <input type="text" id="g_pic_name" name="g_pic_name" readonly="readonly"><br>
상품명 : <input type="text" name="g_name"><br>
가격 : <input type="text" name="g_price"><br>
수량 : <input type="text" name="g_qty"><br>
<button>등록하기</button><br>
<a href="/goods/list_goods">등록 끝내기</a>
</form>
</body>
</html>