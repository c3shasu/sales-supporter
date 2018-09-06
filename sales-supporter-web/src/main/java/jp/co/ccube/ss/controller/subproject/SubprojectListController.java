package jp.co.ccube.ss.controller.subproject;

import java.util.ArrayList;
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
import jp.co.ccube.ss.entity.CaseProject;
import jp.co.ccube.ss.form.SubprojectForm;
import jp.co.ccube.ss.service.SubprojectService;

@Controller
public class SubprojectListController extends AbstractController {

	@Autowired
	SubprojectService subprojectService;

	/**
	 * ユーザ一覧画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/subProjectList", method = RequestMethod.GET)
	public String subProjectList(@ModelAttribute("form") SubprojectForm form, Model model) {
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		return "subproject/subProjectListSearch";
	}

	@RequestMapping(value = "/subProjectList", params = "search", method = RequestMethod.POST)
	public ModelAndView search(ModelAndView mav, @ModelAttribute("form") SubprojectForm form, Model model,
			HttpSession session) {

		mav.setViewName("/subproject/subProjectListSearch");
		List<CaseProject> result = subprojectService.searchCase(form);
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);

		// 検索結果の保存
		session.setAttribute("searchList", result);
		List<CaseProject> list = new ArrayList<CaseProject>();
		list = (List<CaseProject>) session.getAttribute("searchList");
		mav.addObject("result", result);
		return mav;
	}

}