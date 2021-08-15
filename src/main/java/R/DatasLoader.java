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

import org.json.JSONArray;

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
		//update to lastest datas 待修改
		request.getRequestDispatcher("/MainReader").include(request, response);
		//switch to right table
		switch(dbname) {
		case "pcb":
			pcbLoader(request, response);
			break;
		case "employee":
			empLoader(request, response);
			break;
		case "assy":
			aseLoader(request, response);
			break;
		case "compo":
			comLoader(request, response);
			break;
		case "img":
			imgLoader(request, response);
			break;
		case "result":
			rsLoader(request, response);
			break;
		default:
			response.getWriter().append("no such table");
			}
		}
	catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	protected void pcbLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//import datas us session
				HttpSession session = request.getSession();
				List<EmpBean> datas=(ArrayList<EmpBean>)session.getAttribute("datas");
				//import PrintWriter
				PrintWriter out = response.getWriter();
				//setup data text (list[][])
				String text="";
				for(EmpBean data:datas){
					text+="{"+data.getEmp_key()+",";
					text+=data.getEmp_no()+",";
					text+=data.getEmp_acc()+",";
					text+=data.getEmp_pwd()+",";
					text+=data.getEmp_name()+",";
					text+=data.getEmp_job()+",";
					text+=data.getEmp_img()+",";
					text+=data.getEmp_mgr()+",";
					text+=data.getEmp_hired()+",";
					text+=data.getEmp_leave()+"},";
					}
				text=text.substring(0,text.length()-1);
				//text+="]";
				out.write(text);
		}
	protected void empLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//import datas us session
				HttpSession session = request.getSession();
				List<EmpBean> datas=(ArrayList<EmpBean>)session.getAttribute("datas");
				//import PrintWriter
				PrintWriter out = response.getWriter();
				//setup data text (list[][])
//				String text="{";
//				for(EmpBean data:datas){
//					text+="{\"emp_no\":\""+data.getEmp_key()+"\",";
//					text+="\"emp_no\":\""+data.getEmp_no()+"\",";
//					text+="\"emp_acc\":\""+data.getEmp_acc()+"\",";
//					text+="\"emp_pwd\":\""+data.getEmp_pwd()+"\",";
//					text+="\"emp_name\":\""+data.getEmp_name()+"\",";
//					text+="\"emp_job\":\""+data.getEmp_job()+"\",";
//					text+="\"emp_img\":\""+data.getEmp_img()+"\",";
//					text+="\"emp_mgr\":\""+data.getEmp_mgr()+"\",";
//					text+="\"emp_hired\":\""+data.getEmp_hired()+"\",";
//					text+="\"emp_leave\":\""+data.getEmp_leave()+"\"},";
//					}
//				text=text.substring(0,text.length()-1);
//				text+="}";
//				out.write(text);
				JSONArray jsonDatas = new JSONArray();
				
				//System.out.println(text);
		}
	protected void aseLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//import datas us session
				HttpSession session = request.getSession();
				List<EmpBean> datas=(ArrayList<EmpBean>)session.getAttribute("datas");
				//import PrintWriter
				PrintWriter out = response.getWriter();
				//setup data text (list[][])
				String text="[";
				for(EmpBean data:datas){
					text+="["+data.getEmp_key()+",";
					text+=data.getEmp_no()+",";
					text+=data.getEmp_acc()+",";
					text+=data.getEmp_pwd()+",";
					text+=data.getEmp_name()+",";
					text+=data.getEmp_job()+",";
					text+=data.getEmp_img()+",";
					text+=data.getEmp_mgr()+",";
					text+=data.getEmp_hired()+",";
					text+=data.getEmp_leave()+"],";
					}
				text=text.substring(0,text.length()-1);
				text+="]";
				out.write(text);
		}
	protected void comLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//import datas us session
				HttpSession session = request.getSession();
				List<EmpBean> datas=(ArrayList<EmpBean>)session.getAttribute("datas");
				//import PrintWriter
				PrintWriter out = response.getWriter();
				//setup data text (list[][])
				String text="[";
				for(EmpBean data:datas){
					text+="["+data.getEmp_key()+",";
					text+=data.getEmp_no()+",";
					text+=data.getEmp_acc()+",";
					text+=data.getEmp_pwd()+",";
					text+=data.getEmp_name()+",";
					text+=data.getEmp_job()+",";
					text+=data.getEmp_img()+",";
					text+=data.getEmp_mgr()+",";
					text+=data.getEmp_hired()+",";
					text+=data.getEmp_leave()+"],";
					}
				text=text.substring(0,text.length()-1);
				text+="]";
				out.write(text);
		}
	protected void imgLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//import datas us session
				HttpSession session = request.getSession();
				List<EmpBean> datas=(ArrayList<EmpBean>)session.getAttribute("datas");
				//import PrintWriter
				PrintWriter out = response.getWriter();
				//setup data text (list[][])
				String text="[";
				for(EmpBean data:datas){
					text+="["+data.getEmp_key()+",";
					text+=data.getEmp_no()+",";
					text+=data.getEmp_acc()+",";
					text+=data.getEmp_pwd()+",";
					text+=data.getEmp_name()+",";
					text+=data.getEmp_job()+",";
					text+=data.getEmp_img()+",";
					text+=data.getEmp_mgr()+",";
					text+=data.getEmp_hired()+",";
					text+=data.getEmp_leave()+"],";
					}
				text=text.substring(0,text.length()-1);
				text+="]";
				out.write(text);
		}
	protected void rsLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//import datas us session
				HttpSession session = request.getSession();
				List<EmpBean> datas=(ArrayList<EmpBean>)session.getAttribute("datas");
				//import PrintWriter
				PrintWriter out = response.getWriter();
				//setup data text (list[][])
				String text="[";
				for(EmpBean data:datas){
					text+="["+data.getEmp_key()+",";
					text+=data.getEmp_no()+",";
					text+=data.getEmp_acc()+",";
					text+=data.getEmp_pwd()+",";
					text+=data.getEmp_name()+",";
					text+=data.getEmp_job()+",";
					text+=data.getEmp_img()+",";
					text+=data.getEmp_mgr()+",";
					text+=data.getEmp_hired()+",";
					text+=data.getEmp_leave()+"],";
					}
				text=text.substring(0,text.length()-1);
				text+="]";
				out.write(text);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);}

}
