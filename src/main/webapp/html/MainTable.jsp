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

<!-- 中間內容 -->
<section id="lefter">
    <header>
        <div>
            <h3 id="title1">檢視畫面</h3>
        </div>
			
        <!-- 表格加入以下這段div -->
        
        <div id='mainTable'>
        	<table id='myDataTalbe' class='display'>
        	<thead id='thead'>
        	</thead>
        	<tbody id='tbody'>
            </tbody>
            </table>
            <input class='btn btn-primary' type='button' value='新增' id='buttonAdd'>
        </div>
        
    </header>
<script>
		//Ajax 載入 Table 內容列印
		var dbname = $("#dbname").val();
		
		var keys;
		var data;
		var loadBody = function(){
			console.log(dbname+" in loadData");	//test
			$.ajax ({	
			 		url : '/JavaServer/DatasLoader',
			 		type :'POST',
			 		dataType : 'json',
			 		success : function (res){
			 			//$('#mainTable').load('/JavaServer/EmpReader');
			 			//console.log("res:"+res);	//test
			 			//console.log("typeof res:"+typeof res);	//test
			 			//console.log("res[0]:"+res.length);	//test
			 			//console.log(JSON.stringify(res[0]));
			 			var html;
			 			var result = res[0];
			 			console.log("result = " + result);
			 			for(var i=0;i<result.length;i++){
			 				//console.log(JSON.stringify(res[i]));	//test
			 				//keys = Object.keys(res[i]);
			 				//data = res[i];
			 				//console.log(keys);	//test
			 				//console.log(keys.length);	//test
			 				//console.log(data["emp_key"]);	//test
			 				keys = Object.keys(result[i]);
			 				console.log("keys = " + keys);
			 				html+="<tr>";
			 				for(var j = 0;j<keys.length;j++){
			 					html+="<td id=\""+keys[j]+"\">"+result[i][keys[j]]+"</td>";
			 					console.log(result[i][keys[j]]);	//test
			 					}
			 				html+="<td><button type='button' class='btn btn-warning' id='buttonChg'>修改</button><button type='button' class='btn btn-danger'>刪除</button></td>";
			 				html+="</tr>";
			 				console.log(html);	//test
			 				}
			 			//window.alert(html);
			 			$('#tbody').html(html);
			 			//$('#tbody').html("<tr><td>fadfafasdfgdsf</td></tr>");
			 			},
			 		error : function (error) {
			 			console.log(error);
			 			}
			 	});
			}
		loadBody();
		var title;
		var loadHead = function(){
			switch(dbname){
			case "pcb":
				title = "<tr><th>編號</th><th>電路板編號</th><th>電路板名稱</th><th>電路板創建日</th><th>使用中是/否</th><th>停用日期</th><th></th></tr>";
				$('thead').html(title);
				break;
			case "employee":
				title = "<tr><th>編號</th><th>員工編號</th><th>帳號</th><th>密碼</th><th>姓名</th><th>職稱</th><th>照片</th><th>權限</th><th>入職日期</th><th>離職日期</th><th></th></tr>";
				$('thead').html(title);
				break;
			case "assy":
				title = "<tr><th>組裝編號</th><th>電路板編號</th><th>零件編號</th><th>零件總數量</th><th>組裝日</th><th>使用中是/否</th><th>組裝停止日</th><th></th></tr>";
				$('thead').html(title);
				break;
			case "compo":
				title = "<tr><th>編號</th><th>零件編號</th><th>零件名稱</th><th>零件創建日</th><th>使用中是/否</th><th>零件停用日</th><th></th></tr>";
				$('thead').html(title);
				break;
			case "img":
				title = "<tr><th>圖片編號</th><th>錯誤位置</th><th>偵測結果編號</th><th>圖片URL</th><th>圖片創建日</th><th></th></tr>";
				$('thead').html(title);
				break;
			case "result":
				title = "<tr><th>偵測編號</th><th>組裝編號</th><th>員工編號</th><th>零件總數</th><th>正確數量</th><th>錯誤數量</th><th>錯誤位置</th><th>偵測總時間</th><th>掃描結果日期</th><th></th></tr>";
				$('thead').html(title);
				break;
			default:
			}
		}
		loadHead();
