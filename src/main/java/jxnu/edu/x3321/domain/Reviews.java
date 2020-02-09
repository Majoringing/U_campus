package jxnu.edu.x3321.domain;

import java.util.Date;

public class Reviews {
	//int reviews_id 回复的id
	private int review_id;
	//varchar review_image 回复的图片的路径
	private String review_image;
	//varchar review_content 回复的内容
	private String review_content;
	//int review_userId 回复人的id
	private int review_userId;
	//timestamp createtime 回复时间
	private Date createtime;
	//int questionId 该问题对应的问题ID
	private int questionId;
	//连表查询，评论者的信息
	private User review_user;
	
	
	
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public User getReview_user() {
		return review_user;
	}
	public void setReview_user(User review_user) {
		this.review_user = review_user;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getReview_image() {
		return review_image;
	}
	public void setReview_image(String review_image) {
		this.review_image = review_image;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_userId() {
		return review_userId;
	}
	public void setReview_userId(int review_userId) {
		this.review_userId = review_userId;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	
	

}
