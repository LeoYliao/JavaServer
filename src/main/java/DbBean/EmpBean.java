package DbBean;

import java.sql.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class EmpBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@JSONField(ordinal=1)
	private int emp_key;
	@JSONField(ordinal=2)
	private String emp_no;
	@JSONField(ordinal=3)
	private String emp_acc;
	@JSONField(ordinal=4)
	private String emp_pwd;
	@JSONField(ordinal=5)
	private String emp_name;
	@JSONField(ordinal=6)
	private String emp_job;
	@JSONField(ordinal=7)
	private String emp_img;
	@JSONField(ordinal=8)
	private int emp_mgr;
	@JSONField(ordinal=9)
	private Date emp_hired;
	@JSONField(ordinal=10)
	private Date emp_leave;
	
	public int getEmp_key() {
		return emp_key;
	}
	public void setEmp_key(int emp_key) {
		this.emp_key = emp_key;
	}
	
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_acc() {
		return emp_acc;
	}
	public void setEmp_acc(String emp_acc) {
		this.emp_acc = emp_acc;
	}
	public String getEmp_pwd() {
		return emp_pwd;
	}
	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_job() {
		return emp_job;
	}
	public void setEmp_job(String emp_job) {
		this.emp_job = emp_job;
	}
	public String getEmp_img() {
		return emp_img;
	}
	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
	}
	public int getEmp_mgr() {
		return emp_mgr;
	}
	public void setEmp_mgr(int emp_mgr) {
		this.emp_mgr = emp_mgr;
	}
	public Date getEmp_hired() {
		return emp_hired;
	}
	public void setEmp_hired(Date emp_hired) {
		this.emp_hired = emp_hired;
	}
	public Date getEmp_leave() {
		return emp_leave;
	}
	public void setEmp_leave(Date emp_leave) {
		this.emp_leave = emp_leave;
	}
	
	
}
