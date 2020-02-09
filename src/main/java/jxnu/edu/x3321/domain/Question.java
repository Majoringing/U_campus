package jxnu.edu.x3321.domain;

import java.util.Date;

public class Question {
	//int questionId 问题的id
	private int questionId;
	//varchar question_image 问题的图片的路径
	private String question_image;
	//int user_id 发布问题的作者id
	private int user_id;
	//int plate_id 问题所在版块的id
	private int plate_id;
	//varchar keyword 问题的关键字
	private String keyword;
	//varchar title 问题的标题
	private String title;
	//int reviewsum 该问题的回复数
	private int reviewsum;
	//int pointsum 该问题的被点赞数
	private int pointsum;
	//varchar content 该问题的内容
	private String content;
	//varchar campus 该问题所属的学校
	private String campus;
	//timestamp createtime 问题发布的时间
	private Date createtime;
	//连表查询，作者名字
	private User question_user;
	//连表查询，版块名字
	private Plates question_plates;
	
	public Plates getQuestion_plates() {
		return question_plates;
	}
	public void setQuestion_plates(Plates question_plates) {
		this.question_plates = question_plates;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion_image() {
		return question_image;
	}
	public void setQuestion_image(String question_image) {
		this.question_image = question_image;
	}
	
	
	
	
	
	
	public User getQuestion_user() {
		return question_user;
	}
	public void setQuestion_user(User question_user) {
		this.question_user = question_user;
	}
	public int getPlate_id() {
		return plate_id;
	}
	public void setPlate_id(int plate_id) {
		this.plate_id = plate_id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReviewsum() {
		return reviewsum;
	}
	public void setReviewsum(int reviewsum) {
		this.reviewsum = reviewsum;
	}
	public int getPointsum() {
		return pointsum;
	}
	public void setPointsum(int pointsum) {
		this.pointsum = pointsum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question_image="
				+ question_image + ", user_id=" + user_id + ", plate_id="
				+ plate_id + ", keyword=" + keyword + ", title=" + title
				+ ", reviewsum=" + reviewsum + ", pointsum=" + pointsum
				+ ", content=" + content + ", campus=" + campus
				+ ", createtime=" + createtime + ", question_user="
				+ question_user + ", getUser_id()=" + getUser_id()
				+ ", getQuestionId()=" + getQuestionId()
				+ ", getQuestion_image()=" + getQuestion_image()
				+ ", getQuestion_user()=" + getQuestion_user()
				+ ", getPlate_id()=" + getPlate_id() + ", getKeyword()="
				+ getKeyword() + ", getTitle()=" + getTitle()
				+ ", getReviewsum()=" + getReviewsum() + ", getPointsum()="
				+ getPointsum() + ", getContent()=" + getContent()
				+ ", getCampus()=" + getCampus() + ", getCreatetime()="
				+ getCreatetime() + "]";
	}
	
	
	

}
