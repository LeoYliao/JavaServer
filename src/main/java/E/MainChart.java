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
		for(RsBean data : datas) {
			try {
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
			
		
		String strJson ="{"; 
		//take unique assy_key & err_date value
		HashSet<String> ds = new HashSet(err_date);
		HashSet<Integer> ks = new HashSet(assy_key);
		System.out.println("err_date value :　"+ds);	//test
		System.out.println("assy_key value :　"+ks);	//test
		//Qty & date calculate
		List<Integer> date_err_qty = new ArrayList<Integer>();
		int count=0;
		for(String d:ds) {
			int err_qty_count=0;
			for(int j=0;j<err_date.size();j++) {
				//System.out.println("err_date in loop : "+err_date.get(j));
				//System.out.println("d in loop : "+d);
					if(d.equals(err_date.get(j))) {
						err_qty_count=err_qty_count+err_qty.get(j);
						//System.out.println("err_qty_count in loop : "+err_qty_count);
						//continue;
					}
					else {
						//System.out.println("fail!~~");
					}
				}
			date_err_qty.add(count, err_qty_count);
			count++;
		}
		System.out.println("date of hashset: "+ds.toString());
		System.out.println("date_err_qty: "+date_err_qty.toString());
		//response ArrayList setup
		//build up zero Array
		Calendar now_date = Calendar.getInstance();
		System.out.println("now_date :"+now_date.getTimeInMillis());
		System.out.println("ndate : "+ndate.getTimeInMillis());
		int div_days = (int)((now_date.getTimeInMillis()-ndate.getTimeInMillis())/86400000);
		System.out.println("div_days :"+div_days);
		List<Integer> qty_lis = new ArrayList<Integer>();
		for(int i=0;i<div_days;i++) {
			qty_lis.add(0);
		}
		System.out.println("qty_lis : "+qty_lis.to);
		for(int i : ks) {
			System.out.println("key : "+i);
			for(int j=0;j<assy_key.size();j++) {
			if(assy_key.get(j)==i) {
				
				}
			}
		}
	} catch (Exception e) {
					e.printStackTrace();
				}
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
