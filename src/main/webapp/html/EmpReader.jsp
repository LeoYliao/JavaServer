<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="DbBean.EmpBean,java.util.*,java.text.*"%>


	
	<%List<EmpBean> datas=(ArrayList<EmpBean>)request.getAttribute("datas");
		String html="<table border='1'>hello";
		html+=(int)datas.size();
	//	for(int i = 0; i < datas.size(); i++){
	//		html+="<tr>";
	//		html+="<td>start</td>";
	//		html+="<td>"+data.getEmp_no()+"</td>";
	//		html+="<td>"+data.getEmp_acc()+"</td>";
	//		html+="<td>"+data.getEmp_pwd()+"</td>";
	//		html+="<td>"+data.getEmp_name()+"</td>";
	//		html+="<td>"+data.getEmp_job()+"</td>";
	//		html+="<td>"+data.getEmp_img()+"</td>";
	//		html+="<td>"+data.getEmp_mgr()+"</td>";
	//		html+="<td>"+data.getEmp_hired()+"</td>";
	//		html+="<td>"+data.getEmp_leave()+"</td>";
	//		html+="</tr>";
	//	} 
	html+="</table>";
	out.write(html);
	%>

<h1 style="text-align:center;"><%session.getAttribute("dbname"); %>共<%--out.print(datas.size()); --%>筆資料</h1>
