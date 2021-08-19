//被消失的log7
package LogIn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import DbBean.EmpBean;
@WebServlet("/LogIn7")
public class LogIn7 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
		}
	private static final long serialVersionUID = 1L;
	private static final String SQL = "select * from aiot2.employee where emp_acc = ? ";	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userAcc= request.getParameter("EACC");
		System.out.println(userAcc);
	
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
//			===========================================================================
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1,userAcc);
			ResultSet rs = stmt.executeQuery();
			
			System.out.println("aaa");
			System.out.println(rs);
			
			EmpBean emp = new EmpBean();
			if(rs.next()) { 
				emp.setEmp_acc(rs.getString("emp_acc"));
				emp.setEmp_pwd(rs.getString("emp_pwd"));
				emp.setEmp_mgr(rs.getInt("emp_mgr"));
				
				System.out.println("bbb");
				System.out.println(rs.getString("emp_acc"));
				System.out.println(rs.getInt("emp_mgr"));
			}else {
			    System.out.println("ccc");
			}
			
			String userPwd= request.getParameter("EPD");
//			int userMgr= Integer.parseInt(request.getParameter("MGR").toString());
			String dbAcc = emp.getEmp_acc();
			String dbPwd = emp.getEmp_pwd();
			int dbMgr = emp.getEmp_mgr();
			
			System.out.println(userAcc);
			System.out.println(dbMgr);
			
			if ( userAcc.equals(dbAcc) && userPwd.equals(dbPwd) ) {
	            if (dbMgr==2){
	        		HttpSession session = request.getSession();
	        		session.setAttribute("dbname", "employee"); 
	        		System.out.println(session.getAttribute("dbname")+" in LogRequest");
	        		request.getRequestDispatcher("/html/MainTable.jsp").forward(request, response);
	            } else if (dbMgr==1){
	        		HttpSession session = request.getSession();
	        		session.setAttribute("dbname", "result"); 
	        		System.out.println(session.getAttribute("dbname")+" in LogRequest");
	        		request.getRequestDispatcher("/html/ManagerMain.jsp").forward(request, response);
	            }else {
	        		request.getRequestDispatcher("/html/login.jsp").forward(request, response);
	        		System.out.println("<h1>非主管/系統管理員</h1>");
	            }
			} else if ( userAcc.equals(dbAcc)){
        		request.getRequestDispatcher("/html/login.jsp").forward(request, response);
        		System.out.println("<h1>密碼錯誤</h1>");
            } else if ( userPwd.equals(dbPwd)){
        		request.getRequestDispatcher("/html/login.jsp").forward(request, response);
        		System.out.println("<h1>帳號錯誤</h1>");	
			}
//		}finally
		stmt.close();
		conn.close();
		}catch(Exception e) {
	    	e.printStackTrace();
	    	}
	}
}
