package jxnu.edu.x3321.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jxnu.edu.x3321.domain.Plates;
import jxnu.edu.x3321.mapper.PlatesMapper;
import jxnu.edu.x3321.service.PlatesService;

@Service("platesServiceImpl")
public class PlatesServiceImpl implements PlatesService {

	// 依赖注入
	@Autowired
	PlatesMapper platesMapper;

	public List<Plates> getPlatesList() {
		// TODO Auto-generated method stub
		return platesMapper.getPlateList();
	}

	public PageInfo<Plates> listByPage(int page, int recordOfPage) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, recordOfPage);
		List<Plates> plateList = this.platesMapper.getPlateList();
		PageInfo<Plates> pageInfor = new PageInfo<Plates>(plateList);
		/*
		 * pageInfor.getList(); pageInfor.getTotal(); pageInfor.getPageNum();
		 * pageInfor.getPages();
		 */
		

		return pageInfor;
	}

	public Plates get(int plate_id) {
		// TODO Auto-generated method stub
		return platesMapper.get(plate_id);
	}

	public int delete(int plate_id) {
		// TODO Auto-generated method stub
		return platesMapper.delete(plate_id);
	}

	public int add(Plates plates) {
		// TODO Auto-generated method stub
		return platesMapper.add(plates);
	}

}
