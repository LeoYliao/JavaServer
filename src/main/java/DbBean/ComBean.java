package DbBean;

import java.sql.Date;

public class ComBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int compo_key;
	private String compo_no;
	private String compo_name;
	private Date compo_create;
	private String compo_alive;
	private Date compo_out;
	
	public int getCompo_key() {
		return compo_key;
	}
	public void setCompo_key(int compo_key) {
		this.compo_key = compo_key;
	}
	
	public String getCompo_no() {
		return compo_no;
	}
	public void setCompo_no(String compo_no) {
		this.compo_no = compo_no;
	}
	public String getCompo_name() {
		return compo_name;
	}
	public void setCompo_name(String compo_name) {
		this.compo_name = compo_name;
	}
	public Date getCompo_create() {
		return compo_create;
	}
	public void setCompo_create(Date compo_create) {
		this.compo_create = compo_create;
	}
	public String getCompo_alive() {
		return compo_alive;
	}
	public void setCompo_alive(String compo_alive) {
		this.compo_alive = compo_alive;
	}
	public Date getCompo_out() {
		return compo_out;
	}
	public void setCompo_out(Date compo_out) {
		this.compo_out = compo_out;
	}
	
	
}
