package C;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.naming.Context; 
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DbBean.EmpBean;
@WebServlet("/New")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL = "INSERT INTO employee (emp_key,emp_no,emp_acc,emp_pwd,emp_name,emp_job,emp_img,emp_mgr) VALUES (?,?,?,?,?,?,?,?)"; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		Connection conn = null;
//		System.out.println("kkk"); //debug
		try {
			Context context = new InitialContext(); 
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			EmpBean emp = new EmpBean();
			
//			emp.setEmp_key(Integer.parseInt(request.getParameter("emp_key"))); //解決null
			if(!(request.getParameter("emp_key")==null||"".equals(request.getParameter("emp_key"))))
				{emp.setEmp_key(Integer.parseInt((String)request.getParameter("emp_key")));}
			emp.setEmp_no((String)(request.getParameter("emp_no")));
			emp.setEmp_acc((String)(request.getParameter("emp_acc")));
			emp.setEmp_pwd((String)(request.getParameter("emp_pwd")));
			emp.setEmp_name((String)(request.getParameter("emp_name")));
			emp.setEmp_job((String)(request.getParameter("emp_job")));
			emp.setEmp_img((String)(request.getParameter("emp_img")));
//			emp.setEmp_mgr(Integer.parseInt(request.getParameter("emp_mgr")));
			if(!(request.getParameter("emp_mgr")==null||"".equals(request.getParameter("emp_mgr"))))
			{emp.setEmp_mgr(Integer.parseInt((String)request.getParameter("emp_mgr")));}
//			逃避日期是美好的
//			emp.setEmp_hired(Date.valueOf(request.getParameter("emp_hired")));
//			java.util.Date emp_hired = new Date(0);
//			String eDate = request.getParameter("emp_hired");
//			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//			emp_hired = dateFormat.parse(eDate);
////			emp.setEmp_leave(Date.valueOf(request.getParameter("emp_leave")));
//			java.util.Date emp_leave = new Date(0);
//			String oDate = request.getParameter("emp_leave");
//			DateFormat dateFormatout = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//			emp_leave = dateFormatout.parse(oDate);
			
//		System.out.println("aaa");//debug
		
			PreparedStatement stmt = conn.prepareStatement(SQL);
	        stmt.setInt(1,emp.getEmp_key());
			stmt.setString(2,emp.getEmp_no());
	        stmt.setString(3,emp.getEmp_acc());
	        stmt.setString(4,emp.getEmp_pwd());
	        stmt.setString(5,emp.getEmp_name());
	        stmt.setString(6,emp.getEmp_job());
	        stmt.setString(7,emp.getEmp_img());
	        stmt.setInt(8,emp.getEmp_mgr());
//	        逃避日期是美好的
//	        stmt.setDate(9,emp.getEmp_hired());
//	        stmt.setDate(10,emp.getEmp_leave());
	        
	    System.out.println(stmt);//debug
//	    System.out.println("oooooo");//debug
		System.out.println(emp.getEmp_no());//debug
		System.out.println(emp.getEmp_name());//debug
		System.out.println(emp.getEmp_hired());
		
			boolean rowData = stmt.executeUpdate() >0;
		System.out.println(rowData);//debug
	    System.out.println("bbb");//debug
			if(rowData) {
				request.setAttribute("empAdd", emp);
				request.getRequestDispatcher("/html/ok.html").forward(request, response);
			}else {
				request.getRequestDispatcher("/html/err.html").forward(request, response);
			}
		}catch(Exception e) { 
			e.printStackTrace();
			request.getRequestDispatcher("/html/err.html").forward(request, response);
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
				doGet(request, response); 
	}
}