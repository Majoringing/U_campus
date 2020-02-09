package jxnu.edu.x3321.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxnu.edu.x3321.domain.Files;
import jxnu.edu.x3321.domain.Question;
import jxnu.edu.x3321.domain.User;
import jxnu.edu.x3321.service.FilesService;
import jxnu.edu.x3321.service.QuestionService;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/upload")
@Controller("filescontroller")
public class FilesController {
	// 依赖注入
	@Autowired
	FilesService filesService;
	@Autowired
	QuestionService questionService;
	
	
	public String key1;
	/*
	 * 采用file.Transto 来保存上传的文件
	 */
	@RequestMapping("/fileUpload")
	public String fileUpload2(@RequestParam("file1") MultipartFile file,
			HttpServletRequest request, HttpSession httpSession,
			HttpServletResponse response, Files files) throws IOException {
		// 获取当前用户的信息
		User user1 = (User) httpSession.getAttribute("user");
		int userId = user1.getUserId();

		String filePath = "E:\\upload";

		String name = UUID.randomUUID().toString().replaceAll("-", "");
		// 获取文件的扩展名
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		// 生成新的文件名
		String newFileName = name + "." + ext;
		// 封装上传文件位置的全路径
		File targetFile = new File(filePath, newFileName);
		file.transferTo(targetFile);

		// 保存到数据库
		files.setFiledir(newFileName);
		files.setFilename(file.getOriginalFilename());
		files.setUserId(userId);
		files.setFile_size(file.getSize());

		if (filesService.add(files) != 0) {
			return "redirect:/question/listQuestionByPage2";
		} else {

			return "";
		}
	}

	// 根据搜索显示文件和问题列表
	@RequestMapping("/listQ_FByPagekeyword")
	public ModelAndView listQ_FByPagekeyword(String key) {
		key1 = key;
		System.out.println("我得到的key值为：" + key);
		ModelAndView mav = new ModelAndView();
		List<Files> filelist = filesService.getFBykeyword(key);
		List<Question> questionlist = questionService.getQ_FBykeyword(key);

		mav.addObject("questionlist", questionlist);
		mav.addObject("filelist", filelist);
		System.out.println("查询所得的问题：" + questionlist);
		System.out.println("查询所得的文件：" + filelist);
		mav.setViewName("/main/about");
		return mav;
	}

	// 用户下载资料
	@RequestMapping("/downloadFile")
	public String downloadFile(HttpServletRequest request,
			HttpServletResponse response, int fileId) throws Exception {
		System.out.println("文件的ID：" + fileId);
		Files files = filesService.get(fileId);
		String filedir = files.getFiledir();
		// 文件的名称
		String name = files.getFilename();
		// 1，创建获取文件路径的对象
		File f = new File("E:/upload/"+filedir);
		// 创建FilrInputStream对象,文件的输入流
		FileInputStream fs = new FileInputStream(f);

		// 2，创建储存文件地址的对象
		File f1 = new File("C:/Users/小智/Desktop/"+name);
		FileOutputStream fs1 = new FileOutputStream(f1);
		// 创建一个缓冲池
		byte[] buffer = new byte[1024 * 64];
		// read方法返回读取的数据长度
		int length = fs.read(buffer);
		while (length > 0) {
			fs1.write(buffer);
			length = fs.read(buffer);
		}
		fs.close();
		fs1.close();
		return "redirect:/upload/listQ_FByPagekeyword?key="+key1;
	}
	
}
