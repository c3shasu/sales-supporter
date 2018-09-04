package jp.co.ccube.ss.controller.project;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.form.ChargeForm;
import jp.co.ccube.ss.form.ProjectForm;
import jp.co.ccube.ss.service.ProjectService;

@Controller
public class ProjectEditController {

	@Autowired
	ProjectService projectService;

	// 検索画面へ戻る
	@RequestMapping(value = "/projectEdit", params = "back", method = RequestMethod.POST)
	public String chargeRregistBack(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model) {
		return "subproject/subProjectList";
	}

	// マスタ更新処理
	@RequestMapping(value = "/projectEdit", params = "confirm", method = RequestMethod.POST)
	public String projectEditConfirm(@ModelAttribute("form") @Valid ProjectForm form, BindingResult result, Model model) {
		// if (result.hasErrors()) {
		// for (FieldError err : result.getFieldErrors()) {
		// log.debug("error code = [" + err.getCode() + "]");
		// }
		// return "entrusted/entrustedEdit";
		// }
		projectService.editProject(form);
		// System.out.println(form.getProject_id());
		return "/project/projectConfirm";
	}

}
