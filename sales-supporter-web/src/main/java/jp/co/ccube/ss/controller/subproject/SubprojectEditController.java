package jp.co.ccube.ss.controller.subproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.form.SubprojectForm;
import jp.co.ccube.ss.service.SubprojectService;

public class SubprojectEditController {
	@Autowired
	SubprojectService subprojectService;
	//案件更新入力画面
//	@RequestMapping(value = "/subProjectList",params="edit",method = RequestMethod.POST)
	public ModelAndView detail(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model) {

		System.out.println("search testAAA");
		mav.setViewName("/subproject/subProjectEdit");
		return mav;

	}


}
