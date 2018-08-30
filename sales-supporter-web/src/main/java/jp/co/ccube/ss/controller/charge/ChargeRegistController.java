package jp.co.ccube.ss.controller.charge;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.form.ChargeForm;
import jp.co.ccube.ss.service.ChargeService;

@Controller
public class ChargeRegistController extends AbstractController {
	@Autowired
	ChargeService chargeService;

	// 案件担当者登録画面に遷移
	@RequestMapping(value = "/chargeRegist", method = RequestMethod.GET)
	public String cahregeRegist(@ModelAttribute("form") ChargeForm form, Model model) throws ParseException {
		return "charge/chargeRegist";
	}

	// 案件詳細画面へ戻る
	@RequestMapping(value = "/chargeRegistConfirm", params = "back", method = RequestMethod.POST)
	public String chargeRregistBack(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model) {
		return "subproject/subProjectDetail2";
	}

	// 案件担当者の登録処理
	@RequestMapping(value = "/chargeRegistConfirm", params = "confirm", method = RequestMethod.POST)
	public String chargeRregistConfirm(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model)
			throws ParseException {
		// if (result.hasErrors()) {
		// for (FieldError err : result.getFieldErrors()) {
		// log.debug("error code = [" + err.getCode() + "]");
		// }
		// return "entrusted/entrustedEdit";
		// }
		chargeService.registCharge(form);
		// System.out.println(form.getProject_id());
		return "charge/chargeConfirm";
	}

}
