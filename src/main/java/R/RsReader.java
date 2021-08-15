package R;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import DbBean.RsBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RsReader")
public class RsReader extends HttpServlet {
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
		List<RsBean> datas=(ArrayList<RsBean>)session.getAttribute("datas");
		//print datas out
		//!!!!!!
		String html="<table id='myDataTalbe' class='display'><thead><tr><th>偵測編號</th><th>組裝編號</th><th>員工編號</th><th>零件總數</th><th>正確數量</th><th>錯誤數量</th><th>錯誤率</th><th>錯誤位置</th><th>掃描結果日期</th></tr></thead><tbody>";
		for(RsBean data:datas){
			html+="<tr>";
			html+="<td>"+data.getR_key()+"</td>";
			html+="<td>"+data.getR_assykey()+"</td>";
			html+="<td>"+data.getR_empno()+"</td>";
			html+="<td>"+data.getR_allqty()+"</td>";
			html+="<td>"+data.getR_okqty()+"</td>";
			html+="<td>"+data.getR_errqty()+"</td>";
			html+="<td>"+data.getR_er()+"</td>";
			html+="<td>"+data.getR_errloc()+"</td>";
			html+="<td>"+data.getR_cdate()+"</td>";
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
