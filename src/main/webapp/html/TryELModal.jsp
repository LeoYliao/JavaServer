<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import= "java.util.* ,DbBean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html><head><title>Staff Info</title>
<!-- 防 cache -->
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<!-- Bootstrap Table with Search Column Feature -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- JS,JQuery,bootstrap -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body style= 'background-color:#BEBEBE'>
<div align ="left">
<h3>Data of All Staff</h3>
<br>

<!-- New JS 按鈕 -->
 <button type="button" class="btn btn-success" 
 id="new"> New ++ </button>
<!-- Search JS 按鈕 Integer.parseInt問題-->
<button type="button" class="btn btn-dark"
id= "search">Search + </button>

<!-- 網頁本身內容 -->
<table border = "1">
<tr style = "background-color:#8E8E8E">
<th>EMPKEY<th>EMPNO<th>EACC<th>EPD<th>ENAME<th>JOB<th>EPHOTO<th>MGR<th>HIREDATE<th>LEAVEDATE
<c:forEach items="${datas}" var="data" varStatus= "s"><p>
<tr>
<td>${data.emp_key}
<td>${data.emp_no}
<td>${data.emp_acc}
<td>${data.emp_pwd}
<td>${data.emp_name}
<td>${data.emp_job}
<td>${data.emp_img}
<td>${data.emp_mgr}
<td>${data.emp_hired}
<td>${data.emp_leave}
<c:set var="count" value="${s.count}"/>
</c:forEach>
</table>
<h3>共${count}筆資料</h3>
</div>

<!-- Pop Modal按鈕JSTL EL  -->
<!-- <div class="bd-example"><button type="button" class="btn btn-primary"  -->
<!-- data-toggle="modal" data-target="#exampleModalPopovers"> Pop All Modal </button> -->
<!-- <!-- POP ALL摺起頁面 class div都是跳窗範圍 --> 
<!-- <div id="exampleModalPopovers" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalPopoversLabel" aria-hidden="true"> -->
<!--   <div class="modal-dialog" role="document"> -->
<!--     <div class="modal-content"> -->
<!--       <div class="modal-header"> -->
<!--         <h5 class="modal-title" id="exampleModalPopoversLabel">Modal title</h5> -->
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!--           <span aria-hidden="true">&times;</span> -->
<!--         </button> -->
<!--       </div> -->
<!-- <!-- 跳窗上內容/ 按鈕  頁面上灰色段落 --> 
<!--       	<table border = "1"> -->
<!-- 		<tr style = "background-color:#8E8E8E"> -->
<!-- 		<th>EMPKEY<th>EMPNO<th>EACC<th>EPD<th>ENAME<th>JOB<th>EPHOTO<th>MGR<th>HIREDATE<th>LEAVEDATE -->
<%-- 		<c:forEach items="${datas}" var="data" varStatus= "s"><p> --%>
<!-- 			<tr> -->
<%-- 			<td>${data.emp_key} --%>
<%-- 			<td>${data.emp_no} --%>
<%-- 			<td>${data.emp_acc} --%>
<%-- 			<td>${data.emp_pwd} --%>
<%-- 			<td>${data.emp_name} --%>
<%-- 			<td>${data.emp_job} --%>
<%-- 			<td>${data.emp_img} --%>
<%-- 			<td>${data.emp_mgr} --%>
<%-- 			<td>${data.emp_hired} --%>
<%-- 			<td>${data.emp_leave} --%>
<%-- 			<c:set var="count" value="${s.count}"/> --%>
<%-- 		</c:forEach> --%>
<%-- 			<h1>共${count}筆資料</h1> --%>
<!-- 		</table> -->
<!--         <h5></h5> -->
<!--         <p>This <a href="#" role="button" class="btn btn-secondary popover-test" title="Popover title" data-content="Popover body content is set in this attribute." data-container="#exampleModalPopovers">button</a> triggers a popover on click.</p> -->
<!--         <hr /> -->
<!--         <h5>Tooltips in a modal</h5> -->
<!--         <p><a href="#" class="tooltip-test" title="Tooltip" data-container="#exampleModalPopovers">This link</a> and <a href="#" class="tooltip-test" title="Tooltip" data-container="#exampleModalPopovers">that link</a> have tooltips on hover.</p> -->
<!--       </div> -->
<!--       <div class="modal-footer"> -->
<!--         <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
<!--         <button type="button" class="btn btn-primary">Save changes</button>    -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div>  -->
<!-- POP ALL跳窗內容結束 -->

<!-- 0809測試:New modal 跳出更新  tr滑動效果會帶到 -->
<div class="bd-example">
  <button type="button" class="btn btn-danger" data-toggle="modal" 
  data-target="#exampleModalPopovers" id="">
    New Modal++ </button></div>
