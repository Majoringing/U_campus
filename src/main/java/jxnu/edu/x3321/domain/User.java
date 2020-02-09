package jxnu.edu.x3321.domain;

import java.util.Date;

public class User {
	//int userId 用户id
	private int userId;
	//varchar mobilePhoneNumber 用户注册时使用的电话号码
	private String mobilePhoneNumber;
	//varchar username 用户名
	private String username;
	//varchar password 用户密码
	private String password;
	//varchar sno 用户学号
	private String sno;
	//date birthday 用户生日
	private Date birthday;
	//varchar head 用户的头像存储路径
	private String head;
	//varchar major 用户所在专业
	private String major;
	//varchar sign 用户的个性签名
	private String sign;
	//varchar sex 用户性别
	private String sex;
	//varchar campus 用户的学校
	private String campus;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	@Override
	public String toString() {
		return "User [getUserId()=" + getUserId() + ", getMobilePhoneNumber()="
				+ getMobilePhoneNumber() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getSno()=" + getSno()
				+ ", getBirthday()=" + getBirthday() + ", getHead()="
				+ getHead() + ", getMajor()=" + getMajor() + ", getSign()="
				+ getSign() + ", getSex()=" + getSex() + ", getCampus()="
				+ getCampus() + "]";
	}
	
	
	
	

}
