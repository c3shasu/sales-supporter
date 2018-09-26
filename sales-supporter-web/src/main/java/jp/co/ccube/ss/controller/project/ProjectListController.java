package jp.co.ccube.ss.controller.project;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.entity.Project;
import jp.co.ccube.ss.form.ProjectForm;
import jp.co.ccube.ss.service.ProjectService;

@Controller
public class ProjectListController extends AbstractController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String projectList(@ModelAttribute("form") ProjectForm form, Model model) throws ParseException {
		// model.addAttribute("checkItems", CheckBoxItemConfig.ROLE_ITEMS);
		return "project/projectList";
	}

	// 検索処理
	@RequestMapping(value = "/projectList", params = "search", method = RequestMethod.POST)
	public ModelAndView projectSearch(ModelAndView mav, @ModelAttribute("form") ProjectForm form, Model model) {

		mav.setViewName("/project/projectList");
		List<Project> result = projectService.search(form);
		// model.addAttribute("checkItems",
		// CheckBoxItemConfig.PREMISSION_ITEMS);
		System.out.println(result.get(0).getCompanyName());
		mav.addObject("serachProjectList", result);
		return mav;
	}

	// 編集画面遷移処理
	@RequestMapping(value = "/projectList", params = "edit", method = RequestMethod.POST)
	public String projectEdit(ModelAndView mav, @ModelAttribute("form") ProjectForm form, Model model) {
		// チェックボックスに一個のチェックがある時だけ編集画面に遷移
		if (form.getCheck().length != 1) {
			// model.addAttribute("checkItems",
			// CheckBoxItemConfig.CLIENTTYPE_ITEMS);
			return "/project/projectList";
		}
		model.addAttribute("form", projectService.projectSearch(form));
		// model.addAttribute("checkItems",
		// CheckBoxItemConfig.CLIENTTYPE_ITEMS);

		return "/project/projectEdit";
	}

	// 削除画面遷移処理
	@RequestMapping(value = "/projectList", params = "delete", method = RequestMethod.POST)
	public String projectDelete(ModelAndView mav, @ModelAttribute("form") ProjectForm form, Model model) {
		// チェックボックスに一個のチェックがある時だけ編集画面に遷移
		if (form.getCheck().length != 1) {
			// model.addAttribute("checkItems",
			// CheckBoxItemConfig.CLIENTTYPE_ITEMS);
			return "/project/projectList";
		}
		model.addAttribute("form", projectService.projectSearch(form));
		// model.addAttribute("checkItems",
		// CheckBoxItemConfig.CLIENTTYPE_ITEMS);

		return "/project/projectDeleteCheck";
	}

	// 詳細画面遷移処理
	@RequestMapping(value = "/projectList", params = "detail", method = RequestMethod.POST)
	public String projectDetail(ModelAndView mav, @ModelAttribute("form") ProjectForm form, Model model) {
		// チェックボックスに一個のチェックがある時だけ編集画面に遷移
		if (form.getCheck().length != 1) {
			// model.addAttribute("checkItems",
			// CheckBoxItemConfig.CLIENTTYPE_ITEMS);
			return "/project/projectList";
		}
		model.addAttribute("form", projectService.projectDetail(form));

		// model.addAttribute("checkItems",
		// CheckBoxItemConfig.CLIENTTYPE_ITEMS);

		return "/project/projectDetails";
	}

}
