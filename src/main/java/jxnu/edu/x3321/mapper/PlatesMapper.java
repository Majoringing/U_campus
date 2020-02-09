package jxnu.edu.x3321.mapper;

import java.util.List;

import jxnu.edu.x3321.domain.Plates;
import jxnu.edu.x3321.domain.User;

public interface PlatesMapper {
	
	public List<Plates> getPlateList();
		
	public Plates get(int plate_id);
	
	public int delete(int plate_id);
	
	public int add(Plates plates);
	

}
