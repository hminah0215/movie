<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	var price = 0;
	//결제 인풋
	var total_pay = document.querySelector("#total_pay");
	total_pay.value = price + "원";

	//체크박스
	var price_list = document.querySelectorAll(".price");
	console.log(price_list);
	for(var i = 0; i < price_list.length; i++){
		price_list[i].onclick = function(){
			if(this.checked == true){
				price += parseInt(this.value);
// 				alert(price);
				}else{
					price -= parseInt(this.value);
// 					alert(price);
					}
			total_pay.value = price + "원";
			};
		}
}

	
</script>
</head>
<body>
<h2>장바구니 목록</h2>
<hr>
<a href="/mypage/main">마이페이지 메인</a>   <a href="/mypage/update_form">내 정보 수정</a>  <a href="/mypage/board">작성한 글</a>  <a href="/wishlist/list_wishlist?user_id=${member.user_id }">위시리스트</a>  <a href="/goods/list_cart?user_id=${member.user_id }">장바구니</a>  <a href="/mypage/pay">결제내역</a>  <a href="/note/list_note?user_id=${member.user_id }">쪽지함</a><br>
<a href="/goods/list_goods">상품목록</a><br><br>
<table border="1" width="40%">
	<tr>
		<th>상품이름</th><th>상품사진<th>수량</th><th>상품번호</th><th>아이디</th><th>개당 가격</th><th>수량 * 가격<th>비고</th><th>결제할 상품 선택</th>
	</tr>
	<c:forEach items="${list_cart }" var="cart">
			<tr>
				<td>${cart.c_name }</td>
				<td> <img src="/img/goods/${cart.g_pic_name }" width="135" height="135"> </td>
				<td>${cart.c_qty }</td>
				<td>${cart.g_no }</td>
				<td>${cart.user_id }</td>
				<td >${cart.c_price }</td>
				<td>${cart.c_price * cart.c_qty}</td>
				<td><a href="/goods/delete_cart?c_no=${cart.c_no }" onclick="return confirm('장바구니에서 삭제하까요?');">삭제</a></td>
				<td><input type="checkbox" class="price" id="price${cart.c_no }" value="${cart.c_price * cart.c_qty}"></td>
			</tr>
	</c:forEach>
</table>
<br>
결졔 금액 : <input type="text" readonly="readonly" id="total_pay"><br>
<button>결제</button>
</body>
</html>