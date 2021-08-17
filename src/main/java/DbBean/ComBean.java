package DbBean;

import java.sql.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class ComBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@JSONField(ordinal=1)
	private int compo_key;
	@JSONField(ordinal=2)
	private String compo_no;
	@JSONField(ordinal=3)
	private String compo_name;
	@JSONField(ordinal=4)
	private Date compo_create;
	@JSONField(ordinal=5)
	private String compo_alive;
	@JSONField(ordinal=6)
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
