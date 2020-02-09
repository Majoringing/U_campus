package jxnu.edu.x3321.mapper;

import java.util.List;
import jxnu.edu.x3321.domain.Question;


public interface QuestionMapper {
	
	public List<Question> getQuestionList();
	
	public List<Question> getQuestionListById(int user_id);
	
	//根据关键字显示问题列表
	public List<Question> getQ_FBykeyword(String key);
	
	public Question get(int questionId);

	public int delete(int questionId);
	
	public int add(Question question);

}