<!-- Modal頁面 >>  class div都是跳窗範圍 -->
<div id="exampleModalPopovers" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalPopoversLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalPopoversLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
<!-- 跳窗上內容/ 按鈕  頁面上灰色段落 -->
		<table>
		<form method="post" action="/JavaServer/New">
		<tr style = "background-color:#8E8E8E" >
		<tr><td>EMPNO</td>
		<td><input type = "text" name="emp_no"/></td></tr>
		<tr><td>EACC
		<td><input type = "text" name="emp_acc"/>
		<tr><td>EPD
		<td><input type = "text" name="emp_pwd"/>
		<tr><td>ENAME
		<td><input type = "text" name="emp_name"/>
		<tr><td>JOB
		<td><input type = "text" name="emp_job"/>
		<tr><td>EPHOTO
		<td><input type = "text" name="emp_img" />
		<tr><td>MGR
		<td><input type = "text" name="emp_mgr" />
		<input type= "submit" 	 value="SUBMIT">
		<br>
		</form>
		</table>
        <p>This <a href="#" role="button" class="btn btn-secondary popover-test" title="Popover title" data-content="Popover body content is set in this attribute." data-container="#exampleModalPopovers">button</a> triggers a popover on click.</p>
        <hr />
        <h5>Tooltips in a modal</h5>
        <p><a href="#" class="tooltip-test" title="Tooltip" data-container="#exampleModalPopovers">This link</a> and <a href="#" class="tooltip-test" title="Tooltip" data-container="#exampleModalPopovers">that link</a> have tooltips on hover.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>   
      </div>
    </div>
  </div>
</div> <!-- SEARCH跳窗內容結束 -->
</body>

<script>
//JS寫法 New按下新增 done/err頁設定關掉?
//開窗參數列 //時間設定這邊沒用? 頁面不會關
$("#new").click(function(){
	width = ((window.screen.width)/3);
	height = ((window.screen.height)/1.5);
	window.open(
	"/JavaServer/html/New.jsp", "Title","location=no,status=no,menubar=no,toolbar=no,width="
	+ width + ",height=" + height);
	setTimeout(window.close(),2000);
})

//滑動tr染色
$("tr").mouseover(function(){
    $(this).siblings().css("border","solid 3px transparent")
    .end().css("border","solid 3px rgba(100,50,20,0.7)")});

//JS寫法 search按下 查改刪 轉型有問題??
$("#search").click(function(){
	width = ((window.screen.width)/3);
	height = ((window.screen.height)/1.5);
	window.open(
	"/JavaServer/html/Search.html", "Title","location=no,status=no,menubar=no,toolbar=no,width="
	+ width + ",height=" + height);
	setTimeout(window.close(),2000);
})

//JS寫法 tr按下 查改刪 >> controller轉型有問題
//Date / Int counter/ url
// $("tr").click(function(){
//  	$(this).css("border","solid 3px red")
// 	 console.log($(this).find("td:first-child").text())

// 	$(this).find("td:first-child").text()
// 		    width = ((window.screen.width)/3);
// 		    height = ((window.screen.height)/1.5);
// 		    window.open("/JavaServer/QueryEmp", "Title","location=0,status=1,scrollbars=1,resizable=1,menubar=0,toolbar=no,width="
// 		                    + width + ",height=" + height);
// })

//JQ ajax測試url方法只callback返網頁  浪費更多頁面
// $("#new").click(function(){
// 	$.ajax ({	
// 		url : '/JavaServer/html/ok.html',
// 		type :'POST',
// 		cache : true,
// 		success : function (){ 
// 			window.open("/JavaServer/html/confused.html", "Title",
// 	 			"location=0,status=1,scrollbars=1,resizable=1,menubar=0,toolbar=no,width="+ 500 + ",height=" + 500);
// 			},
// 		error : function (error) {
// 			window.open("/JavaServer/html/err.html", "Title",
// 		 			"location=0,status=1,scrollbars=1,resizable=1,menubar=0,toolbar=no,width="+ 500 + ",height=" + 500);
// 			console.log("error:", error);
// 		}
// 	});
// });

//0806 tr ajax >> controller只能純新視窗  無法返value
$("tr").click(function(){
 	console.log("fix!")
 	$(this).css("border","solid 3px red")
 	//get emp_kep , JQ selector p.24 p.73 
	 console.log($(this).find("td:first-child").text())

	var queryPK = $(this).find("td:first-child").text() 
 	$.ajax ({	
		url : '${pageContext.request.contextPath}/QueryEmp?emp_key='+queryPK ,
		type :'GET',
		cache : true,
		success : function (){ 
			window.open("/JavaServer/html/Query.jsp", "Title",
	 			"location=0,status=1,scrollbars=1,resizable=1,menubar=0,toolbar=no,width="+ 500 + ",height=" + 500);
			},
		error : function (error) {
		console.log("error:", error);}// dataType:
	});
})

</script>
</html>