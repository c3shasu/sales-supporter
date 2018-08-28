package jp.co.ccube.ss.controller.classification;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.form.ClassificationForm;
import jp.co.ccube.ss.service.ClassificationService;

@Controller
public class ClassificationRegistController {
	@Autowired
	ClassificationService classificationService;

	// 案件担当者登録画面に遷移
	@RequestMapping(value = "/classificationRegist", method = RequestMethod.GET)
	public String classificationRegist(@ModelAttribute("form") ClassificationForm form, Model model) {
		return "classification/classificationRegist";
	}

	// 案件担当者の登録処理
	@RequestMapping(value = "/classificationRegistConfirm", params = "confirm", method = RequestMethod.POST)
	public String classificationRregistConfirm(@ModelAttribute("form") ClassificationForm form, BindingResult result,
			Model model) throws ParseException {
		// if (result.hasErrors()) {
		// for (FieldError err : result.getFieldErrors()) {
		// log.debug("error code = [" + err.getCode() + "]");
		// }
		// return "entrusted/entrustedEdit";
		// }
		classificationService.registClassification(form);
		// System.out.println(form.getProject_id());
		return "classification/classificationConfirm";
	}

}
