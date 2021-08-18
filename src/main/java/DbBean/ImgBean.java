package DbBean;

import java.sql.Date;
import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class ImgBean {
private static final long serialVersionUID = 1L;
	@JSONField(ordinal=1)
	private int img_key;
	@JSONField(ordinal=2)
	private String img_errloc;
	@JSONField(ordinal=3)
	private int r_key;
	@JSONField(ordinal=4)
	private String img_url;
	@JSONField(ordinal=5)
	private String img_cdate;
	
	public int getImg_key() {
		return img_key;
	}
	public void setImg_key(int img_key) {
		this.img_key = img_key;
	}
	public String getImg_errloc() {
		return img_errloc;
	}
	public void setImg_errloc(String img_errloc) {
		this.img_errloc = img_errloc;
	}
	public int getR_key() {
		return r_key;
	}
	public void setR_key(int r_key) {
		this.r_key = r_key;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getImg_cdate() {
		return img_cdate;
	}
	public void setImg_cdate(Timestamp img_cdate) {
		String strTimestamp = img_cdate.toString();
		this.img_cdate = strTimestamp.substring(0,strTimestamp.length()-2);
	}

}
