package jxnu.edu.x3321.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxnu.edu.x3321.domain.Question;
import jxnu.edu.x3321.domain.Reviews;
import jxnu.edu.x3321.domain.User;
import jxnu.edu.x3321.service.QuestionService;
import jxnu.edu.x3321.service.ReviewsService;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

@RequestMapping("/question")
@Controller("questioncontroller")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	@Autowired
	ReviewsService reviewService;

	int recordOfPage = 4;

	// 管理员显示所有的问题
	@RequestMapping("/listQuestionByPage1")
	public ModelAndView listQuestionByPage1(Integer page) {
		ModelAndView mav = new ModelAndView();
		if (page == null) {
			page = 1;
		}

		PageInfo<Question> pageInfor = this.questionService.listByPage(page,
				recordOfPage);
		mav.addObject("pageInfor", pageInfor);
		mav.addObject("questionList", pageInfor.getList());

		mav.setViewName("questionCurp/QuestionList");
		return mav;

	}

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

	// 客户端个人信息的界面的显示
	@RequestMapping("/listQuestionByPage3")
	public ModelAndView listQuestionByPage3(Integer page, Integer user_id) {
		ModelAndView mav = new ModelAndView();
		// System.out.println(user_id);
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

	// 个人信息查看的时候删除单个用户信息
	@RequestMapping("/deleteQuestion1")
	public String deleteQuestion1(HttpServletResponse response,
			HttpSession httpSession, int questionId) {
		User user = (User) httpSession.getAttribute("user");
		int userId = user.getUserId();
		System.out.println("前端来的id" + questionId);
		if (questionService.delete(questionId) > 0) {

			return "redirect:listQuestionByPage3?user_id=" + userId;
		} else {
			return "redirect:listQuestionByPage3";
		}
	}

	// 管理员删除单个用户信息
	@RequestMapping("/deleteQuestion")
	public String deleteQuestion(int questionId) {

		if (questionService.delete(questionId) > 0) {
			return "redirect:listQuestionByPage";
		} else {
			return "questionCurp/error.jsp";
		}
	}

	// 删除多个用户信息
	@RequestMapping("/deleteQuestions")
	public String deleteQuestions(int[] questionIds) {
		for (int i = 0; i < questionIds.length; i++) {
			questionService.delete(questionIds[i]);
		}
		return "redirect:listQuesttionByPage";
	}

	// 添加帖子
	@RequestMapping("questionAdd")
	public String addQuestion(
			@RequestParam(value = "image") MultipartFile pictureFile,
			HttpServletRequest request, HttpSession httpSession,
			HttpServletResponse response, Question question) throws IOException{
		User user1 = (User) httpSession.getAttribute("user");
		int userId = user1.getUserId();
		question.setUser_id(userId);
		
		//更新图片的上传于下载。将图片下载到本地，而不是放在tomcat,从而解决服务器重启导致的图片文件夹更新的问题
		
		//保存图片的路径，图片上传成功后将路径保存到数据库
		String filePath = "E:\\upload";
		//获取图片的拓展名
		// 使用UUID给图片重命名，并去掉四个“-”
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		// 获取文件的扩展名
		String ext = FilenameUtils.getExtension(pictureFile
						.getOriginalFilename());
		//生成新的文件名
		String newFileName = name+ "." + ext;
		//封装上传文件位置的全路径
		File targetFile = new File(filePath,newFileName);
		pictureFile.transferTo(targetFile);
		
		//保存到数据库
		question.setQuestion_image(newFileName);
		
		if(questionService.add(question)!= 0){
			return "redirect:listQuestionByPage2";
		}else{
			
			return "";
		}
		
		
		
		
	}

	// 点击查看详细问题信息
	@RequestMapping("/detail_question")
	public ModelAndView detail_question(HttpServletRequest request,
			HttpServletResponse response,int questionId) {
		ModelAndView mav = new ModelAndView();
		Question question = questionService.get(questionId);
		request.getSession().setAttribute("questionId", questionId);
		List<Reviews> reviewsList = reviewService
				.getReviewsListById(questionId);
		mav.addObject("reviewsList", reviewsList);
		mav.addObject("question", question);
		mav.setViewName("main/detail_question");
		return mav;
	}

}
