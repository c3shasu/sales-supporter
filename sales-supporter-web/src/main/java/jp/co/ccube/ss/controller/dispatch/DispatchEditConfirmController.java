package jp.co.ccube.ss.controller.dispatch;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.entity.Dispatch;
import jp.co.ccube.ss.form.DispatchForm;
import jp.co.ccube.ss.service.DispatchService;
@Controller
public class DispatchEditConfirmController {
	@Autowired

	DispatchService dispatchService;
	@RequestMapping(value = "/dispatchEditConfirm", method = RequestMethod.POST)
	public String userList(@ModelAttribute("form") DispatchForm form, Model model,Dispatch dispatch) throws ParseException {
		// 正常系

		return "subProject/subProjectDetailA";
	}
}
