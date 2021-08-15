package D;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/MainDelete", initParams=@WebInitParam(name="SQL",value="DELETE FROM aiot2."))
public class MainDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
			switch(dbname) {
			case "pcb":
				pcbDelete(request, response);
				break;
			case "employee":
				empDelete(request, response);
				break;
			case "assy":
				aseDelete(request, response);
				break;
			case "compo":
				comDelete(request, response);
				break;
			case "img":
				imgDelete(request, response);
				break;
			case "result":
				rsDelete(request, response);
				break;
			}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void pcbDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");;		
			Connection conn = datasource.getConnection();
			//get DB name from session
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");	
			//setup SQL cmd
			String SQL = getInitParameter("SQL");
			SQL+=dbname;
			sqlDel(request,SQL,"pcb_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void empDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");;		
			Connection conn = datasource.getConnection();
			//get DB name from session
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");	
			//setup SQL cmd
			String SQL = getInitParameter("SQL");
			SQL+=dbname;
			sqlDel(request,SQL,"emp_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void aseDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");;		
			Connection conn = datasource.getConnection();
			//get DB name from session
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");	
			//setup SQL cmd
			String SQL = getInitParameter("SQL");
			SQL+=dbname;
			sqlDel(request,SQL,"assy_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void comDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");;		
			Connection conn = datasource.getConnection();
			//get DB name from session
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");	
			//setup SQL cmd
			String SQL = getInitParameter("SQL");
			SQL+=dbname;
			sqlDel(request,SQL,"pcb_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void imgDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");;		
			Connection conn = datasource.getConnection();
			//get DB name from session
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");	
			//setup SQL cmd
			String SQL = getInitParameter("SQL");
			SQL+=dbname;
			sqlDel(request,SQL,"img_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void rsDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");;		
			Connection conn = datasource.getConnection();
			//get DB name from session
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");	
			//setup SQL cmd
			String SQL = getInitParameter("SQL");
			SQL+=dbname;
			sqlDel(request,SQL,"r_key");
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(SQL);
			ResultSet rs = pstm.executeQuery();
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void sqlDel(HttpServletRequest request, String SQL ,String pk) throws ServletException, IOException {
		String pk_val=request.getParameter(pk);
		SQL+=" WHERE "+pk+"="+pk_val;
	}
}
