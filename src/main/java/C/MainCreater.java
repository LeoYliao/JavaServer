package C;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/MainCreater" ,initParams=@WebInitParam(name="SQL" ,value="INSERT aiot2."))
public class MainCreater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//use session to get DB name
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
			switch(dbname) {
			case "pcb":
				pcbCreater(request, response);
				break;
			case "employee":
				empCreater(request, response);
				break;
			case "assy":
				aseCreater(request, response);
				break;
			case "compo":
				comCreater(request, response);
				break;
			case "img":
				imgCreater(request, response);
				break;
			case "result":
				rsCreater(request, response);
				break;
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void pcbCreater(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {   
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = datasource.getConnection();
			//use session to get DB name (DB name)
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");
			//set SQL
			String SQL = getInitParameter("SQL");
			SQL+= dbname+" VALUES(0,";
			//set attribute --------------------------------------
			sqlCreater(request,SQL,"pcb_no");
			SQL+=",";
			sqlCreater(request,SQL,"pcb_name");
			SQL+=",";
			sqlCreater(request,SQL,"pcb_create");
			SQL+=",";
			sqlCreater(request,SQL,"pcb_alive");
			SQL+=",";
			sqlCreater(request,SQL,"pcb_out");
			SQL+=")";
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
				}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	}
	}
	protected void empCreater(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {   
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = datasource.getConnection();
			//use session to get DB name (DB name)
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");
			//set SQL
			String SQL = getInitParameter("SQL");
			SQL+= dbname+" VALUES(0,";
			//set attribute --------------------------------------
			sqlCreater(request,SQL,"emp_no");
			SQL+=",";
			sqlCreater(request,SQL,"emp_acc");
			SQL+=",";
			sqlCreater(request,SQL,"emp_pwd");
			SQL+=",";
			sqlCreater(request,SQL,"emp_name");
			SQL+=",";
			sqlCreater(request,SQL,"emp_job");
			SQL+=",";
			sqlCreater(request,SQL,"emp_img");
			SQL+=",";
			sqlCreater(request,SQL,"emp_mgr");
			SQL+=",";
			sqlCreater(request,SQL,"emp_hired");
			SQL+=",";
			sqlCreater(request,SQL,"emp_leave");
			SQL+=")";
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
				}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	}
	}
	protected void aseCreater(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {   
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = datasource.getConnection();
			//use session to get DB name (DB name)
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");
			//set SQL
			String SQL = getInitParameter("SQL");
			SQL+= dbname+" VALUES(0,";
			//set attribute --------------------------------------
			sqlCreater(request,SQL,"assy_pcb");
			SQL+=",";
			sqlCreater(request,SQL,"assy_compo");
			SQL+=",";
			sqlCreater(request,SQL,"assy_parts");
			SQL+=",";
			sqlCreater(request,SQL,"assy_create");
			SQL+=",";
			sqlCreater(request,SQL,"assy_alive");
			SQL+=",";
			sqlCreater(request,SQL,"assy_out");
			SQL+=")";
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
				}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	}
	}
	protected void comCreater(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {   
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = datasource.getConnection();
			//use session to get DB name (DB name)
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");
			//set SQL
			String SQL = getInitParameter("SQL");
			SQL+= dbname+" VALUES(0,";
			//set attribute --------------------------------------
			sqlCreater(request,SQL,"compo_no");
			SQL+=",";
			sqlCreater(request,SQL,"compo_name");
			SQL+=",";
			sqlCreater(request,SQL,"compo_create");
			SQL+=",";
			sqlCreater(request,SQL,"compo_alive");
			SQL+=",";
			sqlCreater(request,SQL,"compo_out");
			SQL+=")";
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
				}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	}
	}
	protected void imgCreater(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {   
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = datasource.getConnection();
			//use session to get DB name (DB name)
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");
			//set SQL
			String SQL = getInitParameter("SQL");
			SQL+= dbname+" VALUES(0,";
			//set attribute --------------------------------------
			sqlCreater(request,SQL,"img_rpi");
			SQL+=",";
			sqlCreater(request,SQL,"img_errloc");
			SQL+=",";
			sqlCreater(request,SQL,"img_seqid");
			SQL+=",";
			sqlCreater(request,SQL,"img_url");
			SQL+=")";
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
				}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	}
	}
	protected void rsCreater(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {   
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = datasource.getConnection();
			//use session to get DB name (DB name)
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");
			//set SQL
			String SQL = getInitParameter("SQL");
			SQL+= dbname+" VALUES(0,";
			//set attribute --------------------------------------
			sqlCreater(request,SQL,"r_seqid");
			SQL+=",";
			sqlCreater(request,SQL,"r_assykey");
			SQL+=",";
			sqlCreater(request,SQL,"r_empno");
			SQL+=",";
			sqlCreater(request,SQL,"r_allqty");
			SQL+=",";
			sqlCreater(request,SQL,"r_errqty");
			SQL+=",";
			sqlCreater(request,SQL,"r_er");
			SQL+=",";
			sqlCreater(request,SQL,"r_errloc");
			SQL+=",";
			sqlCreater(request,SQL,"r_cdate");
			SQL+=")";
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
				}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	}
	}
	protected void sqlCreater(HttpServletRequest request, String SQL ,String attr) throws ServletException, IOException {
		String attr_val = request.getParameter(attr);
		SQL+=attr_val;
	}
}
