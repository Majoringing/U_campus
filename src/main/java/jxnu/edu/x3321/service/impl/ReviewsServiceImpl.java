package jxnu.edu.x3321.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jxnu.edu.x3321.domain.Reviews;
import jxnu.edu.x3321.mapper.ReviewsMapper;
import jxnu.edu.x3321.service.ReviewsService;


@Service("reviewsServiceImpl")
public class ReviewsServiceImpl implements ReviewsService {

	// 依赖注入
	@Autowired
	ReviewsMapper reviewsMapper;

	public List<Reviews> getReviewsList() {
		// TODO Auto-generated method stub
		return reviewsMapper.getReviewsList();
	}

	public PageInfo<Reviews> listByPage(int page, int recordOfPage) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, recordOfPage);
		List<Reviews> ReviewsList = this.reviewsMapper.getReviewsList();
		PageInfo<Reviews> pageInfor = new PageInfo<Reviews>(ReviewsList);
		/*
		 * pageInfor.getList(); pageInfor.getTotal(); pageInfor.getPageNum();
		 * pageInfor.getPages();
		 */

		return pageInfor;
	}

	public Reviews get(int review_id) {
		// TODO Auto-generated method stub
		return reviewsMapper.get(review_id);
	}

	public int delete(int review_id) {
		// TODO Auto-generated method stub
		return reviewsMapper.delete(review_id);
	}
	
	//通过questionId来寻找到所有的回复
	public List<Reviews> getReviewsListById(int questionId) {
		// TODO Auto-generated method stub
		return reviewsMapper.getReviewsListById(questionId);
	}

	public int add(Reviews reviews) {
		// TODO Auto-generated method stub
		return reviewsMapper.add(reviews);
	}

}
