<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" import= "java.util.*" %>
<!DOCTYPE html>
<html lang="zh-TW">
<head><title>ERP LogIn Page</title>
<!-- 防 cache -->
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<!-- 原前端import -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/public/css/login.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;700&display=swap" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
    <h2>AI 電子零件辨識系統</h2>
    <i class="fa fa-user-circle-o"></i>
    <form method="post"  id="Form1" name="Form1" action="/JavaServer/LogIn6">

    <div>
        <h3 for="text">員工編號</h3>
        <input type="text" 
        id="ENO" name="ENO"
        placeholder="輸入員編" autocomplete="on" required >
        <span id="idNoSp"></span>
    </div>

    <div>
        <h3 for="text">帳號</h3>
        <input type="text" 
        id="EACC" name="EACC"
        placeholder="請輸入帳號" autocomplete="off" required >
        <span id="idIdSp"></span>
    </div>
    
    <div>
        <h3 for="password">密碼</h3>
        <input type="password" 
        id="EPD" name="EPD" 
        placeholder="請輸入密碼" autocomplete="off" required >
        <span id="idPwdSp"></span>
    </div>
<!--     <div> -->
<!--         <h3>身份</h3> -->
<!--         <select name="JOB" id="JOB"> -->
<!--             <option class="ds" value="" disabled selected>請選擇身份</option> -->
<!--             <option value="engineer">檢查員</option> -->
<!--             <option value="manager">主管</option> -->
<!--             <option value="admin">系統管理員</option> -->
<!--         </select> -->
<!--     </div> -->
    <div>
    <br>
    <button type="submit" id="Form1" class="btn btn-info">登入</button>
<!--<input type="submit" id="Form1" value="登入">   -->
<!--<button onclick="Submit1()" class="btn btn-info">登入</button> -->
	</form>
	</div>
<!--  	<div id="oh"></div> -->
	</body>
<script>
//2.
//  $(document).ready(function(){
// 	$("#Form1").click(function(){
//     $("#Form1").Submit1(){ 
// 		console.log("a")
//     	if($("#ENO").val()==""){
//          alert("請提供員編");
//          eval("document.Form1['ENO'].focus()");
//     	}else if($("#EACC").val()==""){
//          alert("你尚未填寫帳號");
//          eval("document.Form1['EACC'].focus()");
//     	}else if($("#EPD").val()==""){
//          alert("你尚未填寫密碼");
//          eval("document.Form1['EPD'].focus()");              
//     	}else {
//     		console.log("b");
//             $("#Form1").Submit1(){
// 				console.log("c");
// 				var userNo  =$("#ENO").val();
// 				var userAcc =$("#EACC").val();
// 				var userPwd =$("#EPD").val();
// 		        document.Form1.action="/JavaServer/LogIn6";
//         };
//      	}
//  	};
// });

// 1.button into funtion ok
// function Submit1(){
// 	document.Form1.action="/JavaServer/LogIn6";
// }
</script>
</html>