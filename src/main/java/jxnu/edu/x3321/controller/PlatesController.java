package jxnu.edu.x3321.controller;

import jxnu.edu.x3321.domain.Plates;
import jxnu.edu.x3321.domain.User;
import jxnu.edu.x3321.service.PlatesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;


@RequestMapping("/plates")
@Controller("platescontroller")
public class PlatesController {
	
	@Autowired
	PlatesService platesService;
	
	
	int recordOfPage=2;
	
	@RequestMapping("/listPlatesByPage")
	public ModelAndView listPlatesByPage(Integer page) {
		ModelAndView mav=new ModelAndView();
		if(page==null) {
			page=1;
		}
		
		PageInfo<Plates> pageInfor=this.platesService.listByPage(page,
				  recordOfPage);		
		mav.addObject("pageInfor",pageInfor);
		mav.addObject("platesList",pageInfor.getList());
		mav.setViewName("plateCurp/PlateList");		
		return mav;
		
	}
	
	//删除单个用户信息
		@RequestMapping("/deletePlates")
		public String deletePlates(int plate_id){
			if(platesService.delete(plate_id)>0){
				return "redirect:listPlatesByPage";
			}else{
				return "plateCurp/error.jsp";
			}
		}
		
		//删除多个用户信息
		@RequestMapping("/deletePlatess")
		public String deleteQuestions(int [] plates__ids){
			for(int i=0;i<plates__ids.length;i++){
				platesService.delete(plates__ids[i]);
			}
			return "redirect:listPlatesByPage";
		}

		
		@RequestMapping("AddPlate")
		public String addPlate(Plates plates) {
			
			if(platesService.add(plates)>0) {
				return "redirect:listPlatesByPage";
			}else {
				return "redirect:listPlatesByPage";
			}		

		}
}
