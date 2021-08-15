<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.util.* , DbBean.*" %>
<!DOCTYPE html>
<html>
<head><title>Query</title>
<!-- 防 cache -->
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>
<!-- JQ import -->
<script src="https://code.jquery.com/jquery-3.6.0.js" 
integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" 
crossorigin="anonymous"></script>
<body style= 'background-color:#fdf5e6'>
<div align ="center">
<h1>Query</h1>
<table>
<tr><td>EMPKEY
<td><input type = "text" readonly  name="emp_key"    value="${BOBO.emp_key}">
<tr><td>EMPNO
<td><input type = "text"   readonly name="emp_no"    value="9999">
<tr><td>EACC
<td><input type = "text" readonly  name="emp_acc" value="${BOBO.emp_acc}">
<tr><td>EPD
<td><input type = "text"  readonly name="emp_pwd"   value="${BOBO.emp_pwd}">
<tr><td>ENAME
<td><input type = "text"   readonly name="emp_name"    value="${BOBO.emp_name}">
<tr><td>JOB
<td><input type = "text"   readonly name="emp_job"    value="${BOBO.emp_job}">
<tr><td>EPHOTO
<td><input type = "text"   readonly name="emp_img"    value="${BOBO.emp_img}">
<tr><td>MGR
<td><input type = "text"   readonly name="emp_mgr"    value="${BOBO.emp_mgr}">
<tr><td>HIREDATE
<td><input type = "text"   readonly name="emp_hired"    value="${BOBO.emp_hired}">
<tr><td>LEAVEDATE
<td><input type = "text"   readonly name="emp_leave"    value="${BOBO.emp_leave}">
</table>
</div>
</body>
</html>