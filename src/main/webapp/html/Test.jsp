<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="count" value="${sessionScope.count + 1}" scope="session"/>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>refresh</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>
    <p>"有ajax。時間是：??"<span class="times"></span></p>

    <script>
        setInterval(function() {
            Autofresh();
        }, 2000);

        function Autofresh() {
            $.ajax({
                url: '/JavaServer/html/time.jsp',
                type: 'POST',
                //data: ,
                success: function(data) {
                    console.log('Submission was successful.');
                    //console.log(data);
                    //var start = data.indexOf("<times>");
                    //var end = data.indexOf("</times>");
                    //var times = data.substring(start , end);
                    //$(".times").html("");
                    $(".times").html(data);
                },
                error: function(XMLHttpRequest, status, error) {
                    console.log(error)
                }
            })
        }
        Autofresh();
    </script>

</body>

</html>