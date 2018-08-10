package jp.co.ccube.ss.controller.engineer;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.form.DispatchForm;

@Controller
public class EngineerSearchController {

	@RequestMapping(value = "/engineerBpSearch", method = RequestMethod.GET)
	public String userList(@ModelAttribute("form") DispatchForm form, Model model) throws ParseException {

		return "engineer/engineerBpSearch";
	}

	@RequestMapping(value = "/engineerEmployeeSearch", method = RequestMethod.GET)
	public String List(@ModelAttribute("form") DispatchForm form, Model model) throws ParseException {

		return "engineer/engineerEmployeeSearch";
	}
}