</script>
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
			//$.ajax ({	
		 	//	url : '/JavaServer/DatasLoader',
		 	//	type :'POST',
		 	//	dataType : 'json',
		 	//	success : function (res){
		 	//		//$('#mainTable').load('/JavaServer/EmpReader');
		 	//		console.log("res:"+res);
		 	//		},
		 	//	error : function (error) {
		 	//		console.log(error);
		 	//		}
		 	//});
			$(this).parents('tr').remove();
		});
		// 重整鍵
		$('#refresh').click(function () {
			console.log("refresh click~??");	//test
			loadBody();
		});

		// 新增鍵
		$('#buttonAdd').click(function () {
			//$('table').append("<tr><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><a class='btn btn-success'>確定</a><a class='btn btn-danger'>刪除</a></td></tr>");
			var newtext = "<tr>";
			for(var i = 0;i<keys.length;i++){
				var key = keys[i];
				var Today = new Date();
				var string = "assy_create, compo_create, emp_hired, pcb_create";
				if (key=="assy_alive" || key=="pcb_alive" || key=="compo_alive"){
					newtext+="<td><select name='"+key+"'><option>Y</option><option>N</option></select></td>"
			    }
				else if (string.includes(key)){
					newtext+="<td><input type='text' name='"+key+"' value=" + Today.getFullYear() + - + (Today.getMonth() + 1) + - + Today.getDate() + " ></td>"
			    }
				else if (key=="assy_parts"){
					newtext+="<td><input type='number' min='0' class='form-control number' name='"+key+"'></td>"
				}
				
				else{newtext+="<td><input type='text' value='' name='"+key+"'></td>";}
			}
			newtext+="<td><a class='btn btn-success'>確定</a><a class='btn btn-danger'>刪除</a></td></tr>";
			console.log(newtext);
			$('table').append(newtext);
		});

		
		// 修改鍵
		$("#myDataTalbe").on("click", ".btn-warning", function () {
			//get $('this') object{key:value}
			var tr = $(this).parents('tr');
			//var obj = {};
			var text = "<tr>";
			console.log(typeof obj);	//test
			for(var j = 0;j<keys.length;j++){
				var tag="td:eq("+j+")";
				var key = keys[j];
				var value = tr.find(tag).text();
				console.log(key);	//test
				console.log(value);	//test
				//obj[key] = value;
				if(key=="assy_pcb"){
				     text+="<td><select name="+key+"><option disabled>"+ value + "</option><option>A01</option><option>A02</option><option>A03</option><option>A04</option></select></td>"
				    }
				    else if (key=="assy_compo"){
				     text+="<td><select name="+key+"><option disabled>"+ value + "</option><option>CAP01</option><option>CAP02</option></select></td>"
				    }
				    else if (key=="assy_parts"){
				     text+="<td><input type='number' min='0' class='form-control number' name="+key+" value="+value+"></td>"
				    }
				    else if (key=="assy_alive"){
				     text+="<td><select name="+key+"><option>Y</option><option>N</option></select></td>"
				    }
				    else if (key=="assy_compo"){
				     text+="<td><select name="+key+"><option disabled>"+ value + "</option><option>CAP01</option><option>CAP02</option></select></td>"
				    }
				    
				    
				    else if (key=="pcb_no"){
				     text+="<td><select name="+key+"><option disabled>"+ value +"</option><option>A01</option><option>A02</option><option>B01</option><option>B02</option><option>C01</option></select></td>"
				    }
				    else if (key=="pcb_name"){
				     text+="<td><select name="+key+"><option disabled>"+ value +"</option><option>極速SERVERPCB-2021</option><option>超極速SERVERPCB-2021</option><option>M03系PCB-2107</option><option>M03+系PCB-2018</option><option>高工SERVERPCB</option></select></td>"
				    }
				    else if (key=="pcb_alive"){
				     text+="<td><select name="+key+"><option>Y</option><option>N</option></select></td>"
				    }
				    
				    
				    else if (key=="compo_no"){
				     text+="<td><select name="+key+"><option disabled>"+ value + "</option><option>CAP</option><option>SLOT</option></select></td>"
				    }
				    else if (key=="compo_name"){
				     text+="<td><select name="+key+"><option disabled>"+ value + "</option><option>特規電容器</option><option>插槽</option></select></td>"
				    }
				    else if (key=="compo_alive"){
				     text+="<td><select name="+key+"><option disabled>"+ value + "</option><option>Y</option><option>N</option></select></td>"
				    }
				    
				    else{text+="<td><input type='text' size='2' value="+value+" name="+key+" ></td>";}
				    console.log(text);
				    
					}
			text+= "<td><a class='btn btn-success'>確定</a><a class='btn btn-danger'>刪除</a></td></tr>";
			console.log(text);	//test
			
			$(this).parents('tr').before(text);
			//var update=$('#myDataTalbe :input').serialize();
			//$('#test').html(update).append("!!!!!?");
			//
			//var key = tr.find('td:eq(0)').text();
			//var no = tr.find('td:eq(1)').text();
			//var acc = tr.find('td:eq(2)').text();
			//var pwd = tr.find('td:eq(3)').text();
			//var name = tr.find('td:eq(4)').text();
			//var job = tr.find('td:eq(5)').text();
			//var img = tr.find('td:eq(6)').text();
			//var mgr = tr.find('td:eq(7)').text();
			//var hired = tr.find('td:eq(8)').text();
			//var leave = tr.find('td:eq(9)').text();
            // $('table')   
            //
            //$(this).parents('tr').before("<tr>\
			//	<td><input type='text' size='2' value=" + key + " ></td>\
			//	<td><input type='text' size='2' value=" + no + " ></td>\
			//	<td><input type='text' size='2' value=" + acc + " ></td>\
			//	<td><input type='text' size='2' value=" + pwd + " ></td>\
			//	<td><input type='text' size='2' value=" + name + " ></td>\
			//	<td><input type='text' size='2' value=" + job + " ></td>\
			//	<td><input type='text' size='2' value=" + img + " ></td>\
			//	<td><input type='text' size='2' value=" + mgr + " ></td>\
			//	<td><input type='text' size='2' value=" + hired + " ></td>\
			//	<td><input type='text' size='2' value=" + leave + " ></td><td>\
			//	<a class='btn btn-success'>確定</a>\
			//	<a class='btn btn-danger'>刪除</a>\
			//	</td></tr>");
			//
			$(this).parents('tr').remove();
			});


		// 確定鍵
		$("#myDataTalbe").on("click", ".btn-success", function () {
			var tr1 = $(this).closest('tr');
			// serializes the input's elements.
			var update1=$('#myDataTalbe :input').serialize();	
			var update2=$('#myDataTalbe :checked').serialize();
			console.log(update1+update2);	//test
			$.ajax({
		          url: '/JavaServer/MainUpdate',
		          type: "POST",
		          data: update1+update2, 
		          success: function(data){
		          		window.alert("succeed!?");	//test
		          		loadBody();
		          		},
		          error : function (error) {
			 			console.log(error);
						}
		      	});
			window.alert("out of Ajax succeed!?");	//test
			//var key1 = tr1.find('td:eq(0)').find("input").val();
			//var no1 = tr1.find('td:eq(1)').find("input").val();
			//var acc1 = tr1.find('td:eq(2)').find("input").val();
			//var pwd1 = tr1.find('td:eq(3)').find("input").val();
			//var name1 = tr1.find('td:eq(4)').find("input").val();
			//var job1 = tr1.find('td:eq(5)').find("input").val();
			//var img1 = tr1.find('td:eq(6)').find("input").val();
			//var mgr1 = tr1.find('td:eq(7)').find("input").val();
			//var hired1 = tr1.find('td:eq(8)').find("input").val();
			//var leave1 = tr1.find('td:eq(9)').find("input").val();
			
			//$(this).parents('#tbody').remove();
            //$(this).parents('tr').before(`<tr>\
			//	<td>${key1}</td>\
			//	<td>${no1}</td>\
			//	<td>${acc1}</td>\
			//	<td>${pwd1}</td>\
			//	<td>${name1}</td>\
			//	<td>${job1}</td>\
			//	<td>${img1}</td>\
			//	<td>${mgr1}</td>\
			//	<td>${hired1}</td>\
			//	<td>${leave1}</td>\
			//	<td>\
			//		<a class="btn btn-warning" id="buttonChange">修改</a>\
			//		<a class="btn btn-danger">刪除</a>\
			//	</td>\
			//	</tr>`);
			//$(this).parents('tr').remove();


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