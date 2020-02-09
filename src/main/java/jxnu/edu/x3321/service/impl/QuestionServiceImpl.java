package jxnu.edu.x3321.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jxnu.edu.x3321.domain.Question;
import jxnu.edu.x3321.mapper.QuestionMapper;
import jxnu.edu.x3321.service.QuestionService;

@Service("questionServiceImpl")
public class QuestionServiceImpl implements QuestionService {

	// 依赖注入
	@Autowired
	QuestionMapper questionMapper;

	public List<Question> getQuestionList() {
		// TODO Auto-generated method stub
		return questionMapper.getQuestionList();
	}

	public PageInfo<Question> listByPage(int page, int recordOfPage) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, recordOfPage);
		List<Question> questionList = this.questionMapper.getQuestionList();
		PageInfo<Question> pageInfor = new PageInfo<Question>(questionList);
		/*
		 * pageInfor.getList(); pageInfor.getTotal(); pageInfor.getPageNum();
		 * pageInfor.getPages();
		 */

		return pageInfor;
	}

	public Question get(int questionId) {
		// TODO Auto-generated method stub
		return questionMapper.get(questionId);
	}

	public int delete(int questionId) {
		// TODO Auto-generated method stub
		return questionMapper.delete(questionId);
	}

	// 通过用户Id查询用户已经发布的问题
	public List<Question> getQuestionListById(int user_id) {
		// TODO Auto-generated method stub
		return questionMapper.getQuestionListById(user_id);
	}
	
	
	//
	public PageInfo<Question> listByPageById(int page, int recordOfPage,
			int user_id) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, recordOfPage);
		List<Question> questionList = this.questionMapper.getQuestionListById(user_id);
		PageInfo<Question> pageInfor = new PageInfo<Question>(questionList);
		/*
		 * pageInfor.getList(); pageInfor.getTotal(); pageInfor.getPageNum();
		 * pageInfor.getPages();
		 */

		return pageInfor;
	}
	//添加帖子
	public int add(Question question) {
		// TODO Auto-generated method stub
		return questionMapper.add(question);
	}

	public List<Question> getQ_FBykeyword(String key) {
		System.out.println("service层的key:"+ key );
		return questionMapper.getQ_FBykeyword(key);
	}

}
