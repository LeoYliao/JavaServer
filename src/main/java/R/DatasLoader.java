package R;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import DbBean.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;



@WebServlet("/DatasLoader")
public class DatasLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//set encoding UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//confirm DB name again (use session)
		HttpSession session = request.getSession();
		String dbname = (String)session.getAttribute("dbname");
		System.out.println("dbname in dataLoader : "+dbname);
		//update to lastest datas
		request.getRequestDispatcher("/MainReader").include(request, response);
		//change ArrayList to JSON
		PrintWriter out = response.getWriter();
//		JSONArray jsonDatas = new JSONArray();
//		System.out.println(session.getAttribute("datas").toString());	//test
//		jsonDatas=JSONObject.parseArray(JSONObject.toJSONString(session.getAttribute("datas")));
		//======================
		JSONArray jsonDatas = new JSONArray();
		jsonDatas.add(session.getAttribute("datas"));
		System.out.println("jsonDatas = " + jsonDatas);
		out.write(jsonDatas.toString());
			}
	catch(Exception e) {
	    	e.printStackTrace();
	    	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}

}
