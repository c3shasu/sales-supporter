package jp.co.ccube.ss.controller.subproject;

import javax.servlet.http.HttpSession;

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
	public ModelAndView detail(@ModelAttribute("form") SubprojectForm form, ModelAndView mav, Model model,HttpSession session) {

		System.out.println("1" + form.getProjectId() + " :: " + form.getCaseId());
		mav.setViewName("/subproject/subProjectDetail");
		Integer c = form.getCaseId();
		String ic = String.valueOf(c);
		String[] id = ic.split("",0);
		int[] ia = new int[id.length];
		for (int i = 0; i < id.length; i++) {
		    ia[i] = Integer.parseInt(id[i]); // throws NumberFormatException
		}
		int caseId = ia[0];
		int projectId = ia[1];

	    form.setProjectId(projectId);
	    form.setCaseId(caseId);
		CaseDetail caseDetail = new CaseDetail();
		caseDetail = subprojectService.detailCase(form);
		System.out.println("search testCC123456");
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);

		System.out.println("search testCCC123456");

        //詳細の検索結果の保存
         session.setAttribute("caseDetail", caseDetail);
         CaseDetail detailC = new CaseDetail();
         detailC = (CaseDetail)session.getAttribute("caseDetail");
System.out.println(detailC.getClassificationName());
         mav.addObject("caseDetail", caseDetail);
		return mav;
	}

	//案件更新入力画面
	@RequestMapping(value="/subProjectList", params="edit", method=RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model, HttpSession session) {


		CaseDetail caseDetail = new CaseDetail();
		CaseDetail detail = new CaseDetail();
        detail = (CaseDetail)session.getAttribute("caseDetail");
        System.out.println(detail.getProjectId());
        System.out.println(detail.getCaseId());
		form.setProjectId(detail.getProjectId());
		form.setCaseId(detail.getCaseId());
		System.out.println("search testAAA");
		SubprojectForm result = subprojectService.editSubprojectSearch(form);
		model.addAttribute("form", subprojectService.editSubprojectSearch(form));
		mav.setViewName("/subproject/subProjectEdit");
		mav.addObject("searchSubprojectList", result);
		return mav;

	}

	//案件削除確認画面
	@RequestMapping(value="/subProjectList", params="delete", method=RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model, HttpSession session){
		System.out.println("deleteA");
		mav.setViewName("/subproject/subProjectDeleteCheck");
		CaseDetail detail = new CaseDetail();
        detail = (CaseDetail)session.getAttribute("caseDetail");
        System.out.println(detail.getProjectId());
        System.out.println(detail.getCaseId());
		form.setProjectId(detail.getProjectId());
		form.setCaseId(detail.getCaseId());
		CaseDetail result = subprojectService.deleteSubprojectSearch(form);
		mav.addObject("searchSubprojectList", result);
		System.out.println("deleteB");
		return mav;
	}


}
