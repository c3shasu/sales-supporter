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

import jp.co.ccube.ss.form.EngineerForm;
import jp.co.ccube.ss.service.EngineerService;

@Controller
public class EngineerEditController {
	@Autowired
	EngineerService engineerService;
	@RequestMapping(value = "/engineerEdit", method = RequestMethod.GET)
		public String EngineerEdit(@ModelAttribute("form")@Valid  EngineerForm form, BindingResult result,Model model) throws ParseException {

		engineerService.editEngineerSearch(form);
			return "engineer/engineerDetailEdit";
	}
}
