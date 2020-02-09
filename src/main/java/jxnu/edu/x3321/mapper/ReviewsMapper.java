package jxnu.edu.x3321.mapper;

import java.util.List;

import jxnu.edu.x3321.domain.Reviews;

public interface ReviewsMapper {
	
	public List<Reviews> getReviewsList();
	
	public Reviews get(int review_id);
	
	public int delete(int review_id);

	public List<Reviews> getReviewsListById(int questionId);
	
	public int add(Reviews reviews);
	
}
