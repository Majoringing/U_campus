package jxnu.edu.x3321.service;

import java.util.List;
import java.util.Map;

import jxnu.edu.x3321.domain.User;

import com.github.pagehelper.PageInfo;

public interface UserService {
	
	public User login(Map map);
	
	public List<User> getUserList();
	
	public PageInfo<User>  listByPage(int page,int recordOfPage);
	
	public int update(User user);
	
	public User get(int userId);
	
	public int delete(int userId);
	
	public int add(User user);




}
