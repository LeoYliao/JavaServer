package E;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.*;

import DbBean.RsBean;




@WebServlet("/MainChart")
public class MainChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter out = response.getWriter();
		//set encoding UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//use session to save DB name (need HttpServletRequest request)
			//String dbname = request.getParameter("dbname");
		HttpSession session = request.getSession();
		session.setAttribute("dbname", "result");		//set to result after complete change back to dbname
		System.out.println(session.getAttribute("dbname")+" in MainError");	//test
		//refresh the datas in session
		request.getRequestDispatcher("/MainReader").include(request, response);
		//get datas from session
		SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy/MM/dd");
		Calendar ndate = Calendar.getInstance();
		ndate.set(Calendar.MONTH,ndate.get(Calendar.MONTH)-1);
		//===================test
		System.out.println("now date month-1 : "+ndate.get(Calendar.YEAR)+"/"+ndate.get(Calendar.MONTH)+"/"+ndate.get(Calendar.DAY_OF_MONTH));
		List<RsBean> datas =(ArrayList<RsBean>)session.getAttribute("datas");
		//error count setup
		List<Integer> assy_key = new ArrayList<Integer>();
		List<Integer> err_qty = new ArrayList<Integer>();
		List<String> err_date = new ArrayList<String>();
		try {
		for(RsBean data : datas) {
			
				Date dataDate = dateFormat.parse(data.getR_cdate());
				Calendar cdate = Calendar.getInstance();
				cdate.setTime(dataDate);
				//===================test
				System.out.println("data date : "+cdate.get(Calendar.YEAR)+"/"+cdate.get(Calendar.MONTH)+"/"+cdate.get(Calendar.DAY_OF_MONTH));
				//System.out.println(dataDate);
				if(cdate.after(ndate)) {
					assy_key.add(data.getR_assykey());
					err_qty.add(data.getR_errqty());
					String date=data.getR_cdate();
					date = date.substring(0,10);
					err_date.add(date);
					System.out.println("succeed");	//test
				}else {
					System.out.println("fail");	//test
				}
			}
//		//build up zero Array
//		Calendar now_date = Calendar.getInstance();
//		System.out.println("now_date :"+now_date.getTimeInMillis());
//		System.out.println("ndate : "+ndate.getTimeInMillis());
//		int div_days = (int)((now_date.getTimeInMillis()-ndate.getTimeInMillis())/86400000);
//		System.out.println("div_days :"+div_days);
//		List<Integer> qty_lis = new ArrayList<Integer>();
//		for(int i=0;i<div_days;i++) {
//			qty_lis.add(0);
//		}
//		System.out.println("qty_lis : "+qty_lis.toString());	
			
		//=========================
				
		
		//take unique assy_key & err_date value
		HashSet<String> ds = new HashSet(err_date);
		HashSet<Integer> ks = new HashSet(assy_key);
		System.out.println("err_date value :　"+ds);	//test
		System.out.println("assy_key value :　"+ks);	//test
		//response ArrayList setup===================================
		//Qty & date calculate
		List<Integer> date_err_qty = new ArrayList<Integer>();
		int count=0;
		String strJson ="{";
		
		for (int k:ks) {
			// zero array
			strJson+="\""+k+"\":";
			Calendar now_date = Calendar.getInstance();
			//System.out.println("now_date :"+now_date.getTimeInMillis());
			//System.out.println("ndate : "+ndate.getTimeInMillis());
			int div_days = (int)((now_date.getTimeInMillis()-ndate.getTimeInMillis())/86400000);
			//System.out.println("div_days :"+div_days);
			List<Integer> qty_lis = new ArrayList<Integer>();
			for(int i=0;i<div_days;i++) {
				qty_lis.add(0);
			}
			
			//=======
			List<Integer> err_cot = qty_lis;
			for(int u=0;u<assy_key.size();u++) {
			if(k==assy_key.get(u)){
					String d = err_date.get(u);
					Date err_Date = dateFormat.parse(d);
					Calendar errdate = Calendar.getInstance();
					errdate.setTime(err_Date);
					int date_index = (int)((errdate.getTimeInMillis()-ndate.getTimeInMillis())/86400000);
					System.out.print("assy_key : "+k+" / ndate : "+ndate.getTimeInMillis());
					System.out.print(" / errdate : "+errdate.getTimeInMillis());
					System.out.println(" / date_index : "+date_index);
					int qty_cot=0;
					qty_cot = err_cot.get(date_index)+err_qty.get(u);
					err_cot.set(date_index-1, qty_cot);
					
				}	
			}
			strJson+=err_cot.toString()+",";
			//System.out.println("err_cot : "+err_cot.toString());
		}
		strJson = strJson.substring(0,strJson.length()-1);
		strJson+="}";
		System.out.println("Complete strJson : "+strJson);
		
		//=========================
		
		out.print(strJson);
		
	} catch (Exception e) {
					e.printStackTrace();
				}
			
	//====================================
	//System.out.println("data jsonString : "+strJson);
	//out.print(strJson);
	}


	private Calendar setTime(Date dataDate) {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
