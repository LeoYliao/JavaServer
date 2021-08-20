package DbBean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class RsBean {
private static final long serialVersionUID = 1L;
	@JSONField(ordinal=1)
	private int r_key;
	@JSONField(ordinal=2)
	private int r_assykey;
	@JSONField(ordinal=3)
	private String r_empno;
	
	@JSONField(ordinal=4)
	private int r_allqty;
	@JSONField(ordinal=5)
	private int r_okqty;
	@JSONField(ordinal=6)
	private int r_errqty;
	
	@JSONField(ordinal=7)
	private String r_errloc;
	@JSONField(ordinal=8)
	private BigDecimal r_dtime;
	@JSONField(ordinal=9)
	private String r_cdate;
	
	public int getR_key() {
		return r_key;
	}
	public void setR_key(int r_key) {
		this.r_key = r_key;
	}
	public int getR_assykey() {
		return r_assykey;
	}
	public void setR_assykey(int r_assykey) {
		this.r_assykey = r_assykey;
	}
	public String getR_empno() {
		return r_empno;
	}
	public void setR_empno(String r_empno) {
		this.r_empno = r_empno;
	}
	public int getR_allqty() {
		return r_allqty;
	}
	public void setR_allqty(int r_allqty) {
		this.r_allqty = r_allqty;
	}
	public int getR_okqty() {
		return r_okqty;
	}
	public void setR_okqty(int r_okqty) {
		this.r_okqty = r_okqty;
	}
	public int getR_errqty() {
		return r_errqty;
	}
	public void setR_errqty(int r_errqty) {
		this.r_errqty = r_errqty;
	}
	public String getR_errloc() {
		return r_errloc;
	}
	public void setR_errloc(String r_errloc) {
		this.r_errloc = r_errloc;
	}
	public BigDecimal getR_dtime() {
		return r_dtime;
	}
	public void setR_dtime(BigDecimal r_dtime) {
		this.r_dtime = r_dtime;
	}
	public String getR_cdate() {
		return r_cdate;
	}
	public void setR_cdate(Timestamp r_cdate) {
		String strTimestamp = r_cdate.toString();
		this.r_cdate = strTimestamp.substring(0,strTimestamp.length()-2);
	}
	
}
