package jp.co.ccube.ss.controller.subproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.form.SubprojectForm;
import jp.co.ccube.ss.service.SubprojectService;

@Controller
public class SubprojectEditController extends AbstractController{
	@Autowired
	SubprojectService subprojectService;
	//案件更新入力画面
    @RequestMapping(value = "/subProjectList", params="child", method = RequestMethod.GET)
	public ModelAndView child(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model) {
    	System.out.println("子画面の表示");
    	mav.setViewName("/subproject/clientResponsible");
    	return mav;
	}
    @RequestMapping(value = "/clientResponsible",method = RequestMethod.GET)
  	public String childA(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model) {
      	System.out.println("B子画面の表示子画面の表示");
		return "subproject/clientResponsible";
    }
}
