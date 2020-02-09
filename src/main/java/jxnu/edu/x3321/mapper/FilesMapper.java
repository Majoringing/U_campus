package jxnu.edu.x3321.mapper;

import java.util.List;

import jxnu.edu.x3321.domain.Files;


public interface FilesMapper {
	
	public int add(Files files);
	
	//根据关键字显示问题列表
	public List<Files> getFBykeyword(String key);
	
	public Files get(int fileId);

}
