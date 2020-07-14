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
<h2>상품 목록</h2>
<hr>
<c:forEach items="${list_goods }" var="combo">
${combo.g_type }<br>
${combo.g_name }<br>
${combo.g_price }<br>
${combo.g_qty }<br>
<img src="/img/goods/${combo.g_pic_name }"><br>
</c:forEach>
<a href="/goods/insert_goods_form">상품등록</a>
</body>
</html>