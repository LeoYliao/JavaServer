package DbBean;

import java.sql.Date;

public class AseBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int assy_key ;
	private String assy_pcb;
	private String assy_compo;
	private int assy_parts;
	private Date assy_create;
	private String assy_alive;
	private Date assy_out;

	public int getAssy_key() {
		return assy_key;
	}
	public void setAssy_key(int assy_key) {
		this.assy_key = assy_key;
	}
	
	public String getAssy_pcb() {
		return assy_pcb;
	}
	public void setAssy_pcb(String assy_pcb) {
		this.assy_pcb = assy_pcb;
	}
	public String getAssy_compo() {
		return assy_compo;
	}
	public void setAssy_compo(String assy_compo) {
		this.assy_compo = assy_compo;
	}
	public int getAssy_parts() {
		return assy_parts;
	}
	public void setAssy_parts(int assy_parts) {
		this.assy_parts = assy_parts;
	}
	public Date getAssy_create() {
		return assy_create;
	}
	public void setAssy_create(Date assy_create) {
		this.assy_create = assy_create;
	}
	public String getAssy_alive() {
		return assy_alive;
	}
	public void setAssy_alive(String assy_alive) {
		this.assy_alive = assy_alive;
	}
	public Date getAssy_out() {
		return assy_out;
	}
	public void setAssy_out(Date assy_out) {
		this.assy_out = assy_out;
	}
	
}
