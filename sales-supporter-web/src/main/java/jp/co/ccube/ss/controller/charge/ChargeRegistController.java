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

	@RequestMapping(value = "/chargeRegistConfirm", method = RequestMethod.POST)
	public String chargeRregistConfirm(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model)
			throws ParseException {
		// if (result.hasErrors()) {
		// for (FieldError err : result.getFieldErrors()) {
		// log.debug("error code = [" + err.getCode() + "]");
		// }
		// return "entrusted/entrustedEdit";
		// }
		System.out.println("test2");
		chargeService.registCharge(form);
		// System.out.println(form.getProject_id());
		return "charge/chargeConfirm";
	}

}
