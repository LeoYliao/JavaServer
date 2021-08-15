package DbBean;

import java.sql.Date;

public class PcbBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int pcb_key;
	private String pcb_no;
	private String pcb_name;
	private Date pcb_create;
	private String pcb_alive;
	private Date pcb_out;
	
	public int getPcb_key() {
		return pcb_key;
	}
	public void setPcb_key(int pcb_key) {
		this.pcb_key = pcb_key;
	}

	public String getPcb_no() {
		return pcb_no;
	}
	public void setPcb_no(String pcb_no) {
		this.pcb_no = pcb_no;
	}
	public String getPcb_name() {
		return pcb_name;
	}
	public void setPcb_name(String pcb_name) {
		this.pcb_name = pcb_name;
	}
	public Date getPcb_create() {
		return pcb_create;
	}
	public void setPcb_create(Date pcb_create) {
		this.pcb_create = pcb_create;
	}
	public String getPcb_alive() {
		return pcb_alive;
	}
	public void setPcb_alive(String pcb_alive) {
		this.pcb_alive = pcb_alive;
	}
	public Date getPcb_out() {
		return pcb_out;
	}
	public void setPcb_out(Date pcb_out) {
		this.pcb_out = pcb_out;
	}
}


