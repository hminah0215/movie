<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

//장바구니 담기
function cart(g_no){
	//alert(g_no);
	//상품 이름
	var g_name = document.querySelector("#g_name"+g_no);
	//console.log(g_name.value);
	var in_g_name = g_name.value;
	
	//상품 가격
	var g_price = document.querySelector("#g_price"+g_no);
	var in_g_price = g_price.value;
	
	//구입 수량
	var buy_qty = document.querySelector("#buy_qty"+g_no);
	var in_buy_qty = buy_qty.value;

	//총 가격
	var cnt_price = document.querySelector("#cnt_price"+g_no);
	var in_cnt_price = in_g_price * in_buy_qty;

	var chk = confirm("장바구니에 "+ in_g_name + "를" + in_buy_qty + "개 담을까요? 총 가격은" + in_cnt_price +"입니다");
	if(chk == true){
	var data = {c_name:in_g_name,c_qty:in_buy_qty,g_no:g_no,rs_no:0,c_price:in_g_price};
	
	$.ajax("/goods/insert_cart",{data:data,success:function(re){
			alert(re);
			var move = confirm("장바구니 목록으로 이동할까요?");
			if(move == true){
				window.location='/goods/list_cart';
			}else{
				window.location.reload='true';
				}
		}});
	}
		
}

//구입 수량에 수 입력하면 가격 계산
function cnt(g_no){
	
	var g_price = document.querySelector("#g_price"+g_no);
	console.log(g_price.value);
	
	var buy_qty = document.querySelector("#buy_qty"+g_no);
	console.log(buy_qty.value);

	var cnt_price = document.querySelector("#cnt_price"+g_no);
	cnt_price.value = g_price.value * buy_qty.value;
}


</script>
<body>
<h2>상품 목록</h2>
<hr>
<a href="/goods/list_cart">장바구니 목록</a><br><br>
상품 종료 : <a href="/goods/list_goods">전체</a> &nbsp;&nbsp; <a href="/goods/list_goods?g_type=콤보">콤보</a> &nbsp;&nbsp; <a href="/goods/list_goods?g_type=팝콘">팝콘</a> &nbsp;&nbsp; <a href="/goods/list_goods?g_type=음료">음료</a> &nbsp;&nbsp; <a href="/goods/list_goods?g_type=스낵">스낵</a><br><br>
<c:forEach items="${list_goods }" var="combo">
<div style="border: 1px solid; margin-bottom: 10px">
상품종류 : <input type="text" readonly="readonly" value="${combo.g_type }" id="g_type${combo.g_no }"> <br>
상품이름 : <input type="text" readonly="readonly" value="${combo.g_name }" id="g_name${combo.g_no }"> <br>
상품가격 : <input type="text" readonly="readonly" value="${combo.g_price }" id="g_price${combo.g_no }"> <br>
남은수량 : <input type="text" readonly="readonly" value="${combo.g_qty }" id="g_qty${combo.g_no }"> <br>
상품사진<br>
<img src="/img/goods/${combo.g_pic_name }"><br>
구입수량<input type="text" required="required" id="buy_qty${combo.g_no }" onkeyup="cnt(${combo.g_no })"><br>
가격  * 수량 : <input type="text" readonly="readonly" id="cnt_price${combo.g_no }"><br>
<button type="button" id="btn${combo.g_no }" onclick="cart(${combo.g_no })">장바구니 담기</button><br>
</div>
</c:forEach>
<a href="/goods/insert_goods_form">상품등록</a>
</body>
</html>