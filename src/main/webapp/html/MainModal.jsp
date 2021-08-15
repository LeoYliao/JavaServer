<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 0805 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Staff Info List</title>    
<!-- 防 cache -->
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>

<body style= 'background-color:#BEBEBE'>
<div align ="left">
<h3>Staff Info List</h3><br>

<h1>Welcome to server</h1>
<form action="/JavaServer/MainReader" method="post">
<input type="text" name="dbname"><br><br>
<input type="submit" value="Search">
</form>
<br>
</div>
</body>
</html>