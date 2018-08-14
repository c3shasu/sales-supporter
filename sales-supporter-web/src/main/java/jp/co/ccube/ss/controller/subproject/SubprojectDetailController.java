package jp.co.ccube.ss.controller.subproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.config.CheckBoxItemConfig;
import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.entity.CaseDetail;
import jp.co.ccube.ss.form.SubprojectForm;
import jp.co.ccube.ss.service.SubprojectService;
@Controller
public class SubprojectDetailController extends AbstractController{

	@Autowired
	SubprojectService subprojectService;
    //案件詳細表示・案件詳細画面への遷移
	@RequestMapping(value="/subProjectList", params="detail", method=RequestMethod.POST)
	public ModelAndView detail(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model) {

		System.out.println("search testAA");
		mav.setViewName("/subproject/subProjectDetail");

		System.out.println("search testBB");
		List<CaseDetail> result = subprojectService.detailCase(form);

		System.out.println("search testCC123456");
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
		System.out.println("search testCCC123456");
		System.out.println(result.get(0).getCaseName());

		mav.addObject("searchSubprojectList", result);
		return mav;
	}

	//案件更新入力画面
	@RequestMapping(value="/subProjectList", params="edit", method=RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model) {

		System.out.println("search testAAA");
		SubprojectForm result = subprojectService.editSubprojectSearch(form);
		model.addAttribute("form", subprojectService.editSubprojectSearch(form));
		mav.setViewName("/subproject/subProjectEdit");
		mav.addObject("searchSubprojectList", result);
		return mav;

	}

	//案件削除確認画面
	@RequestMapping(value="/subProjectList", params="delete", method=RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model){
		System.out.println("deleteA");
		mav.setViewName("/subproject/subProjectDeleteCheck");
		List<CaseDetail> result = subprojectService.deleteSubprojectSearch(form);
		mav.addObject("searchSubprojectList", result);
		System.out.println("deleteB");
		return mav;
	}


}
