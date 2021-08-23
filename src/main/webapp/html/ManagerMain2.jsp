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
    <title>主管主畫面</title>
    <link rel="stylesheet" href="<%=basePath%>public/css/managermain.css" type="text/css" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" />

    <script src="https://code.jquery.com/jquery-3.6.0.js"
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" /> 

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</head>

<body class="is-preload" id="kingbody">
<input id="dbname" style="display:none" value=<%=session.getAttribute("dbname")%>>


<!-- 中間內容 -->
<section style="display:" id="lefter1">
    <div>
        <h3 id="title1">錯誤統計</h3>
    </div>
    <div class="pieID pie"> </div>
    <ul class="pieID legend">
      <li>
        <em>Humans</em>
        <span>718</span>
      </li>
      <li>
        <em>Dogs</em>
        <span>531</span>
      </li>
      <li>
        <em>Cats</em>
        <span>868</span>
      </li>
      <li>
        <em>Slugs</em>
        <span>344</span>
      </li>
      <li>
        <em>Aliens</em>
        <span>1145</span>
      </li>
    </ul>
  
</section>
<section style="display:" id="lefter2">
    <div>
        <h3 id="title1">一週偵測錯誤變化</h3>
    </div>
    <div id="chart">
        <div id="timeline-chart"></div>
    </div>
</section>

<section id="lefter3">
    <header>
        <div>
            <h3 id="title1">查詢結果</h3>
        </div>

        <!-- 表格加入以下這段div -->
        <div id="mainTable">
            <table id='myDataTalbe' class='display'>
        	<thead id='thead'>
        	</thead>
        	<tbody id='tbody'>
            </tbody>
            </table>
            <input class='btn btn-primary' type='button' value='新增' id='buttonAdd' style="display:none">
       </div>
    </header>
 <script>
		//Ajax 載入 Table 內容列印
		var dbname=$("#dbname").val();;
		var keys;
		var data;

		//var a = [5, 10, 5, 5];
		var a = [];
	    var b = [];//[5, 10, 5, 5, 5];
		
		var loadBody = function(){
			var importButton;
			console.log("dbname in body = "+dbname);	//test
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
			 			//a.push(10);
			 			var obj = catchData(result);
			 			a = obj.a;
			 			b = obj.b;
			 			console.log('a = ', a);
			 			console.log('b = ', b);
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
			 				if(dbname=="result"){
			 				html+="<td><button type='button' class='btn btn-danger'>刪除</button></td>";
			 					}else{
			 				html+="<td><button type='button' class='btn btn-warning' id='buttonChg'>修改</button><button type='button' class='btn btn-danger'>刪除</button></td>";		
			 					}
			 				html+="</tr>";
			 				console.log(html);	//test
			 				}
			 			window.alert('ajax success!');
			 			$('#tbody').html(html);
			 			//$('#tbody').html("<tr><td>fadfafasdfgdsf</td></tr>");
			 			if(dbname=="result"){
			 				$('#buttonAdd').css("display","none");
			 					}else{
			 				$('#buttonAdd').css("display","");
			 					}
			 			},
			 		error : function (error) {
			 			console.log(error);
			 			}
			 	});
				
			}
		
		function catchData(result) {
			let a = [];
			let b = [];//[5, 10, 5, 5, 5];
			for(var i=0;i<result.length;i++){
				
				switch(result[i]['r_assykey']) {
					case 1:
						a.push(result[i]['r_errqty']);
						break;
					case 2:
						b.push(result[i]['r_errqty']);
						break;
				}
			};
			console.log(a);
			return {a, b};
		};
		
		var loadHead = function(){
			var title;
			console.log("dbname in head = "+dbname);	//test
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
			console.log("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffff : "+title);	//test
			}
		
		
