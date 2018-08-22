package jp.co.ccube.ss.controller.dispatch;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.form.CaseDispatchEngineerForm;
import jp.co.ccube.ss.form.ChargeForm;
import jp.co.ccube.ss.service.DispatchService;

@Controller
public class DispatchRegistController {

	@Autowired
	DispatchService dispatchService;

	@RequestMapping(value = "/dispatchRegist", method = RequestMethod.GET)
	public String userList(@ModelAttribute("form") CaseDispatchEngineerForm form, Model model) throws ParseException {

		return "dispatch/dispatchRegist";
	}

	@RequestMapping(value = "/engineerRegist", params = "back", method = RequestMethod.POST)
	public String chargeEditBack(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model) {
		return "/subproject/subProjectDetailA";
	}
}
