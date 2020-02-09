package jxnu.edu.x3321.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jxnu.edu.x3321.domain.User;
import jxnu.edu.x3321.mapper.UserMapper;
import jxnu.edu.x3321.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	//依赖注入
	@Autowired
	UserMapper userMapper;

	public User login(Map map) {
		User userFormTabel = userMapper.loginCheck(map);
		System.out.println(userFormTabel.getUserId());
		return userFormTabel;
	}
	
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userMapper.getUserList();
	}

	public PageInfo<User> listByPage(int page, int recordOfPage) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, recordOfPage);
		List<User> userList=this.userMapper.getUserList();
		PageInfo<User> pageInfor=new PageInfo<User>(userList);
	/*	
		pageInfor.getList();
		pageInfor.getTotal();
		pageInfor.getPageNum();
		pageInfor.getPages();
		*/
		
		return pageInfor;
	}


	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}
	
	public User get(int userId){
		return userMapper.get(userId);
	}

	public int delete(int userId) {
		// TODO Auto-generated method stub
		return userMapper.delete(userId);
	}

	//添加帖子
	public int add(User user) {
		// TODO Auto-generated method stub
		return userMapper.add(user);
	}





}