</script>   
</section>
<section id="header">
    <header>
        <span class="image avatar"><img src="<%=basePath%>public/images/selectAsm/avatar.jpg" alt="" /></span>
        <h1 id="idId"><%=session.getAttribute("userName")%></h1>
        <p id="number"><%=session.getAttribute("userNo")%></p>
        <h4 id="position">主管</h4>
    </header>
    <nav id="nav">				
        <form method="POST" id="contoller">
            <ul>					
                <!-- 原來的button已分別塞入所有按鈕的第三行 -->
                <!-- <li><button type="submit" class="active" id="start" name="folder" value="imgs">開始辨識</button></li> -->
                <!-- <li><button type="submit" class="active" name="snapshot"onclick="self.location.href='/capture'" >拍照</button></li> -->
                <!-- <li><button type="button" class="active" id="start" name="folder" value="imgs">開始辨識</button></li> -->
                <!-- <li><button onclick="" class="active">停止辨識</button></li> -->
                <!-- <li><button type="reset" onclick="reset" class="active">重置</button></li> -->

                 <div><li>
                    <a onclick=""><div class='wrapper22'>
                         <button type="button" name="snapshot" onclick="" id="empButton" value="employee" class='btn22'>
                           		<span class='top22 content22'>員工資料表</span>
                           		<span class='bottom22 content22'>Members</span>
                          </button>
                    </div></a>
                </div></li>
    
                <div><li>
                    <a onclick=""><div class='wrapper22'>
                         <button type="button" name="folder" id="pcbButton" value="pcb" class='btn22'>
                          		<span class='top22 content22'>主機版資訊</span>
                            	<span class='bottom22 content22'>PCBs</span>
                        </button>
                    </div></a>
                </div></li>	

                <div><li>
                    <a onclick=""><div class='wrapper22'>
                       <button type="button" name="button" id="assyButton" value="assy" class='btn22' onclick="">
                        		<span class='top22 content22'>零件資訊</span>
                          		<span class='bottom22 content22'>Components</span>
                        </button>
                    </div></a>
                </div></li>

                <div><li>
                    <a onclick=""><div class='wrapper22'>
                        <button type="button" name="button" id="comButton" value="compo" class='btn22' onclick="">
                            <span class='top22 content22 lilfont'>主機板與零件配對表</span>
                            <span class='bottom22 content22'>Pairing</span>
                        </button>
                    </div></a>
                </div></li>

                <div><li>
                    <a onclick=""><div class='wrapper22'>
                        <button type="button" name="button" id="rsButton" value="result" class='btn22' onclick="">
                            <span class='top22 content22'>偵測結果</span>
                            <span class='bottom22 content22'>Result</span>
                        </button>
                    </div></a>
                </div></li> 

                <div><li>
                    <a href="<%=basePath%>html/login.jsp" onclick=""><div class='wrapper22'>
                        <button type="button" name="button" id="button" value="登出" class='btn22' onclick="self.location.href='/'">
                            <span class='top22 content22'>登出</span>
                            <span class='bottom22 content22'>Logout</span>
                        </button>
                    </div></a>
                </div></li>
            </ul>
        </form>
    </nav>
<%--     <img src="<%=basePath%>public/images/managers/01010101.png" width="100px">
 --%></section>


<script src="<%=basePath%>public/javascript/manager/jquery.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/manager/jquery.scrollex.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/manager/jquery.scrolly.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/manager/browser.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/manager/breakpoints.min.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/manager/util.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/manager/main.js" type='text/JavaScript'></script>
<script src="<%=basePath%>public/javascript/manager/chart1.js" type='text/JavaScript'></script>

<!--引用jQuery-->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<!--引用dataTables.js-->
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>



