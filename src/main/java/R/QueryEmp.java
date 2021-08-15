package R;
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

import DbBean.AseBean;
import DbBean.ComBean;
import DbBean.EmpBean;
import DbBean.ImgBean;
import DbBean.PcbBean;
import DbBean.RsBean;

@WebServlet("/QueryEmp")
public class QueryEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL = "select * from employee where emp_no= ? ";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		Connection conn = null;
		int emp_key = Integer.parseInt(request.getParameter("emp_key"));  
		System.out.println(emp_key); //debug
		System.out.println("kkk"); //debug
		try {
		//connection 	
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		conn = ds.getConnection();
		//SQL to DB
		PreparedStatement stmt = conn.prepareStatement(SQL);
		stmt.setInt(1,emp_key);
		ResultSet rs = stmt.executeQuery();
		//bean rs.next
		EmpBean emp = new EmpBean(); 
		if(rs.next()) {
//			emp.setEmp_key(rs.getInt("emp_key"));
			if((request.getParameter("emp_key")==null||"".equals(request.getParameter("emp_key"))))
			{emp.setEmp_key(Integer.parseInt((String)request.getParameter("emp_key")));}
			emp.setEmp_no(rs.getString("emp_no"));
			emp.setEmp_acc(rs.getString("emp_acc"));
			emp.setEmp_pwd(rs.getString("emp_pwd"));
			emp.setEmp_name(rs.getString("emp_name"));
			emp.setEmp_job(rs.getString("emp_job"));
			emp.setEmp_img(rs.getString("emp_img"));
//			emp.setEmp_mgr(rs.getInt("emp_mgr"));
//			if((request.getParameter("emp_mgr")==null||"".equals(request.getParameter("emp_mgr"))))
//			{emp.setEmp_mgr(Integer.parseInt((String)request.getParameter("emp_mgr")));}
			emp.setEmp_hired(rs.getDate("emp_hired"));
			emp.setEmp_leave(rs.getDate("emp_leave"));
		}//dispatch data
		System.out.println("aaa"); //debug
		System.out.println(emp_key); //debug
		System.out.println(rs.getString("emp_job")); //debug
		System.out.println(emp.getEmp_mgr());
		
		request.setAttribute("emp", emp);
		stmt.close();    
		request.getRequestDispatcher("/html/Query.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (conn != null)
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
		}
 	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response); }
}