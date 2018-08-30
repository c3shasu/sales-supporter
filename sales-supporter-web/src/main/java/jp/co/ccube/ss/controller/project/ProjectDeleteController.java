package jp.co.ccube.ss.controller.project;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.form.ProjectForm;
import jp.co.ccube.ss.service.ProjectService;

@Controller
public class ProjectDeleteController {
	@Autowired
	ProjectService projectService;

	// 編集画面遷移処理
//	@RequestMapping(value = "/projectD", method = RequestMethod.GET)
//	public String projectEdit(ModelAndView mav, @ModelAttribute("form") ProjectForm form, Model model) {
//		model.addAttribute("form", projectService.projectSearch(form));
//		return "/project/projectDeleteCheck";
//	}

	// プロジェクト削除処理
	@RequestMapping(value = "/projectDeleteConfirm", params = "confirm", method = RequestMethod.POST)
	public String projectDelete(@ModelAttribute("form") @Valid ProjectForm form, BindingResult result, Model model) {
		System.out.println(form);
		projectService.deleteProject(form);
		return "/project/projectDeleteConfirm";
	}

}
