package jxnu.edu.x3321.service;

import java.util.List;
import jxnu.edu.x3321.domain.Reviews;

import com.github.pagehelper.PageInfo;

public interface ReviewsService {
	
	public List<Reviews> getReviewsList();
	
	public PageInfo<Reviews> listByPage(int page,int recordOfPage);
	
	public Reviews get(int review_id);
	
	public int delete(int review_id);
	
	public List<Reviews> getReviewsListById(int questionId);
	
	public int add(Reviews reviews);

}
