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

	@RequestMapping(value = "/chargeEdit", method = RequestMethod.POST)
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

}
