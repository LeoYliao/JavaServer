<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import= "java.util.* ,DbBean.*,java.lang.*" %>
<%--@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" --%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>查詢結果</title>
    <link rel="stylesheet" href="<%=basePath%>public/css/admin.css" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" />
    
    <script src="https://code.jquery.com/jquery-3.6.0.js"
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" />
</head>

	<body class="is-preload">
<input id="dbname" style="display:none" value=<%=session.getAttribute("dbname")%>>
<script>
	var dbname=$("#dbname").val();
	//var text =[{key:value}];
	//var value;
		var loadData =function(){
				console.log(dbname+" in loadData");
		$.ajax ({	
			 		url : '/JavaServer/DatasLoader',
			 		type :'POST',
			 		contentType:'application/json',
			 		data : JSON.stringify({}),
			 		dataType : 'json',
			 		success : function (res){
			 			//text=new Array(res);
			 			$('#mainTable').load('/JavaServer/EmpReader');
			 			console.log("res:"+res);
			 			//console.log("stop ");
			 			console.log("typeof res:"+typeof res);
			 			//console.log("text.1:"+res.text[0].1.emp_no);
						},
			 		error : function (error) {
			 			console.log(error);
			 			}
			 	});
			}
</script>
<!-- 中間內容 -->
<section id="lefter">
    <header>
        <div>
            <h3 id="title1">檢視畫面</h3>
        </div>
			
        <!-- 表格加入以下這段div -->
        <div id='mainTable'>
            <script>loadData();</script>
        </div>
        
    </header>
</section>
<section id="header">
    <header>
        <span class="image avatar"><img src="<%=basePath%>public/images/selectAsm/avatar.jpg" alt="" /></span>
        <h1 id="idId">張◯睿</h1>
        <p id="number">inspector0002</p>
        <h4 id="position">檢查員</h4>
    </header>
    <nav id="nav">
        <form method="POST" id="contoller">
            <ul>					

                <div>
                    <a onclick=""><div class='wrapper22'>
                        <button type="button" name="button" id="button" value="登出" class='btn22' onclick="self.location.href='/'">
                            <span class='top22 content22'>登出</span>
                            <span class='bottom22 content22'>Logout</span>
                        </button>
                        <input type="button" id="refresh" value="refresh">
                    </div></a>
                </div>

            </ul>
        </form>
    </nav>
</section>

<script src="<%=basePath%>public/javascript/admin/jquery.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/admin/jquery.scrollex.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/admin/jquery.scrolly.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/admin/browser.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/admin/breakpoints.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/admin/util.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/admin/main.js" type='text/JavaScript'></script>
<!--引用jQuery-->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<!--引用dataTables.js-->
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>



    <script>

		// $("#example").DataTable();
		// Table列印
		
	
		// 刪除鍵
		$("#myDataTalbe").on("click", ".btn-danger", function () {
			// $("#example").on("click", ".btn-danger", function () {
			var tr = $(this).parents('tr');
			var key = tr.find('td:eq(0)').text();
			//$.ajax({})
			$(this).parents('tr').remove();
		});
		// 重整鍵
		$('#refresh').click(function () {
			console.log("refresh click~??");
			loadData();
		});

		// 新增鍵
		$('#buttonAdd').click(function () {
			$('table').append("<tr><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><a class='btn btn-success'>確定</a><a class='btn btn-danger'>刪除</a></td></tr>");
			
		});


		// 修改鍵
		$("#myDataTalbe").on("click", ".btn-warning", function () {
			// $("#example").on("click", ".btn-warning", function () {
			var tr = $(this).parents('tr');
			var key = tr.find('td:eq(0)').text();
			var no = tr.find('td:eq(1)').text();
			var acc = tr.find('td:eq(2)').text();
			var pwd = tr.find('td:eq(3)').text();
			var name = tr.find('td:eq(4)').text();
			var job = tr.find('td:eq(5)').text();
			var img = tr.find('td:eq(6)').text();
			var mgr = tr.find('td:eq(7)').text();
			var hired = tr.find('td:eq(8)').text();
			var leave = tr.find('td:eq(9)').text();
            // $('table')
            $(this).parents('tr').before("<tr>\
				<td><input type='text' size='2' value=" + key + " ></td>\
				<td><input type='text' size='2' value=" + no + " ></td>\
				<td><input type='text' size='2' value=" + acc + " ></td>\
				<td><input type='text' size='2' value=" + pwd + " ></td>\
				<td><input type='text' size='2' value=" + name + " ></td>\
				<td><input type='text' size='2' value=" + job + " ></td>\
				<td><input type='text' size='2' value=" + img + " ></td>\
				<td><input type='text' size='2' value=" + mgr + " ></td>\
				<td><input type='text' size='2' value=" + hired + " ></td>\
				<td><input type='text' size='2' value=" + leave + " ></td><td>\
				<a class='btn btn-success'>確定</a>\
				<a class='btn btn-danger'>刪除</a>\
				</td></tr>");
			$(this).parents('tr').remove();
		});


		// 確定鍵
		$("#myDataTalbe").on("click", ".btn-success", function () {
			// $("#example").on("click", ".btn-success", function () {
			var tr1 = $(this).closest('tr');
			var key1 = tr1.find('td:eq(0)').find("input").val();
			var no1 = tr1.find('td:eq(1)').find("input").val();
			var acc1 = tr1.find('td:eq(2)').find("input").val();
			var pwd1 = tr1.find('td:eq(3)').find("input").val();
			var name1 = tr1.find('td:eq(4)').find("input").val();
			var job1 = tr1.find('td:eq(5)').find("input").val();
			var img1 = tr1.find('td:eq(6)').find("input").val();
			var mgr1 = tr1.find('td:eq(7)').find("input").val();
			var hired1 = tr1.find('td:eq(8)').find("input").val();
			var leave1 = tr1.find('td:eq(9)').find("input").val();

            $(this).parents('tr').before(`<tr>\
				<td>${key1}</td>\
				<td>${no1}</td>\
				<td>${acc1}</td>\
				<td>${pwd1}</td>\
				<td>${name1}</td>\
				<td>${job1}</td>\
				<td>${img1}</td>\
				<td>${mgr1}</td>\
				<td>${hired1}</td>\
				<td>${leave1}</td>\
				<td>\
					<a class="btn btn-warning" id="buttonChange">修改</a>\
					<a class="btn btn-danger">刪除</a>\
				</td>\
				</tr>`);
			$(this).parents('tr').remove();


		});


		// $("#myDataTalbe").DataTable({
		//         searching: true, //關閉filter功能
		//         columnDefs: [{
		//             targets: [10],
		//             orderable: false,
		//         }]
		//     });

		$("#myDataTalbe").DataTable({
			"searching": false, //關閉search功能
			"ordering":false,
			"processing":false,

			"paging":false,
            "information":false,
            "info":false,
			// columnDefs: [{
			// 	targets: [3],
			// 	orderable: false,
			// }],
			// serverSide:true
		});



	</script>

</body>

</html>

<!-- //載入尾段 -->