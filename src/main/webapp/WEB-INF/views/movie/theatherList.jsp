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
function a(no){
	var sel = document.querySelector("#sel");
	sel.value = no;
	console.log(typeof no)
	var data = {m_no: no};
	console.log(data);
	$.ajax("/movie/selecttheather",{data:data,success:function(re){
		console.log(re);
		$("#theather").empty();
		$("#theather_date").empty();
		$.each(re,function(idx,t){
			
			console.log(t.branch_name);
			var p = $("<p></p>").append(t.branch_name);
			$(p).attr('class', 'p');
			$(p).attr('n', t.branch_no);
			$(p).attr('m', t.m_no);
			$("#theather").append(p);
			});

			var p_list = $(".p");
			for(var i = 0; i < p_list.length; i++){
				p_list[i].addEventListener("click",d);
				}
		}});

	function d(){
		var n = this.getAttribute("n");
		var m = this.getAttribute("m");
		var data = {branch_no:n, m_no:m};
		$.ajax("/movie/selectdate",{data:data,success:function(re){
			$("#theather_date").empty();
			$.each(re,function(idx,d){
				var p = $("<p></p>").append(d.screening_start);
				$("#theather_date").append(p);
				});
		}});
	}
}

</script>
<body>
선택한 영화 번호
<c:forEach items="${theather }" var="t" begin="1" end="1">
	<input type="text" value="${t.m_no }" readonly="readonly" id="sel"><br>
</c:forEach>
모든 영화 목록 번호<br>
<c:forEach items="${allList }" var="a">
	<input type="text" value="${a.m_title }" readonly="readonly" onclick="a(${a.m_no})"><br>
</c:forEach><br>

영화관<br>
<div id="theather">
</div>

날짜<br>
<div id="theather_date">
</div>


시간<br>


</body>
</html>