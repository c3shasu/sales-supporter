package jp.co.ccube.ss.controller.subProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.config.CheckBoxItemConfig;
import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.form.ManagementForm;
import jp.co.ccube.ss.service.ManagementService;

@Controller
public class SubProjectListController extends AbstractController{

	@Autowired
	ManagementService managementService;

	/**
	 * ユーザ一覧画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/subProjectListSearch", method = RequestMethod.GET)
	public String subProjectList(@ModelAttribute("form") ManagementForm form, Model model) {
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		return "sample/mockup/subproject/subProjectListSearch";
	}
	@RequestMapping(value = "/subProjectDetail", method = RequestMethod.GET)
	public String subProjectDetail(@ModelAttribute("form") ManagementForm form, Model model) {
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		return "sample/mockup/subproject/subProjectDetail";
	}




}



