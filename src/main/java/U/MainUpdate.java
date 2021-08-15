package U;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.servlet.annotation.*;

import DbBean.AseBean;
import DbBean.ComBean;
import DbBean.EmpBean;
import DbBean.ImgBean;
import DbBean.PcbBean;
import DbBean.RsBean;

@WebServlet(urlPatterns="/MainUpdate",initParams=@WebInitParam(name="SQL" ,value="UPDATE aiot2."))
public class MainUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//use session to get DB name
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
			switch(dbname) {
			case "pcb":
				pcbSetter(request, response);
				break;
			case "employee":
				empSetter(request, response);
				break;
			case "assy":
				aseSetter(request, response);
				break;
			case "compo":
				comSetter(request, response);
				break;
			case "img":
				imgSetter(request, response);
				break;
			case "result":
				rsSetter(request, response);
				break;
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void pcbSetter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			SQL+= dbname+" SET ";
			sqlSet(request,SQL,"pcb_no");
			sqlSet(request,SQL,"pcb_name");
			sqlSet(request,SQL,"pcb_create");
			sqlSet(request,SQL,"pcb_alive");
			sqlSet(request,SQL,"pcb_out");
			//set PK (Primary key)
			SQL+="WHERE pcb_key="+request.getParameter("pcb_key");
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
	protected void empSetter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			SQL+= dbname+" SET ";
			sqlSet(request,SQL,"emp_no");
			sqlSet(request,SQL,"emp_acc");
			sqlSet(request,SQL,"emp_pwd");
			sqlSet(request,SQL,"emp_name");
			sqlSet(request,SQL,"emp_job");
			sqlSet(request,SQL,"emp_img");
			sqlSet(request,SQL,"emp_mgr");
			sqlSet(request,SQL,"emp_hired");
			sqlSet(request,SQL,"emp_leave");
			//set PK (Primary key)
			SQL+="WHERE pcb_key="+request.getParameter("emp_key");
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
	protected void aseSetter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			SQL+= dbname+" SET ";
			sqlSet(request,SQL,"assy_pcb");
			sqlSet(request,SQL,"assy_compo");
			sqlSet(request,SQL,"assy_parts");
			sqlSet(request,SQL,"assy_create");
			sqlSet(request,SQL,"assy_alive");
			sqlSet(request,SQL,"assy_out");
			//set PK (Primary key)
			SQL+="WHERE pcb_key="+request.getParameter("assy_key");
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
	protected void comSetter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			SQL+= dbname+" SET ";
			sqlSet(request,SQL,"compo_no");
			sqlSet(request,SQL,"compo_name");
			sqlSet(request,SQL,"compo_create");
			sqlSet(request,SQL,"compo_alive");
			sqlSet(request,SQL,"compo_out");
			//set PK (Primary key)
			SQL+="WHERE pcb_key="+request.getParameter("compo_key");
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
	protected void imgSetter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			SQL+= dbname+" SET ";
			sqlSet(request,SQL,"img_rpi");
			sqlSet(request,SQL,"img_errloc");
			sqlSet(request,SQL,"img_seqid");
			sqlSet(request,SQL,"img_url");
			//set PK (Primary key)
			SQL+="WHERE pcb_key="+request.getParameter("img_key");
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
	protected void rsSetter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			SQL+= dbname+" SET ";
			sqlSet(request,SQL,"r_seqid");
			sqlSet(request,SQL,"r_assykey");
			sqlSet(request,SQL,"r_empno");
			sqlSet(request,SQL,"r_allqty");
			sqlSet(request,SQL,"r_errqty");
			sqlSet(request,SQL,"r_er");
			sqlSet(request,SQL,"r_errloc");
			sqlSet(request,SQL,"r_cdate");
			//set PK (Primary key)
			SQL+="WHERE pcb_key="+request.getParameter("r_key");
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
	protected void sqlSet(HttpServletRequest request,String SQL,String attr) throws ServletException, IOException {
		String name=attr;
		String val=request.getParameter(attr);
		SQL+=name+"='"+val+"' ";
	}
}
