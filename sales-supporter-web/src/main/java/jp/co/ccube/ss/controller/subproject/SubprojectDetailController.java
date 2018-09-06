package jp.co.ccube.ss.controller.subproject;

import java.util.List;

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
import jp.co.ccube.ss.entity.ChargeClientEmployee;
import jp.co.ccube.ss.form.SubprojectForm;
import jp.co.ccube.ss.service.SubprojectService;

@Controller
public class SubprojectDetailController extends AbstractController {

	@Autowired
	SubprojectService subprojectService;

	// 案件詳細表示・案件詳細画面への遷移
	@RequestMapping(value = "/subProjectList", params = "detail", method = RequestMethod.POST)
	public ModelAndView detail(@ModelAttribute("form") SubprojectForm form, ModelAndView mav, Model model,
			HttpSession session) {

		mav.setViewName("/subproject/subProjectDetail");
		Integer c = form.getCaseId();
		String ic = String.valueOf(c);
		String[] id = ic.split(" ", 0);
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
		List<ChargeClientEmployee> chargeClientEmployee = subprojectService.searchCharge(form);

		for (int i = 0; i < chargeClientEmployee.size(); i++) {
			System.out.println(chargeClientEmployee.get(i).getEmployeeNo());
			System.out.println(chargeClientEmployee.get(i).getClientId());
			System.out.println(chargeClientEmployee.get(i).getEngineerName());
			System.out.println(chargeClientEmployee.get(i).getDepartment());
			System.out.println(chargeClientEmployee.get(i).getCompanyName());
			System.out.println(chargeClientEmployee.get(i).getStartDate());
			System.out.println(chargeClientEmployee.get(i).getEndDate());
			System.out.println(chargeClientEmployee.get(i).getProjectId());
			System.out.println(chargeClientEmployee.get(i).getCaseId());
			System.out.println(chargeClientEmployee.get(i).getBranchNo());
		}
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);

		// 詳細の検索結果の保存
		session.setAttribute("caseDetail", caseDetail);
		session.setAttribute("chargeClientEmployee", chargeClientEmployee);
		CaseDetail detailC = new CaseDetail();
		detailC = (CaseDetail) session.getAttribute("caseDetail");
		mav.addObject("caseDetail", caseDetail);
		mav.addObject("chargeClientEmployee", chargeClientEmployee);
		return mav;
	}

	// 案件更新入力画面
	@RequestMapping(value = "/subProjectList", params = "edit", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model,
			HttpSession session) {

		CaseDetail detail = new CaseDetail();
		detail = (CaseDetail) session.getAttribute("caseDetail");
		form.setProjectId(detail.getProjectId());
		form.setCaseId(detail.getCaseId());

		SubprojectForm result = subprojectService.editSubprojectSearch(form);

		session.setAttribute("caseEdit", result);
		model.addAttribute("form", subprojectService.editSubprojectSearch(form));
		mav.setViewName("/subproject/subProjectEdit");
		mav.addObject("searchSubprojectList", result);
		return mav;

	}

	// 案件削除確認画面
	@RequestMapping(value = "/subProjectList", params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model,
			HttpSession session) {

		mav.setViewName("/subproject/subProjectDeleteCheck");
		CaseDetail detail = new CaseDetail();
		detail = (CaseDetail) session.getAttribute("caseDetail");
		form.setProjectId(detail.getProjectId());
		form.setCaseId(detail.getCaseId());
		CaseDetail result = subprojectService.deleteSubprojectSearch(form);
		mav.addObject("searchSubprojectList", result);
		return mav;
	}

	// 詳細じかとび
	@RequestMapping(value = "/subProjectDetail2", method = RequestMethod.GET)
	public String subProjectDetail2(@ModelAttribute("form") SubprojectForm form, Model model) {
		// model.addAttribute("checkItems",
		// CheckBoxItemConfig.PREMISSION_ITEMS);
		System.out.println("testtttt");
		return "/subproject/subProjectDetail2";
	}

}