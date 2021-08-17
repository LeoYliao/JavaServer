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
    <title>主管主機板零件配對畫面</title>
    <link rel="stylesheet" href="<%=basePath%>public/css/manager.css" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
        type="text/css" />

    <script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" />

    
</head>
<html>


    <!-- 中間內容 -->
    <section id="lefter">
        <header>
            <div>
                <h3 id="title1">主機板與零件組合檢視畫面</h3>
            </div>

            <!-- 表格加入以下這段div -->
            <div id="mainTable">
                <table id="myDataTalbe" class="display">
                    <!-- <table id="example" class="table table-striped table-bordered" width="100%" cellspacing="0"> -->
                    <thead>
                        <!--必填-->
                        <tr>
                            <th>序號</th>
                            <th>電路板編號</th>
                            <th>零件編號</th>
                            <th>零件總數量</th>
                            <th>創建日</th>
                            <th>Y:使用中 / N:未使用</th>
                            <th>停用日期</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>序號</th>
                            <th>電路板編號</th>
                            <th>零件編號</th>
                            <th>零件總數量</th>
                            <th>創建日</th>
                            <th>Y:使用中 / N:未使用</th>
                            <th>停用日期</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <tr>
                            <td>r_assykey</td>
                            <td>PCNO</td>
                            <td>CNO</td>
                            <td>PARTSAMOUNT</td>
                            <td>CREATEDATE</td>
                            <td>ISALIVE</td>
                            <td>OUTDATE</td>
                            <td>
                                <button type="button" class="btn btn-warning" id="buttonChg">修改</button>
                                <button type="button" class="btn btn-danger">刪除</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <!-- 新增鍵 -->
                <input class="btn btn-primary" type="button" value="新增" id="buttonAdd">
            </div>
        </header>
    </section>
    <section id="header">
        <header>
            <span class="image avatar"><img src="<%=basePath%>public/images/selectAsm/avatar.jpg" alt="" /></span>
            <h1 id="idId">王◯瑄</h1>
            <p id="number">0004</p>
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

                    <div>
                        <li>
                            <a onclick="">
                                <div class='wrapper22'>
                                    <button type="button" name="snapshot" onclick="self.location.href='/capture'"
                                        id="button" value="拍照" class='btn22'>
                                        <span class='top22 content22'>員工資料表</span>
                                        <span class='bottom22 content22'>Edit Members</span>
                                    </button>
                                </div>
                            </a>
                    </div>
                    </li>

                    <div>
                        <li>
                            <a onclick="">
                                <div class='wrapper22'>
                                    <button type="button" name="folder" id="start" value="imgs" class='btn22'>
                                        <span class='top22 content22'>主機版資訊</span>
                                        <span class='bottom22 content22'>X</span>
                                    </button>
                                </div>
                            </a>
                    </div>
                    </li>

                    <div>
                        <li>
                            <a onclick="">
                                <div class='wrapper22'>
                                    <button type="button" name="button" id="button" value="重置" class='btn22' onclick="">
                                        <span class='top22 content22'>零件資訊</span>
                                        <span class='bottom22 content22'>X</span>
                                    </button>
                                </div>
                            </a>
                    </div>
                    </li>

                    <div>
                        <li>
                            <a onclick="">
                                <div class='wrapper22'>
                                    <button type="button" name="button" id="button" value="重置" class='btn22' onclick="">
                                        <span class='top22 content22'>主機板與零件配對表</span>
                                        <span class='bottom22 content22'>X</span>
                                    </button>
                                </div>
                            </a>
                    </div>
                    </li>

                    <div>
                        <li>
                            <a onclick="">
                                <div class='wrapper22'>
                                    <button type="button" name="button" id="button" value="重新選擇零件" class='btn22'
                                        onclick="history.back()">
                                        <span class='top22 content22'>偵測結果</span>
                                        <span class='bottom22 content22'>X</span>
                                    </button>
                                </div>
                            </a>
                    </div>
                    </li>

                    <div>
                        <li>
                            <a onclick="">
                                <div class='wrapper22'>
                                    <button type="button" name="button" id="button" value="登出" class='btn22'
                                        onclick="self.location.href='/'">
                                        <span class='top22 content22'>登出</span>
                                        <span class='bottom22 content22'>Logout</span>
                                    </button>
                                </div>
                            </a>
                    </div>
                    </li>
                </ul>
            </form>
        </nav>
    </section>


    <script src="<%=basePath%>public/javascript/manager/jquery.min.js" type='text/JavaScript'></script>
    <script src="<%=basePath%>public/javascript/manager/jquery.scrollex.min.js" type='text/JavaScript'></script>
    <script src="<%=basePath%>public/javascript/manager/jquery.scrolly.min.js" type='text/JavaScript'></script>
    <script src="<%=basePath%>public/javascript/manager/browser.min.js" type='text/JavaScript'></script>
    <script src="<%=basePath%>public/javascript/manager/breakpoints.min.js" type='text/JavaScript'></script>
    <script src="<%=basePath%>public/javascript/manager/util.js" type='text/JavaScript'></script>
    <script src="<%=basePath%>public/javascript/manager/main.js" type='text/JavaScript'></script>
    <!--引用jQuery-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <!--引用dataTables.js-->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>

    

    <script>
        
        
        
        

        // $("#example").DataTable();

        // 刪除鍵
        $("#myDataTalbe").on("click", ".btn-danger", function () {
            // $("#example").on("click", ".btn-danger", function () {
            $(this).parents('tr').remove();
        });


        // 新增鍵
        $('#buttonAdd').click(function () {
            var Today = new Date();


            $('table').append("<tr>\
                <td><input type='text' value=''></td>\
                <td><input type='text' value=''></td>\
                <td><input type='text' value=''></td>\
                <td><input type='text' value=''></td>\
                <td><input type='text' value=" + Today.getFullYear() + - + (Today.getMonth() + 1) + - + Today.getDate() + " >\
                    </td>\
                <td><select>\
                    <option>Y</option>\
                    <option>N</option>\
                    </select>\
                    </td>\
                <td><input type='text' value=" + Today.getFullYear() + - + (Today.getMonth() + 1) + - + Today.getDate() + " >\
                    </td>\
                <td>\
                    <a class='btn btn-success'>確定</a>\
                    <a class='btn btn-danger'>刪除</a>\
                </td>\
                    </tr>");

        });



        // 修改鍵
        $("#myDataTalbe").on("click", ".btn-warning", function () {
            // $("#example").on("click", ".btn-warning", function () {
            var tr = $(this).parents('tr');
            var key = tr.find('td:eq(0)').text();
            var pcno = tr.find('td:eq(1)').text();
            var cno = tr.find('td:eq(2)').text();
            var partsamount = tr.find('td:eq(3)').text();
            var createdate = tr.find('td:eq(4)').text();
            var isalive = tr.find('td:eq(5)').text();
            var outdate = tr.find('td:eq(6)').text();

            // $('table')
            $(this).parents('tr').before("<tr>\
				<td><input type='text' size='2' value=" + key + " ></td>\
				<td><select>\
                    <option disabled>"+ pcno + "</option>\
                    <option>A01</option>\
                    <option>A02</option>\
                    <option>A03</option>\
                    <option>A04</option>\
                    </select>\
                    </td>\
				<td><select>\
                    <option disabled>"+ cno + "</option>\
                    <option>CAP01</option>\
                    <option>CAP02</option>\
                    </select>\
                    </td>\
				<td><input type='number' min='0' class='form-control number'></td>\
				<td><input type='text' size='2' value=" + createdate + " ></td>\
				<td><select>\
                    <option>Y</option>\
                    <option>N</option>\
                    </select>\
                    </td>\
				<td><input type='text' size='2' value=" + outdate + " ></td>\
                <td>\
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
            var no1 = tr1.find('td:eq(1)').find("select").val();
            var acc1 = tr1.find('td:eq(2)').find("select").val();
            var pwd1 = tr1.find('td:eq(3)').find("input").val();
            var name1 = tr1.find('td:eq(4)').find("input").val();
            var job1 = tr1.find('td:eq(5)').find("select").val();
            var img1 = tr1.find('td:eq(6)').find("input").val();

            $(this).parents('tr').before(`<tr>\
				<td>${key1}</td>\
				<td>${no1}</td>\
				<td>${acc1}</td>\
				<td>${pwd1}</td>\
				<td>${name1}</td>\
				<td>${job1}</td>\
				<td>${img1}</td>\
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
            "ordering": false,
            "processing": false,

            "paging": false,
            "information": false,
            "info": false,
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