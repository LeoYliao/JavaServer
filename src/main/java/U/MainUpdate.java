package U;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
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

@WebServlet(urlPatterns="/MainUpdate")
public class MainUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String SQL;
	//SQL = "UPDATE aiot2.";   
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//use session to get DB name
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
		System.out.println(dbname+" in update");	//test
			switch(dbname) {
			case "pcb":
				pcbSetter(request, response);
				break;
			case "employee":
				System.out.println(dbname+" in update switch");	//test
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
			SQL = "UPDATE aiot2.";
			SQL+= dbname+" SET ";
			SQL=sqlSet(request,SQL,"pcb_no")+",";
			SQL=sqlSet(request,SQL,"pcb_name")+",";
			SQL=sqlSet(request,SQL,"pcb_create")+",";
			SQL=sqlSet(request,SQL,"pcb_alive")+",";
			SQL=sqlSet(request,SQL,"pcb_out");
			//set PK (Primary key)
			SQL+="WHERE pcb_key="+request.getParameter("pcb_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			int rs = pstm.executeUpdate();
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
			System.out.println(dbname+" in update emp");	//test
			//set SQL
			//String SQL = getInitParameter("SQL");
			SQL = "UPDATE aiot2.";
			SQL+= dbname+" SET ";
			SQL=sqlSet(request,SQL,"emp_no")+",";
			System.out.println("return of sqlset: "+SQL);	//test
			SQL=sqlSet(request,SQL,"emp_acc")+",";
			SQL=sqlSet(request,SQL,"emp_pwd")+",";
			SQL=sqlSet(request,SQL,"emp_name")+",";
			SQL=sqlSet(request,SQL,"emp_job")+",";
			SQL=sqlSet(request,SQL,"emp_img")+",";
			SQL=sqlSet(request,SQL,"emp_mgr")+",";
			SQL=sqlSet(request,SQL,"emp_hired")+",";
			SQL=sqlSet(request,SQL,"emp_leave");
			//set PK (Primary key)
			SQL+="WHERE emp_key="+request.getParameter("emp_key");
			//excute SQL cmd
			System.out.println("SQL: "+SQL);	//test
			PreparedStatement pstm = conn.prepareStatement(SQL);
			int rs = pstm.executeUpdate();
			System.out.println("how many data been update: "+rs);	//test
			//succeed or fail feedback
			//=============
			Enumeration<String> names=request.getParameterNames();
			String[] values=request.getParameterValues(dbname); 
			while(names.hasMoreElements()) {
				String strName = names.nextElement();
				String strValue = request.getParameter(strName);
				System.out.print("Element name :"+strName);		//test
				System.out.println(" /Element value :"+strValue);	//test
			}
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
			SQL = "UPDATE aiot2.";
			SQL+= dbname+" SET ";
			SQL=sqlSet(request,SQL,"assy_pcb")+",";
			SQL=sqlSet(request,SQL,"assy_compo")+",";
			SQL=sqlSet(request,SQL,"assy_parts")+",";
			SQL=sqlSet(request,SQL,"assy_create")+",";
			SQL=sqlSet(request,SQL,"assy_alive")+",";
			SQL=sqlSet(request,SQL,"assy_out");
			//set PK (Primary key)
			SQL+="WHERE assy_key="+request.getParameter("assy_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			int rs = pstm.executeUpdate();
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
			SQL = "UPDATE aiot2.";
			SQL+= dbname+" SET ";
			SQL=sqlSet(request,SQL,"compo_no")+",";
			SQL=sqlSet(request,SQL,"compo_name")+",";
			SQL=sqlSet(request,SQL,"compo_create")+",";
			SQL=sqlSet(request,SQL,"compo_alive")+",";
			SQL=sqlSet(request,SQL,"compo_out");
			//set PK (Primary key)
			SQL+="WHERE compo_key="+request.getParameter("compo_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			int rs = pstm.executeUpdate();
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
			SQL = "UPDATE aiot2.";
			SQL+= dbname+" SET ";
			SQL=sqlSet(request,SQL,"img_rpi")+",";
			SQL=sqlSet(request,SQL,"img_errloc")+",";
			SQL=sqlSet(request,SQL,"img_seqid")+",";
			SQL=sqlSet(request,SQL,"img_url");
			//set PK (Primary key)
			SQL+="WHERE img_key="+request.getParameter("img_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			int rs = pstm.executeUpdate();
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
			SQL = "UPDATE aiot2.";
			SQL+= dbname+" SET ";
			SQL=sqlSet(request,SQL,"r_seqid")+",";
			SQL=sqlSet(request,SQL,"r_assykey")+",";
			SQL=sqlSet(request,SQL,"r_empno")+",";
			SQL=sqlSet(request,SQL,"r_allqty")+",";
			SQL=sqlSet(request,SQL,"r_errqty")+",";
			SQL=sqlSet(request,SQL,"r_er")+",";
			SQL=sqlSet(request,SQL,"r_errloc")+",";
			SQL=sqlSet(request,SQL,"r_cdate");
			//set PK (Primary key)
			SQL+="WHERE r_key="+request.getParameter("r_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			int rs = pstm.executeUpdate();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
				}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	}
	}
	protected String sqlSet(HttpServletRequest request,String SQL,String attr) throws ServletException, IOException {
		String name=attr;
		String val=request.getParameter(attr);
		SQL+=name+"='"+val+"' ";
		System.out.println("SQL in sqlset: "+SQL);
		return SQL;
	}
}
