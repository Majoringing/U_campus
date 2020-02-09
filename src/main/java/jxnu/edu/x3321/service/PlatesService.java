package jxnu.edu.x3321.service;

import java.util.List;

import jxnu.edu.x3321.domain.Plates;

import com.github.pagehelper.PageInfo;

public interface PlatesService {

	
	public List<Plates> getPlatesList();
	
	public PageInfo<Plates>  listByPage(int page,int recordOfPage);
	
	public Plates get(int plate_id);
	
	public int delete(int plate_id);
	
	public int add(Plates plates);
	

}
