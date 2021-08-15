package R;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

@WebServlet(urlPatterns="/MainReader" ,initParams=@WebInitParam(name="SQL" ,value="SELECT * FROM aiot2."))
public class MainReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	String SQL="SELECT * FROM aiot2.";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set encoding UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//use session to get DB name
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
		System.out.println(dbname +" in Reader");	//test
			switch(dbname) {
			case "pcb":
				pcbReader(request, response);
				break;
			case "employee":
				System.out.println(dbname +" in switch");	//test
				empReader(request, response);
				break;
			case "assy":
				aseReader(request, response);
				break;
			case "compo":
				comReader(request, response);
				break;
			case "img":
				imgReader(request, response);
				break;
			case "result":
				rsReader(request, response);
				break;
			default:
				request.getRequestDispatcher("/html/MainReader.jsp").forward(request, response);
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}
	protected void pcbReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {   
		//connection 
		Context context = new InitialContext();
		DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		Connection conn = datasource.getConnection();
		//get data from DB
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
		String SQL = getInitParameter("SQL");
		SQL+=dbname;
		PreparedStatement pstm = conn.prepareStatement(SQL);
		ResultSet rs = pstm.executeQuery();
		//use bean to catch data 
		List<PcbBean> datas =new ArrayList<>();
		while(rs.next()) {
			PcbBean data = new PcbBean();
			data.setPcb_key(rs.getInt("pcb_key"));
			data.setPcb_no(rs.getString("pcb_no"));
			data.setPcb_name(rs.getString("pcb_name"));
			data.setPcb_create(rs.getDate("pcb_create"));
			data.setPcb_alive(rs.getString("Pcb_alive"));
			data.setPcb_out(rs.getDate("pcb_out"));
			datas.add(data);
			}
		//save data to session
		session.setAttribute("datas",datas);
		//connection close
		pstm.close();
		conn.close();
			}
	    catch(Exception e) {
	    	e.printStackTrace();
	    	}
	}
	protected void empReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try { 
		//connection 
		Context context = new InitialContext();
		DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		Connection conn = datasource.getConnection();
		//get data from DB
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
		String SQL = getInitParameter("SQL");
		System.out.println(dbname +" in empReader");	//test
		SQL+=dbname;
		PreparedStatement pstm = conn.prepareStatement(SQL);
		ResultSet rs = pstm.executeQuery();
		//use bean to catch data 
		List<EmpBean> datas =new ArrayList<>();
		while(rs.next()) {
			EmpBean data = new EmpBean(); 
			data.setEmp_key(rs.getInt("emp_key"));
			data.setEmp_no(rs.getString("emp_no"));
			data.setEmp_acc(rs.getString("emp_acc"));
			data.setEmp_pwd(rs.getString("emp_pwd"));
			data.setEmp_name(rs.getString("emp_name"));
			data.setEmp_job(rs.getString("emp_job"));
			data.setEmp_img(rs.getString("emp_img"));
			data.setEmp_mgr(rs.getInt("emp_mgr"));
			data.setEmp_hired(rs.getDate("emp_hired"));
			data.setEmp_leave(rs.getDate("emp_leave"));
			datas.add(data);
				}
		//save data to session
		session.setAttribute("datas",datas);
		//connection close
		pstm.close();
		conn.close();
			}
	    catch(Exception e) {
	    	e.printStackTrace();
	    	}
		}
	protected void aseReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {   
		//connection 
		Context context = new InitialContext();
		DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		Connection conn = datasource.getConnection();
		//get data from DB
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
		String SQL = getInitParameter("SQL");
		SQL+=dbname;
		PreparedStatement pstm = conn.prepareStatement(SQL);
		ResultSet rs = pstm.executeQuery();
		//use bean to catch data 
		List<AseBean> datas =new ArrayList<>();
		while(rs.next()) {
			AseBean data = new AseBean(); 
			data.setAssy_key(rs.getInt("assy_key"));
			data.setAssy_pcb(rs.getString("assy_pcb"));
			data.setAssy_compo(rs.getString("assy_compo"));
			data.setAssy_parts(rs.getInt("assy_parts"));
			data.setAssy_create(rs.getDate("assy_create"));
			data.setAssy_alive(rs.getString("assy_alive"));
			data.setAssy_out(rs.getDate("assy_out"));
			datas.add(data);
				}
		//save data to session
		session.setAttribute("datas",datas);
		//connection close
		pstm.close();
		conn.close();
			}
	    catch(Exception e) {
	    	e.printStackTrace();
	    	}
		}
	protected void comReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {   
		//connection 
		Context context = new InitialContext();
		DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		Connection conn = datasource.getConnection();
		//get data from DB
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
		String SQL = getInitParameter("SQL");
		SQL+=dbname;
		PreparedStatement pstm = conn.prepareStatement(SQL);
		ResultSet rs = pstm.executeQuery();
		//use bean to catch data 
		List<ComBean> datas =new ArrayList<>();
		while(rs.next()) {
			ComBean data = new ComBean(); 
			data.setCompo_key(rs.getInt("compo_key"));
			data.setCompo_no(rs.getString("compo_no"));
			data.setCompo_name(rs.getString("compo_name"));
			data.setCompo_create(rs.getDate("compo_create"));
			data.setCompo_alive(rs.getString("compo_alive"));
			data.setCompo_out(rs.getDate("compo_out"));
			datas.add(data);
				}
		//save data to session
		session.setAttribute("datas",datas);
		//connection close
		pstm.close();
		conn.close();
			}
	    catch(Exception e) {
	    	e.printStackTrace();
	    	}
		}
	protected void imgReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {   
		//connection 
		Context context = new InitialContext();
		DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		Connection conn = datasource.getConnection();
		//get data from DB
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
		String SQL = getInitParameter("SQL");
		SQL+=dbname;
		PreparedStatement pstm = conn.prepareStatement(SQL);
		ResultSet rs = pstm.executeQuery();
		//use bean to catch data 
		List<ImgBean> datas =new ArrayList<>();
		while(rs.next()) {
			ImgBean data = new ImgBean(); 
			data.setImg_key(rs.getInt("img_key"));
			data.setImg_rpi(rs.getString("img_rpi"));
			data.setImg_errloc(rs.getString("img_errloc"));
			data.setR_assykey(rs.getInt("r_assykey"));
			data.setImg_seqid(rs.getDate("img_seqid"));
			data.setImg_url(rs.getString("img_url"));
			datas.add(data);
				}
		//save data to session
		session.setAttribute("datas",datas);
		//connection close
		pstm.close();
		conn.close();
			}
	    catch(Exception e) {
	    	e.printStackTrace();
	    	}
		}
	protected void rsReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {   
		//connection 
		Context context = new InitialContext();
		DataSource datasource = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		Connection conn = datasource.getConnection();
		//get data from DB
		HttpSession session = request.getSession();
		String dbname=(String)session.getAttribute("dbname");
		String SQL = getInitParameter("SQL");
		SQL+=dbname;
		PreparedStatement pstm = conn.prepareStatement(SQL);
		ResultSet rs = pstm.executeQuery();
		//use bean to catch data 
		List<RsBean> datas =new ArrayList<>();
		while(rs.next()) {
			RsBean data = new RsBean(); 
			data.setR_key(rs.getInt("r_key"));
			data.setR_assykey(rs.getInt("r_assykey"));
			data.setR_empno(rs.getString("r_empno"));
			data.setR_allqty(rs.getInt("r_allqty"));
			data.setR_okqty(rs.getInt("r_okqty"));
			data.setR_errqty(rs.getInt("r_errqty"));
			data.setR_er(rs.getBigDecimal("r_er"));
			data.setR_errloc(rs.getString("r_errloc"));
			data.setR_cdate(rs.getTimestamp("r_cdate"));
			datas.add(data);
				}
		//save data to session
		session.setAttribute("datas",datas);
		//connection close
		pstm.close();
		conn.close();
			}
	    catch(Exception e) {
	    	e.printStackTrace();
	    	}
		}
    
}