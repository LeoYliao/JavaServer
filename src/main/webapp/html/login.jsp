<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import= "java.util.* ,DbBean.*,java.lang.*" %>
<%--@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" --%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- è¼å¥é ­é¨æ®µ -->
<!DOCTYPE html>
    <html lang="zh-TW">
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" href="<%=basePath%>public/css/login.css" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;700&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<input id='errormsg' style="display:none" value=<%=request.getAttribute("error") %> >
<!-- ä¸­éå§å®¹ -->
<form name="form1" id="Form1" action="<%=basePath%>MainLogIn" method="post" class="login" onclick="return false">
    <!-- <img src="<%=basePath%>public/images/login/01010101.png"> -->
    <!-- <h2>AI é»å­é¶ä»¶è¾¨è­ç³»çµ±</h2> -->
    <!-- <i class="fa fa-user-circle-o"></i> -->
    <!-- <div> 
        <h3>èº«ä»½</h3>
        <select name="JOB" id="JOB">
            <option class="ds" value="" disabled selected>è«é¸æèº«ä»½</option>
            <option value="engineer">æª¢æ¥å¡</option>
            <option value="manager">ä¸»ç®¡</option>
            <option value="admin">ç³»çµ±ç®¡çå¡</option>
        </select>
    </div> -->
    <div>
        <h3 for="text">帳號</h3>
        <input type="text" name="EACC" id="EACC" placeholder="請輸入帳號" autocomplete="off" required >
        <span id="idIdSp"></span>
    </div>
    <div>
        <h3 for="password">密碼</h3>
        <input type="password" name="EPD" id="EPD" placeholder="請輸入密碼" autocomplete="off" required >
        <span id="idPwdSp"></span>
    </div>
    <div>
        <a onclick=""><div class='wrapper22'>
			<button type="submit" name="button" id="button" value="" class='btn22'>
				<span class='top22 content22'>登入</span>
				<span class='bottom22 content22 hover22'>Login</span>
			</button>
        </div></a>
    </div>
</form>

<script>
    $(document).ready(function(){
        $("#button").click(function(){
            if($("#EACC").val()==""){
                alert("請輸入帳號");
                eval("document.form1['EACC'].focus()");
            // }else if($("#idId").val()>=6){
            //     alert("å¸³èè³å°è¦6åå­");
            //     eval("document.form1['idId'].focus()");   
          

            }else if($("#EPD").val()==""){
                alert("請輸入密碼");
                eval("document.form1['EPD'].focus()"); 
            // }else if($("#idPwd").val()>=6){
            //     alert("å¯ç¢¼è³å°è¦6åå­");
            //     eval("document.form1['idPwd'].focus()");               
            }else{
                document.form1.submit();
            }
        })
    })
    
    //feedback
    var strError=$('#errormsg').val();
    console.log("error masage : "+strError);	//test
    var feedback = function(){
    	if (strError !== "null"){
    		 window.alert("錯誤訊息 : "+strError);
    		}
   		}
    feedback();
   </script>
<!-- //è¼å¥å°¾æ®µ -->
