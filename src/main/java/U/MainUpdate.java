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
		//encoding by UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
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
			//=============
			String strName="";
			String strValue="";
			Enumeration<String> names=request.getParameterNames();
			//String[] values=request.getParameterValues(dbname); 
			while(names.hasMoreElements()) {
				 String name= names.nextElement();
				 strName+=name+",";
				 String value= request.getParameter(name);
				 strValue+="\'"+value+"\',";
				 System.out.println("Element name :"+name);		//test
				 System.out.println(" /Element value :"+value);	//test
				}
			strName = strName.substring(0, strName.length()-1);
			strValue = strValue.substring(0, strValue.length()-1);
			System.out.println("name list : "+strName);		//test
			System.out.println("value list : "+strValue);	//test
			String rSQL = "REPLACE aiot2."+dbname+"("+strName+") VALUES("+strValue+");";
			//===============
			//excute SQL cmd
			System.out.println("SQL: "+rSQL);	//test
			PreparedStatement pstm = conn.prepareStatement(rSQL);
			int rs = pstm.executeUpdate();
			System.out.println("how many data been replace: "+rs);	//test
			//succeed or fail feedback
			
			//connection close
			pstm.close();
			conn.close();
				}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
