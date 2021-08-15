<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head><title>New</title>
<!-- 防 cache -->
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> -->
</script>
</head>

<body style= 'background-color:#BEBEBE'>
<div align ="left">
<h3> New++ Staff</h3>
<br><!-- 動作方法  到JAVA控制器去 -->
<table>
<form method="post" action="/JavaServer/New">
<tr><td>EMPNO
<td><input type = "text"   name="emp_no"/>
<tr><td>EACC
<td><input type = "text"   name="emp_acc"/>
<tr><td>EPD
<td><input type = "text"   name="emp_pwd"/>
<tr><td>ENAME
<td><input type = "text"   name="emp_name"/>
<tr><td>JOB
<td><input type = "text"   name="emp_job"/>
<tr><td>EPHOTO
<td><input type = "text"   name="emp_img" />
<tr><td>MGR
<td><input type = "text"   name="emp_mgr" />
<!-- <tr><td>HIREDATE -->
<!-- <td><input type = "text"   name="emp_hired" /> -->
<br>
<input type= "submit" 	   value="SUBMIT">
<br>
</form>
</body>
</html>