package jp.co.ccube.ss.controller.charge;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.form.ChargeForm;
import jp.co.ccube.ss.service.ChargeService;

@Controller
public class ChargeEditContoller extends AbstractController {
	@Autowired
	ChargeService chargeService;

	// 編集画面遷移処理
	@RequestMapping(value = "/chargeSearch", method = RequestMethod.GET)
	public String chargeEdit(ModelAndView mav, @ModelAttribute("form") ChargeForm form, Model model) {
		model.addAttribute("form", chargeService.editChargeSearch(form));
		return "/charge/chargeEdit";
	}

	// 案件担当者更新画面の戻るボタン
	@RequestMapping(value = "/chargeEdit", params = "back", method = RequestMethod.POST)
	public String chargeEditBack(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model) {
		return "/subproject/subProjectDetail2";
	}

	// 案件担当者更新処理
	@RequestMapping(value = "/chargeEdit", params = "confirm", method = RequestMethod.POST)
	public String chargeEditConfirm(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model)
			throws ParseException {
		// if (result.hasErrors()) {
		// for (FieldError err : result.getFieldErrors()) {
		// log.debug("error code = [" + err.getCode() + "]");
		// }
		// return "entrusted/entrustedEdit";
		// }
		chargeService.editCharge(form);
		// System.out.println(form.getProject_id());
		return "/charge/chargeConfirm";
	}

	// 案件担当者更新完了画面の案件詳細へボタン
	@RequestMapping(value = "/chargeConfirm", method = RequestMethod.POST)
	public String chargeConfirm(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model) {
		return "/subproject/subProjectDetail2";
	}

}
