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
public class ChargeDeleteController extends AbstractController {
	@Autowired
	ChargeService chargeService;

	// 削除確認画面に遷移
	@RequestMapping(value = "/chargeDelete", method = RequestMethod.GET)
	public String chargeDelete(ModelAndView mav, @ModelAttribute("form") ChargeForm form, Model model) {
		model.addAttribute("form", chargeService.editChargeSearch(form));
		return "/charge/chargeDeleteCheck";
	}

	@RequestMapping(value = "/chargeDeleteConfirm", method = RequestMethod.POST)
	public String chargeDeletec(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model)
			throws ParseException {
		chargeService.chargeDelete(form);
		return "/charge/chargeDeleteConfirm";
	}

}
