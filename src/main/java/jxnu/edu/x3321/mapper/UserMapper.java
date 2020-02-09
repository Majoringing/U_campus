package jxnu.edu.x3321.mapper;

import java.util.List;
import java.util.Map;

import jxnu.edu.x3321.domain.User;

public interface UserMapper {
	
	public User loginCheck(Map map);
	
	public List<User> getUserList();
	
	public int update(User user);

	public User get(int userId);
	
	public int delete(int userId);
	
	public int add(User user);

}
