package jxnu.edu.x3321.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jxnu.edu.x3321.domain.Files;
import jxnu.edu.x3321.mapper.FilesMapper;
import jxnu.edu.x3321.service.FilesService;


@Service("filesServiceImpl")
public class FilesServiceImpl implements FilesService{
	@Autowired
	FilesMapper filesMapper;
	
	public int add(Files files){
		
		return filesMapper.add(files);
	}

	public List<Files> getFBykeyword(String key) {
		// TODO Auto-generated method stub
		return filesMapper.getFBykeyword(key);
	}

	public Files get(int fileId) {
		// TODO Auto-generated method stub
		return filesMapper.get(fileId);
	}

}
