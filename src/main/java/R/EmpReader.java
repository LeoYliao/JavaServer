package R;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import DbBean.EmpBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmpReader")
public class EmpReader extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//set encoding UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//get PrintWriter & session
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//confirm DB name again
		String dbname = (String)session.getAttribute("dbname");
		session.setAttribute("dbname", dbname); 
		System.out.println(dbname+" in emp Reader");	//test/ //!!!!!!
//		//update to lastest datas 待修改
//		request.getRequestDispatcher("/MainReader").include(request, response);
		//import datas from session
		List<EmpBean> datas=(ArrayList<EmpBean>)session.getAttribute("datas");
		//print datas out
		//!!!!!!
		String html="<table id='myDataTalbe' class='display'><thead><tr><th>編號</th><th>員工編號</th><th>帳號</th><th>密碼</th><th>姓名</th><th>職稱</th><th>照片</th><th>權限</th><th>入職日期</th><th>離職日期</th><th></th></tr></thead><tbody>";
		for(EmpBean data:datas){
			html+="<tr>";
			html+="<td>"+data.getEmp_key()+"</td>";
			html+="<td>"+data.getEmp_no()+"</td>";
			html+="<td>"+data.getEmp_acc()+"</td>";
			html+="<td>"+data.getEmp_pwd()+"</td>";
			html+="<td>"+data.getEmp_name()+"</td>";
			html+="<td>"+data.getEmp_job()+"</td>";
			html+="<td>"+data.getEmp_img()+"</td>";
			html+="<td>"+data.getEmp_mgr()+"</td>";
			html+="<td>"+data.getEmp_hired()+"</td>";
			html+="<td>"+data.getEmp_leave()+"</td>";
			//!!!!!!
			html+="<td><button type='button' class='btn btn-warning' id='buttonChg'>修改</button><button type='button' class='btn btn-danger'>刪除</button></td></tr>";
			} 
	html+="</tbody></table>";
	html+="<input class='btn btn-primary' type='button' value='新增' id='buttonAdd'>";
	//html+="<script>$('#buttonAdd').click(function () {$('table').append(\"<tr><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><input type='text' value=''></td><td><a class='btn btn-success'>確定</a><a class='btn btn-danger'>刪除</a></td></tr>);});</script>";
	out.write(html);
		}
	catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
