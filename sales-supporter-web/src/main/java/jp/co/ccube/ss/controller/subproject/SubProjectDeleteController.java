package jp.co.ccube.ss.controller.subproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.form.SubprojectForm;
import jp.co.ccube.ss.service.SubprojectService;

public class SubProjectDeleteController extends AbstractController{

	@Autowired
	SubprojectService subprojectService;

	@RequestMapping(value="/subProjectListDel", params="delete",  method=RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model) {
		// 削除対象確認
		System.out.println("deleteStart");
//		subprojectService.deleteSubproject(form);
//		System.out.println("deleteCheck1");
//		mav.setViewName("/subproject/subProjectDeleteConfirm");
//		System.out.println("deleteCheck2");
//		List<CaseDetail> result = subprojectService.searchSubproject(form);
//		System.out.println("deleteCheck3");
//		mav.addObject("searchSubprojectList", result);
//		System.out.println("deleteEnd");
		return mav;
	}


}
