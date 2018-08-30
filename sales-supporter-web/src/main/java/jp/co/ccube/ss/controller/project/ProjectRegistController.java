package jp.co.ccube.ss.controller.project;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.form.ProjectForm;
import jp.co.ccube.ss.service.ProjectService;

@Controller
public class ProjectRegistController extends AbstractController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/projectRegist", method = RequestMethod.GET)
	public String projectRegist(@ModelAttribute("form") ProjectForm form, Model model)throws ParseException {
		// model.addAttribute("checkItems", CheckBoxItemConfig.ROLE_ITEMS);
		return "project/projectRegist";
	}

	// 案件担当者の登録処理
	@RequestMapping(value = "/projectRegistConfirm", params = "confirm", method = RequestMethod.POST)
	public String projectRregistConfirm(@ModelAttribute("form") ProjectForm form, BindingResult result, Model model)
			throws ParseException {
		// if (result.hasErrors()) {
		// for (FieldError err : result.getFieldErrors()) {
		// log.debug("error code = [" + err.getCode() + "]");
		// }
		// return "entrusted/entrustedEdit";
		// }
		projectService.registProject(form);
		// System.out.println(form.getProject_id());
		return "project/projectConfirm";
	}

}
