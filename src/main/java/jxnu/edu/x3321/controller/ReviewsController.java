package jxnu.edu.x3321.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxnu.edu.x3321.domain.Reviews;
import jxnu.edu.x3321.domain.User;
import jxnu.edu.x3321.service.QuestionService;
import jxnu.edu.x3321.service.ReviewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

@RequestMapping("/reviews")
@Controller("reviewscontroller")
public class ReviewsController {
	
	@Autowired
	ReviewsService reviewsService;
	@Autowired
	QuestionService questionService;

	int recordOfPage = 2;

	@RequestMapping("/listReviewsByPage")
	public ModelAndView listReviewsByPage(Integer page) {
		ModelAndView mav = new ModelAndView();
		if (page == null) {
			page = 1;
		}

		PageInfo<Reviews> pageInfor = this.reviewsService.listByPage(page,
				recordOfPage);
		mav.addObject("pageInfor", pageInfor);
		mav.addObject("reviewsList", pageInfor.getList());
		mav.setViewName("reviewsCurp/ReviewsList");
		return mav;

	}

	// 删除单个用户信息
	@RequestMapping("/deleteReviews")
	public String deleteReviews(int review_id) {
		if (reviewsService.delete(review_id) > 0) {
			return "redirect:listReviewsByPage";
		} else {
			return "reviewsCurp/error.jsp";
		}
	}

	// 删除多个用户信息
	@RequestMapping("/deleteReviewss")
	public String deleteQuestions(int[] review__ids) {
		for (int i = 0; i <review__ids.length; i++) {
			reviewsService.delete(review__ids[i]);
		}
		return "redirect:listReviewsByPage";
	}

	@RequestMapping("/reviewsAdd")
	public String addReviews(	
			HttpServletRequest request,HttpSession httpSession,
			HttpServletResponse response,Reviews reviews) {
		User user1 = (User) httpSession.getAttribute("user");
		int userId = user1.getUserId();
		reviews.setReview_userId(userId);
		
		int questionId = (Integer) httpSession.getAttribute("questionId");
		reviews.setQuestionId(questionId); 
		
		if (reviewsService.add(reviews) > 0) {
			

			return "redirect:/question/listQuestionByPage2";
		} else {
			return "error.jsp";
		}

	}
	

}
