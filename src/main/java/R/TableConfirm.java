package R;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/TableConfirm")
public class TableConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set encoding UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//use session to save DB name (need HttpServletRequest request)
		String dbname = request.getParameter("dbname");
		HttpSession session = request.getSession();
		session.setAttribute("dbname", dbname); 
		System.out.println(session.getAttribute("dbname")+" in TableConfirm");	//test
		//import datas from MainReader
		//request.getRequestDispatcher("/MainReader").include(request, response);
		//redirect to html/MainReader.jsp
		//request.getRequestDispatcher("/html/ManagerTable.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
