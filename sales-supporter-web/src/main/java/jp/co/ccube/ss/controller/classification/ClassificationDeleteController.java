package jp.co.ccube.ss.controller.classification;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.form.ClassificationForm;
import jp.co.ccube.ss.service.ClassificationService;

@Controller
public class ClassificationDeleteController {
	@Autowired
	ClassificationService classificationService;

	// 削除確認画面遷移処理
	@RequestMapping(value = "/classificationDelete", method = RequestMethod.GET)
	public String classificationEdit(ModelAndView mav, @ModelAttribute("form") ClassificationForm form, Model model) {
		model.addAttribute("form", classificationService.classificationSearch(form));
		return "/classification/classificationDeleteCheck";
	}

	// 案件担当者削除処理
	@RequestMapping(value = "/classificationDeleteConfirm", params = "confirm", method = RequestMethod.POST)
	public String classificationDelete(@ModelAttribute("form") ClassificationForm form, BindingResult result,
			Model model) throws ParseException {
		classificationService.deleteClassification(form);
		return "/classification/classificationDeleteConfirm";
	}

}
