package DbBean;

import java.sql.Date;

public class ImgBean {
private static final long serialVersionUID = 1L;
	
	private int img_key;
	private String img_rpi;
	private String img_errloc;
	private int r_assykey;
	private Date img_seqid;
	private String img_url;
	
	public int getImg_key() {
		return img_key;
	}
	public void setImg_key(int img_key) {
		this.img_key = img_key;
	}
	public String getImg_rpi() {
		return img_rpi;
	}
	public void setImg_rpi(String img_rpi) {
		this.img_rpi = img_rpi;
	}
	public String getImg_errloc() {
		return img_errloc;
	}
	public void setImg_errloc(String img_errloc) {
		this.img_errloc = img_errloc;
	}
	public int getR_assykey() {
		return r_assykey;
	}
	public void setR_assykey(int r_assykey) {
		this.r_assykey = r_assykey;
	}
	public Date getImg_seqid() {
		return img_seqid;
	}
	public void setImg_seqid(Date img_seqid) {
		this.img_seqid = img_seqid;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
}
