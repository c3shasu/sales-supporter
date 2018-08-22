package jp.co.ccube.ss.controller.engineer;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.form.ChargeForm;
import jp.co.ccube.ss.form.EngineerForm;
import jp.co.ccube.ss.service.EngineerService;

@Controller
public class EngineerDeleteController {
	@Autowired
	EngineerService engineerService;

	@RequestMapping(value = "/EngineerDeleteSearch", method = RequestMethod.GET)
	public String EngineerDeleteSearch(@ModelAttribute("form")@Valid  EngineerForm form, BindingResult result,Model model) throws ParseException {
		// 正常系
		engineerService.engineerSearch(form);

		return "engineer/engineerDelete";
}
	@RequestMapping(value = "/EngineerDelete", method = RequestMethod.POST)
	public String EngineerDelete(@ModelAttribute("form")@Valid  EngineerForm form, BindingResult result,Model model) throws ParseException {
		// 正常系
		engineerService.engineerDelete(form);
		return "engineer/engineerDeleteConfirm";
}
	@RequestMapping(value = "/EngineerDelete", params = "back", method = RequestMethod.POST)
	public String chargeEditBack(@ModelAttribute("form") ChargeForm form, BindingResult result, Model model) {
		return "/subproject/subProjectDetailA";
	}
}