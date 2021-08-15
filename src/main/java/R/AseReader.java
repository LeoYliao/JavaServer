package R;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import DbBean.AseBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AseReader")
public class AseReader extends HttpServlet {
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
		System.out.println(dbname+" in pcb Reader");	//test/ //!!!!!!
//		//update to lastest datas 待修改
//		request.getRequestDispatcher("/MainReader").include(request, response);
		//import datas from session
		List<AseBean> datas=(ArrayList<AseBean>)session.getAttribute("datas");
		//print datas out
		//!!!!!!
		String html="<table id='myDataTalbe' class='display'><thead><tr><th>組裝編號</th><th>電路板編號</th><th>零件編號</th><th>零件總數量</th><th>組裝日</th><th>使用中是/否</th><th>組裝停止日</th></tr></thead><tbody>";
		for(AseBean data:datas){
			html+="<tr>";
			html+="<td>"+data.getAssy_key()+"</td>";
			html+="<td>"+data.getAssy_pcb()+"</td>";
			html+="<td>"+data.getAssy_compo()+"</td>";
			html+="<td>"+data.getAssy_parts()+"</td>";
			html+="<td>"+data.getAssy_create()+"</td>";
			html+="<td>"+data.getAssy_alive()+"</td>";
			html+="<td>"+data.getAssy_out()+"</td>";
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
