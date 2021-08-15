package LogIn;
import java.io.IOException;
import java.sql.Connection;
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
@WebServlet("/LogInController")
public class LogInController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String SQL = "select * from employee where emp_no= ? ";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String userNo = request.getParameter("userNo"); 
		Connection conn = null;
		
		try {
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		conn = ds.getConnection();

		//session not used?
//		HttpSession session = request.getSession();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		stmt.setString(1,userNo);
		ResultSet rs = stmt.executeQuery();
		System.out.println("aaa");
		System.out.println(rs);
		
		EmpBean emp = new EmpBean();
		if(rs.next()) { 
			emp.setEmp_no(rs.getString("emp_no"));
			emp.setEmp_acc(rs.getString("emp_acc"));
			emp.setEmp_pwd(rs.getString("emp_pwd"));
			System.out.println(rs.getString("emp_no"));
			System.out.println("bbb");
		}else {
			request.getRequestDispatcher("/html/err.html").forward(request, response);
			System.out.println("ccc");
		}
		
		//outside user 
		String userAcc= request.getParameter("userAcc");
		String userPwd= request.getParameter("userPwd");
		//db user
		String dbAcc = emp.getEmp_acc();
		String dbPwd = emp.getEmp_pwd();

		//等號寫法錯誤
//		if ( userAcc==dbAcc && userPwd == dbPwd   ) {
		if ( userAcc.equals(dbAcc) && userPwd.equals(dbPwd)   ) {
			request.getRequestDispatcher("/html/MainModal.jsp").forward(request, response);
			System.out.println(userAcc);
			System.out.println(dbAcc);
		} else {
			request.getRequestDispatcher("/html/err.html").forward(request, response);
			System.out.println("ggg");
		}
		stmt.close();
		conn.close();
		}catch(Exception e) {
	    	e.printStackTrace();
	    	}
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
