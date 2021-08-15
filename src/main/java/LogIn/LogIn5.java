package LogIn;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/LogIn5")
public class LogIn5 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
		}
	private static final long serialVersionUID = 1L;
	private static final String SQL = "select * from employee where emp_no= ? ";	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String userNo = request.getParameter("userNo"); 
	
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
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
			    out.println("<h1>err! 隢����撣喳��</h1>");
			    System.out.println("ccc");
			}
			//outside user 
			String userAcc= request.getParameter("userAcc");
			String userPwd= request.getParameter("userPwd");
			//db user
			String dbAcc = emp.getEmp_acc();
			String dbPwd = emp.getEmp_pwd();
			
			System.out.println(userAcc);
			System.out.println(userPwd);
			
			if ( userAcc.equals(dbAcc) && userPwd.equals(dbPwd) ) {
	            out.println("<h1>歡迎回來</h1>");
	            //need click function
	            out.println("<a href=\"/JavaServer/html/MainPage.html\">跳轉</a><br>");
	            //not working in ajax
//				request.getRequestDispatcher("/html/MainReader.jsp").forward(request, response);
				out.close();
			} else if ( userAcc.equals(dbAcc)){
            out.println("<h1>密碼錯誤</h1>");	
            } else {
            out.println("<h1>帳號錯誤</h1>");	
			out.close();
			}
//		}finally
//		stmt.close();
//		conn.close();
		}catch(Exception e) {
	    	e.printStackTrace();
	    	}
	}
}
