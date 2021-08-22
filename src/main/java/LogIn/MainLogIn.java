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
@WebServlet("/MainLogIn")
public class MainLogIn extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
		}
	private static final long serialVersionUID = 1L;
	private static final String SQL = "select * from aiot2.employee where emp_acc = ? ";	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Connection conn = null;
		//encoding in UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//get user enter acc/pwd
		String userAcc= request.getParameter("EACC");	
		String userPwd= request.getParameter("EPD");
		//===================================test
		System.out.println("user input acc : "+userAcc);	
		System.out.println("user input pwd : "+userPwd);
		try {
			//create connection from JNDI
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			//setup SQL cmd 
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1,userAcc);
			System.out.println(SQL);	//test
			ResultSet rs = stmt.executeQuery();
			//set PrintWriter 
			PrintWriter out = response.getWriter();
			
			if(rs.next()) {}
			else {
				request.setAttribute("error","帳號錯誤");
				request.getRequestDispatcher("/html/login.jsp").forward(request, response);
			}
		
			//get value of acc/pwd/mgr from DB
			String dbAcc = rs.getString("emp_acc");
			String dbPwd = rs.getString("emp_pwd");
			int dbMgr = rs.getInt("emp_mgr");
			//============================test
			System.out.println("--below acc & pwd from DB--");
			System.out.println("Acc from db : "+dbAcc);
			System.out.println("Pwd from db : "+dbPwd);
			System.out.println("Mgr from db : "+dbMgr);
			//out.print("suceed");
			
			//If input & DB match ,setup session dbname value
			HttpSession session = request.getSession();
			//setup user data to session
			String userName = rs.getString("emp_name");
			String userNo = rs.getString("emp_no");
			String userImg = rs.getString("emp_img");
			session.setAttribute("userName",userName);
			session.setAttribute("userNo",userNo);
			session.setAttribute("userImg",userImg);

			if ( userAcc.equals(dbAcc) && userPwd.equals(dbPwd) ) {
	            if (dbMgr==2){	//系統管理員
	        		session.setAttribute("dbname", "employee"); 
	        		System.out.println(session.getAttribute("dbname")+" in LogRequest");
	        		request.getRequestDispatcher("/html/MainTable.jsp").forward(request, response);
	            } else if (dbMgr==1){	//主管頁面
	        		session.setAttribute("dbname", "result"); 
	        		System.out.println(session.getAttribute("dbname")+" in LogRequest");
	        		request.getRequestDispatcher("/html/ManagerMain.jsp").forward(request, response);
	            }else {
	        		request.setAttribute("error","非主管/系統管理員");
	            	request.getRequestDispatcher("/html/login.jsp").forward(request, response);
	            }
			} else if ( userAcc.equals(dbAcc)){
				request.setAttribute("error","密碼錯誤");
				request.getRequestDispatcher("/html/login.jsp").forward(request, response);
            } 
		//close connection
		stmt.close();
		conn.close();
		}catch(Exception e) {
	    	e.printStackTrace();
	    	}
	}
}
