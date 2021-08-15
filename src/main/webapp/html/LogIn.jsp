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
<!-- 0809身分蓋掉 -->
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
        <h3 for="text">員工編號</h3>
        <input type="text" 
        id="ENO" 
        placeholder="輸入員編" autocomplete="on" required >
        <span id="idNoSp"></span>
    </div>

    <div>
        <h3 for="text">帳號</h3>
        <input type="text" 
        id="EACC" 
        placeholder="請輸入帳號" autocomplete="off" required >
        <span id="idIdSp"></span>
    </div>
    
    <div>
        <h3 for="password">密碼</h3>
        <input type="password" 
        id="EPD" 
        placeholder="請輸入密碼" autocomplete="off" required >
        <span id="idPwdSp"></span>
    </div>
    
    <div>
    <br>
    <br>

    <button id="Form1" class="btn btn-info">登入</button>
    <!-- 這裡input還是button -->
	<!-- <input type="submit" name="button" id="Form1" value="登入">   -->
	<!-- <button onclick="Submit1()" class="btn btn-info"></button> -->
	</div>
 	<div id="oh"></div>
	</body>

<script>
//4.servlet out printerWriter
$(document).ready(function(){
	$("#Form1").click(function(){
    	if($("#ENO").val()==""){
         alert("請提供員編");
         eval("document.form1['ENO'].focus()");
    	}else if($("#EACC").val()==""){
         alert("你尚未填寫帳號");
         eval("document.form1['EACC'].focus()");
    	}else if($("#EPD").val()==""){
         alert("你尚未填寫密碼");
         eval("document.form1['EPD'].focus()");              
    	}else {
            $("#Form1").click(function(event){	
			var userNo  =$("#ENO").val();
			var userAcc =$("#EACC").val();
			var userPwd =$("#EPD").val();
	    	$.ajax ({	
	    		type :'POST',
				url	: "${pageContext.request.contextPath}/LogIn5?userNo="+userNo+"&userAcc="+userAcc+"&userPwd="+userPwd,
				success : function (data){ 
					$("#oh").html(data);
	    			},
 	    		error : function (error) {
 	 				$("#oh").html("error!!")
	            }
            });
        });
     	}
 	});
});

//  3.ajax debug
		// $("#Form1").click(function(event){	
		// 	var userNo  =$("#ENO").val();
		// 	var userAcc =$("#EACC").val();
		// 	var userPwd =$("#EPD").val();
	    // 	$.ajax ({	
	    // 		type :'POST',
		// 		url	: "${pageContext.request.contextPath}/LogIn4?userNo="+userNo+"&userAcc="+userAcc+"&userPwd="+userPwd,
		// 		success : function (data){ 
		// 			$("#oh").html(data);
        //             alert(data);
	    // 			},
 	    // 		error : function (error) {
 	 	// 			$("#oh").html("error!!")
	    //         }
        //     });
        // });

// 1.button ok
// function Submit1(){
// 	document.form1.action="/JavaServer/LogInController";
// }

// 2.JQ絕對路徑 AJAX form post >> 在alert顯示data
// $(document).ready(function(){
//    $("#button").click(function(){
//        if($("#ENO").val()==""){
//             alert("請提供員編");
//             eval("document.form1['ENO'].focus()");
//        }else if($("#EACC").val()==""){
//             alert("你尚未填寫帳號");
//             eval("document.form1['EACC'].focus()");
//        }else if($("#EPD").val()==""){
//             alert("你尚未填寫密碼");
//             eval("document.form1['EPD'].focus()");              
//        }else {
// 		//看序列化表格資料
// 		//$("#Form1").on("submit", function (event){
// 		//event.preventDefault();
// 		//console.log($(this).serialize());
// // 		  })
//         $("#Form1").submit(function(event){
//         	var form = $(this);
//         	var url = form.attr("action");
        	
// 	        $.ajax ({	
// 	    		type :'POST',
// 	    		url : '${pageContext.request.contextPath}/LogInController',
// 	    		data : form.serialize(),
// 	    		cache : true,
// 	    		success : function (data){ 
// 	    			alert(data)
// 	    		},error : function (error) {
// 	    		console.log("error:", error);
// 	    		}
//      		});
// 			event.preventDefault();
//         }) ;
//         }
//     });
// });
// Mapping?帳密寫法  放棄了
    
</script>
</html>