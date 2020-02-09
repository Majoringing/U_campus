package jxnu.edu.x3321.domain;

import java.util.Date;

public class Plates {
	//int plate_id 版块的id
	private int plate_id;
	//varchar plate_name 版块的名字
	private String plate_name;
	//timestamp createtime 创建时间
	private Date createtime;
	public int getPlate_id() {
		return plate_id;
	}
	public void setPlate_id(int plate_id) {
		this.plate_id = plate_id;
	}
	public String getPlate_name() {
		return plate_name;
	}
	public void setPlate_name(String plate_name) {
		this.plate_name = plate_name;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
