package jp.co.ccube.ss.controller.subproject;

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
public class SubprojectListController extends AbstractController{

	@Autowired
	ManagementService managementService;

	/**
	 * ユーザ一覧画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/subProjectList", method = RequestMethod.GET)
	public String subProjectList(@ModelAttribute("form") ManagementForm form, Model model) {
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		return "subproject/subProjectListSearch";
	}



}