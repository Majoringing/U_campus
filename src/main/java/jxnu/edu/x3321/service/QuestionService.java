package jxnu.edu.x3321.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import jxnu.edu.x3321.domain.Question;

import com.github.pagehelper.PageInfo;

public interface QuestionService {
	
	public List<Question> getQuestionList();
	
	public List<Question> getQuestionListById(int user_id);
	
	public PageInfo<Question>  listByPage(int page,int recordOfPage);
	
	public PageInfo<Question>  listByPageById(int page,int recordOfPage,int user_id);
	
	//根据关键字显示问题列表
	public List<Question> getQ_FBykeyword(String key);
	
	public Question get(int questionId);
	
	public int delete(int questionId);
	
	public int add(Question question);

}
