package jxnu.edu.x3321.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxnu.edu.x3321.domain.Question;
import jxnu.edu.x3321.domain.User;
import jxnu.edu.x3321.service.QuestionService;
import jxnu.edu.x3321.service.UserService;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

@RequestMapping("/user")
@Controller("usercontroller")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	QuestionService questionService;

	int recordOfPage = 2;

	// 管理员
	@RequestMapping("/checklogin")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, User user) {

		ModelAndView mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		// 数据来自前端，并不是数据库取出来的数据
		map.put("mobilePhoneNumber", user.getMobilePhoneNumber());
		map.put("password", user.getPassword());
		User user1 = userService.login(map);
		request.getSession().setAttribute("user", user1);
		if (user1 != null && (user1.getPassword()).equals(map.get("password"))) {
			mav.addObject("username", user1.getUsername());
			mav.setViewName("Hello");
			return mav;
		} else {
			mav.setViewName("login");
			return mav;
		}
	}

	// 用户登陆检测
	@RequestMapping("/checklogin1")
	public String login1(HttpServletRequest request,
			HttpServletResponse response, User user) {

		Map<String, String> map = new HashMap<String, String>();
		// 数据来自前端，并不是数据库取出来的数据
		map.put("mobilePhoneNumber", user.getMobilePhoneNumber());
		map.put("password", user.getPassword());
		User user1 = userService.login(map);
		// 存储的只有用户ID\
		request.getSession().setAttribute("user", user1);

		if (user1 != null && (user1.getPassword()).equals(map.get("password"))) {

			return "redirect:listQuestionByPage2";
		} else {

			return "redirect:L_and_r/login.jsp";
		}
	}

	@RequestMapping("/listUserByPage")
	public ModelAndView listUserByPage(Integer page) {
		ModelAndView mav = new ModelAndView();
		if (page == null) {
			page = 1;
		}

		PageInfo<User> pageInfor = this.userService.listByPage(page,
				recordOfPage);

		mav.addObject("pageInfor", pageInfor);
		mav.addObject("userList", pageInfor.getList());
		mav.setViewName("userCurp/UserList");

		return mav;

	}

	// 已登录用户的信息修改
	@RequestMapping("/editLoadUser")
	public ModelAndView editLoadUser(int userId) {
		ModelAndView mav = new ModelAndView();
		User user = userService.get(userId);
		mav.addObject("user", user);
		mav.setViewName("userCurp/UserEdit");
		return mav;
	}

	@RequestMapping("/editUser")
	public String editUser(
			@RequestParam(value = "header") MultipartFile pictureFile,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession httpSession, User user)throws IOException {

		User user1 = (User) httpSession.getAttribute("user");
		int userId = user1.getUserId();
		user.setUserId(userId);

		// 更新图片的上传于下载。将图片下载到本地，而不是放在tomcat,从而解决服务器重启导致的图片文件夹更新的问题

		// 保存图片的路径，图片上传成功后将路径保存到数据库
		String filePath = "E:\\upload";
		// 获取图片的拓展名
		// 使用UUID给图片重命名，并去掉四个“-”
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		// 获取文件的扩展名
		String ext = FilenameUtils.getExtension(pictureFile
				.getOriginalFilename());
		// 生成新的文件名
		String newFileName = name + "." + ext;
		// 封装上传文件位置的全路径
		File targetFile = new File(filePath, newFileName);
		pictureFile.transferTo(targetFile);

		// 保存到数据库
		user.setHead(newFileName);
		if (userService.update(user) > 0) {

			return "redirect:listQuestionByPage3?user_id=" + userId;
		} else {
			System.out.println(userService.update(user));
			return "userCurp/error";
		}

	}

	// 客户端个人信息的界面的显示
	@RequestMapping("/listQuestionByPage3")
	public ModelAndView listQuestionByPage3(Integer page, Integer user_id) {
		ModelAndView mav = new ModelAndView();
		System.out.println(user_id);
		if (page == null) {
			page = 1;
		}
		PageInfo<Question> pageInfor = this.questionService.listByPageById(
				page, 20, user_id);
		mav.addObject("pageInfor", pageInfor);
		mav.addObject("questionList", pageInfor.getList());
		if (pageInfor.equals(null)) {
			System.out.println("他是空的");
		} else {
			System.out.println(pageInfor);
		}
		mav.setViewName("main/contact");
		return mav;

	}

	// 删除单个用户信息
	@RequestMapping("/deleteUser")
	public String deleteUser(int userId) {
		if (userService.delete(userId) > 0) {
			return "redirect:listUserByPage";
		} else {
			return "userCurp/error.jsp";
		}
	}

	// 删除多个用户信息
	@RequestMapping("/deleteUsers")
	public String deleteUsers(int[] userIds) {
		for (int i = 0; i < userIds.length; i++) {
			userService.delete(userIds[i]);
		}
		return "redirect:listUserByPage";
	}

	// 添加用户
	@RequestMapping("userAdd")
	public String addCustomer(HttpServletRequest request,
			HttpServletResponse response, User user) {

		if (userService.add(user) > 0) {
			request.getSession().setAttribute("user", user);

			return "redirect:listQuestionByPage2";
		} else {
			return "redirect:L_and_r/login.jsp";
		}

	}

	// 登录时初始显示
	// 客户端的显示
	@RequestMapping("/listQuestionByPage2")
	public ModelAndView listQuestionByPage2(Integer page) {
		ModelAndView mav = new ModelAndView();
		if (page == null) {
			page = 1;
		}

		PageInfo<Question> pageInfor = this.questionService.listByPage(page,
				recordOfPage);
		mav.addObject("pageInfor", pageInfor);
		mav.addObject("questionList", pageInfor.getList());

		mav.setViewName("main/index");
		return mav;

	}

}
