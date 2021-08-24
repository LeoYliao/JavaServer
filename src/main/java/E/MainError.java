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




@WebServlet("/MainError")
public class MainError extends HttpServlet {
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
		List<String> err_loc = new ArrayList<String>();
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
					err_loc.add(data.getR_errloc());
					System.out.println("succeed");	//test
				}else {
					System.out.println("fail");	//test
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String strJson ="{"; 
		//take unique assy_key value
		HashSet<Integer> h = new HashSet(assy_key);
		System.out.println("assy_key value :　"+h);	//test
		for(int i : h) {
			System.out.println("key : "+i);
			strJson+="\""+i+"\":[";
			int cot1=0,cot2=0,cot3=0,cot4=0;
			for(int j=0;j<assy_key.size();j++) {
				//System.out.println("assy_key :　"+assy_key.get(j));
				if(i==assy_key.get(j)) {
					System.out.println("err_loc of key:"+i+" is:"+err_loc.get(j)); 
					switch(err_loc.get(j)) {
					case "1":
						cot1++;
						break;
					case "2":
						cot2++;
						break;
					case "3":
						cot3++;
						break;
					case "4":
						cot4++;
						break;
						}
					}
					}
			strJson+=+cot1+","+cot2+","+cot3+","+cot4+"],";
		}
		strJson=strJson.substring(0,strJson.length()-1);
		strJson+="}";
		System.out.println("data jsonString : "+strJson);
	//Json String check
	//JSONObject obj = new JSONObject(strJson);
	//System.out.println("data of JSONObject : "+obj);
	out.print(strJson);
	}


	private Calendar setTime(Date dataDate) {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
