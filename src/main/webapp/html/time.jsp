<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<
<%
	String html="";
	for(int i=0;i<3;i++){
      Date dNow = new Date( );
      SimpleDateFormat fd = new SimpleDateFormat ("yyyy-MM-dd");
      SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");
      String date = fd.format(dNow);
      String time = ft.format(dNow);
      html+="<h1 class='outtimer'>"+date+" "+time+"</h1>";
     }
     out.write(html);
     %> 
 

<h2><% out.print("hello");%></h2>
<script>
$('.outtimer').click(function(){
	console.log('be clicked');
})
</script>