package jxnu.edu.x3321.domain;

import java.util.Date;

public class Files {
	//int fileId 上传的文件的id
	private int fileId;
	//int userId 上传的用户的id
	private int userId;
	//double file_size 上传的文件的大小
	private double file_size;
	//timestamp createtime createtime;	
	private Date createtime;
	//filename varchar   上传的文件的名字
	private String filename;
	//filedir varchar 文件的地址
	private String filedir;
	
	
	
	
	
	
	public String getFiledir() {
		return filedir;
	}
	public void setFiledir(String filedir) {
		this.filedir = filedir;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getFile_size() {
		return file_size;
	}
	public void setFile_size(double file_size) {
		this.file_size = file_size;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	

}
