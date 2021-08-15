package DbBean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RsBean {
private static final long serialVersionUID = 1L;
	
	private int r_key;
	private int r_assykey;
	private String r_empno;
	
	private int r_allqty;
	private int r_okqty;
	private int r_errqty;
	
	private BigDecimal r_er;
	private String r_errloc;
	private Timestamp r_cdate;
	
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
	public BigDecimal getR_er() {
		return r_er;
	}
	public void setR_er(BigDecimal r_er) {
		this.r_er = r_er;
	}
	public String getR_errloc() {
		return r_errloc;
	}
	public void setR_errloc(String r_errloc) {
		this.r_errloc = r_errloc;
	}
	public Timestamp getR_cdate() {
		return r_cdate;
	}
	public void setR_cdate(Timestamp r_cdate) {
		this.r_cdate = r_cdate;
	}
	
}
