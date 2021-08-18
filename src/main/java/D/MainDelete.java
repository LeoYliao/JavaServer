package D;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

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
		//Encoding by UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {	
			//connection 
			Context context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");;		
			Connection conn = datasource.getConnection();
			//get DB name from session
			HttpSession session = request.getSession();
			String dbname=(String)session.getAttribute("dbname");	
			System.out.println("dbnmae in delete:empDelete : "+dbname);	//test
			//===========
			Enumeration<String> names=request.getParameterNames();
			String name = names.nextElement();
			String value = request.getParameter(name);
			System.out.println("name = "+name+" / "+"value = "+value);	//test
			String dSQL ;
			dSQL = "DELETE FROM aiot2."+dbname+" WHERE "+name+"="+value;
			System.out.println("dSQL : "+dSQL);	//test
			//excute SQL cmd
			PreparedStatement pstm = conn.prepareStatement(dSQL);
			int rs = pstm.executeUpdate();
			System.out.println("Delete : "+rs+" item(s)");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