<script>
// TableCreate
var createTable = function(){
	loadBody();
	loadHead();
	
}
$(document).ready(function(){
	$("#myDataTalbe").dataTable({
		"language": {
    		"processing": "處理中...",
    		"loadingRecords": "載入中...",
    		"lengthMenu": "顯示 _MENU_ 項結果",
    		"zeroRecords": "沒有符合的結果",
    		"info": "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
    		"infoEmpty": "顯示第 0 至 0 項結果，共 0 項",
    		"infoFiltered": "(從 _MAX_ 項結果中過濾)",
   			"infoPostFix": "",
    		"search": "搜尋:",
    		"paginate": {
        		"first": "第一頁",
        		"previous": "上一頁",
        		"next": "下一頁",
        		"last": "最後一頁"
    		},
    		"aria": {
        		"sortAscending": ": 升冪排列",
        		"sortDescending": ": 降冪排列"
    			}
			},
		//"destroy":true,
		//"deferRender": true,
		//"stateSave":true,
		"searching": false
		});	
});
createTable();

 // 刪除鍵
	$("#myDataTalbe").on("click", ".btn-danger", function () {
		// $("#example").on("click", ".btn-danger", function () {
		var tr = $(this).parents('tr');
		var key = tr.find('td:eq(0)').text();
		var strData = keys[0]+"="+key;
		console.log(strData);	//test		
		$.ajax ({	
	 		url : '/JavaServer/MainDelete?'+strData,
	 		type :'POST',
	 		success : function (res){
	 			//$('#mainTable').load('/JavaServer/EmpReader');
	 			window.alert("Delete done!!?")
	 			loadBody();
	 			},
	 		error : function (error) {
	 			console.log(error);
	 			}
	 	});
		//$(this).parents('tr').remove();
	});
		
	// 右測顯示切換鍵
	$('#empButton,#pcbButton,#assyButton,#comButton').click(function () {
		dbname = this.value;
		console.log("員工資料表 click~?? "+dbname);	//test
		$.ajax ({	
	 		url : '/JavaServer/TableConfirm?dbname='+dbname,
	 		type :'POST',
	 		success : function (res){
	 			//$('#mainTable').load('/JavaServer/EmpReader');
	 			window.alert("TableConfirm "+dbname+" done!!?")
	 			$('#lefter1,#lefter2').css("display","none");
	 			$('#lefter3').css({"height": "90.5%","width": "78.9%","left": "44%","top": "50%"});
	 			$('#mainTable').css("height","80%");
	 			createTable();
	 			},
	 		error : function (error) {
	 			console.log(error);
	 			}
	 	});
	});
	
	// 偵測結果鍵
	$('#rsButton').click(function () {
		dbname = this.value;
		console.log("偵測結果 click~?? "+dbname);	//test
		$.ajax ({	
	 		url : '/JavaServer/MainError?dbname='+dbname,
	 		type :'POST',
	 		success : function (res){
	 			//$('#mainTable').load('/JavaServer/EmpReader');
	 			window.alert("TableConfirm "+dbname+" done!!?")
	 			$('#lefter1,#lefter2').css("display","");
	 			$('#lefter3').css({"height": "43.5%","width": "78.9%","left": "44%","top": "73.5%"});
	 			$('#mainTable').css("height","60%");
	 			createTable();
	 			},
	 		error : function (error) {
	 			console.log(error);
	 			}
	 	});
	});
	//dataTable position
	//$(document).ready(function(){
    
	//	});


	// 新增鍵
	$('#buttonAdd').click(function () {
		//$('table').append("<tr><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><a class='btn btn-success'>確定</a><a class='btn btn-danger'>刪除</a></td></tr>");
		var newtext = "<tr>";
		for(var i = 0;i<keys.length;i++){
			var key = keys[i];
			var Today = new Date();
			var string = "assy_create, compo_create, emp_hired, pcb_create";
			if (key=="assy_alive" || key=="pcb_alive" || key=="compo_alive"){
				newtext+="<td><select style:'text-align:center' name='"+key+"'><option>Y</option><option>N</option></select></td>"
		    }
			else if (string.includes(key)){
				newtext+="<td><input style:'text-align:center' type='text' name='"+key+"' value=" + Today.getFullYear() + - + (Today.getMonth() + 1) + - + Today.getDate() + " ></td>"
		    }
			else if (key=="assy_parts"){
				newtext+="<td><input style:'text-align:center' type='number' min='0' class='form-control number' name='"+key+"'></td>"
			}
			
			else{newtext+="<td><input style:'text-align:center' type='text' value='' name='"+key+"'></td>";}
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
			     text+="<td><select style='text-align:center' name="+key+"><option disabled>"+ value + "</option><option>A01</option><option>A02</option><option>A03</option><option>A04</option></select></td>"
			    }
			    else if (key=="assy_compo"){
			     text+="<td><select style='text-align:center' name="+key+"><option disabled>"+ value + "</option><option>CAP01</option><option>CAP02</option></select></td>"
			    }
			    else if (key=="assy_parts"){
			     text+="<td><input style='text-align:center' type='number' min='0' class='form-control number' name="+key+" value="+value+"></td>"
			    }
			    else if (key=="assy_alive"){
			     text+="<td><select style='text-align:center' name="+key+"><option>Y</option><option>N</option></select></td>"
			    }
			    else if (key=="assy_compo"){
			     text+="<td><select style='text-align:center' name="+key+"><option disabled>"+ value + "</option><option>CAP01</option><option>CAP02</option></select></td>"
			    }
			    
			    
			    else if (key=="pcb_no"){
			     text+="<td><select style='text-align:center' name="+key+"><option disabled>"+ value +"</option><option>A01</option><option>A02</option><option>B01</option><option>B02</option><option>C01</option></select></td>"
			    }
			    else if (key=="pcb_name"){
			     text+="<td><select style='text-align:center' name="+key+"><option disabled>"+ value +"</option><option>極速SERVERPCB-2021</option><option>超極速SERVERPCB-2021</option><option>M03系PCB-2107</option><option>M03+系PCB-2018</option><option>高工SERVERPCB</option></select></td>"
			    }
			    else if (key=="pcb_alive"){
			     text+="<td><select style='text-align:center' name="+key+"><option>Y</option><option>N</option></select></td>"
			    }
			    
			    
			    else if (key=="compo_no"){
			     text+="<td><select style='text-align:center' name="+key+"><option disabled>"+ value + "</option><option>CAP</option><option>SLOT</option></select></td>"
			    }
			    else if (key=="compo_name"){
			     text+="<td><select style='text-align:center' name="+key+"><option disabled>"+ value + "</option><option>特規電容器</option><option>插槽</option></select></td>"
			    }
			    else if (key=="compo_alive"){
			     text+="<td><select style='text-align:center' name="+key+"><option disabled>"+ value + "</option><option>Y</option><option>N</option></select></td>"
			    }
			    
			    else{text+="<td><input style='text-align:center' type='text' size='2' value="+value+" name="+key+" ></td>";}
			    console.log(text);
			    
				}
		text+= "<td><a class='btn btn-success'>確定</a><a class='btn btn-danger'>刪除</a></td></tr>";
		console.log(text);	//test
		
		$(this).parents('tr').before(text);

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


		});
	
	 function generateDayWiseTimeSeries(s, count) {
		    window.alert('chart success!');
			var values = [a, b];
		    var i = 0;
		    var series = [];
		    var x = new Date("11 Nov 2012").getTime();
		    while (i < count) {
		      series.push([x, values[s][i]]);
		      x += 86400000;
		      i++;
		    }
		    return series;
		  }
	
	 function newScript() {
		  return new Promise((resolve, reject) => {
		    const script = document.createElement("script");
		    script.src = "<%=basePath%>public/javascript/manager/lefter copy.js";
		    script.addEventListener("load", () => {
		      resolve();
		    });
		    script.addEventListener("error", (e) => {
		      reject(e);
		    });
		    document.body.appendChild(script);
		  });
		}
	 newScript();
</script>

<script src="https://cdn.jsdelivr.net/npm/apexcharts" type="text/JavaScript"></script>
<!--<script src="<%=basePath%>public/javascript/manager/lefter copy.js" type="text/JavaScript"></script>-->



</body>

</html>

<!-- //載入尾段 -->
