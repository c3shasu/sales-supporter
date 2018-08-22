package jp.co.ccube.ss.controller.engineer;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.form.CaseDispatchEngineerForm;

@Controller
public class EngineerRegistConfirmController {
	@RequestMapping(value = "/engineerConfirm", method = RequestMethod.POST)
	public String userList(@ModelAttribute("form") CaseDispatchEngineerForm form,BindingResult result, Model model) throws ParseException {

		return "subProject/subProjectDetailA";
	}
}
