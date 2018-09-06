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
public class ClassificationEditController {
	@Autowired
	ClassificationService classificationService;

	// 検索画面へ戻る
	@RequestMapping(value = "/classificationEdit", params = "back", method = RequestMethod.POST)
	public String classificationListBack(@ModelAttribute("form") ClassificationForm form, BindingResult result, Model model) {
		return "/classification/classificationList";
	}

	// マスタ更新処理
	@RequestMapping(value = "/classificationEdit", params = "confirm", method = RequestMethod.POST)
	public String chargeEditConfirm(@ModelAttribute("form") ClassificationForm form, BindingResult result, Model model)
			throws ParseException {
		// if (result.hasErrors()) {
		// for (FieldError err : result.getFieldErrors()) {
		// log.debug("error code = [" + err.getCode() + "]");
		// }
		// return "entrusted/entrustedEdit";
		// }
		classificationService.editClassification(form);
		// System.out.println(form.getProject_id());
		return "/classification/classificationConfirm";
	}

}
