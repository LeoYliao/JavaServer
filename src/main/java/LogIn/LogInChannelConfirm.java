package LogIn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogInChannelConfirm")
public class LogInChannelConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String dbname = (String) session.getAttribute("dbname");
		session.setAttribute("dbname", dbname); 
		System.out.println(session.getAttribute("dbname")+" in confirm");
		//未解決:刷新頁包含login問題
		request.getRequestDispatcher("/MainReader").include(request, response);
		request.getRequestDispatcher("/html/MainTable.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
