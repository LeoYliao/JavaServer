package R;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import DbBean.ComBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ComReader")
public class ComReader extends HttpServlet {
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
		List<ComBean> datas=(ArrayList<ComBean>)session.getAttribute("datas");
		//print datas out
		//!!!!!!
		String html="<table id='myDataTalbe' class='display'><thead><tr><th>編號</th><th>零件編號</th><th>零件名稱</th><th>零件創建日</th><th>使用中是/否</th><th>零件停用日</th></thead><tbody>";
		for(ComBean data:datas){
			html+="<tr>";
			html+="<td>"+data.getCompo_key()+"</td>";
			html+="<td>"+data.getCompo_no()+"</td>";
			html+="<td>"+data.getCompo_name()+"</td>";
			html+="<td>"+data.getCompo_create()+"</td>";
			html+="<td>"+data.getCompo_alive()+"</td>";
			html+="<td>"+data.getCompo_out()+"</td>";
			//!!!!!!
			html+="<td><button type='button' class='btn btn-warning' id='buttonChg'>修改</button><button type='button' class='btn btn-danger'>刪除</button></td></tr>";
			} 
	html+="</tbody></table>";
	html+="<input class='btn btn-primary' type='button' value='新增' id='buttonAdd'>";
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
