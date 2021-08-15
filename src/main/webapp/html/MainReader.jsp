<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import= "java.util.* ,DbBean.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF8">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<title>資料總覽</title>
</head>

<body>
<input id="dbname" style="display:none" value=<%=session.getAttribute("dbname")%>>
<script>
	var dbname=$("#dbname").val();
	var loadData =function(){
			console.log(dbname+" in loadData");
	//switch to right DB
	switch (dbname){
		case 'pcb':
			$('.data').html("<h1>pcb data</h1>");
			break;
		case 'employee':
			
			$('.data').html("<h1>employee data</h1>");
			 	$.ajax ({	
		 		url : '/JavaServer/EmpReader',
		 		type :'POST',
		 		success : function (res){ 
		 			$('.data').html(res);
		 			},
		 		error : function (error) {
		 			console.log(error);
		 		}
		 	});
			break;
		case 'assy':
			$('.data').html("<h1>assy data</h1>");
			break;
		case 'compo':
			$('.data').html("<h1>compo data</h1>");
			break;
		case 'img':
			$('.data').html("<h1>img data</h1>");
			break;
		case 'result':
			$('.data').html("<h1>result data</h1>");
			break;
		default:
			$('.data').html("<h1>no such database</h1>");
		}
	}
</script>
<!-- this  div for head -->
<div>
	<h1 align="center">查詢結果</h1>
</div>

<!-- this  div for body -->
<div align="center" class="data">
	
	<script>loadData();</script>
</div>

<!-- this  div for foot -->
<div align="center">
	<button type="submit" class="refresh" formaction="../MainReader">refresh</button>
	<script>
	//button for reflesh
		var dbname=$("#dbname").val();
		$(".refresh").click(function(){
			//console.log(dbname);
			console.log("click221");
			<%--request.getRequestDispatcher("../MainReader").include(request, response);--%>
			loadData();
			})
	</script>
</div>
</body>
</html>