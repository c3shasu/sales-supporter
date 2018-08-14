package jp.co.ccube.ss.controller.dispatch;

import java.text.ParseException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.form.DispatchForm;
import jp.co.ccube.ss.service.DispatchService;

@Controller
public class DispatchEditController {

	@Autowired
	DispatchService dispatchService;

	private static final Logger log = LoggerFactory.getLogger(DispatchEditController.class);

	@RequestMapping(value = "/dispatchEdit", method = RequestMethod.GET)
	public String DispatchEdit(@ModelAttribute("form")@Valid  DispatchForm form, BindingResult result,Model model) throws ParseException {

		// 正常系
			dispatchService.editDispatchSearch(form);
		return "dispatch/dispatchEdit";
	}
	@RequestMapping(value = "/dispatchConfirm", method = RequestMethod.POST)
	public String DispatchEditConfirm(@ModelAttribute("form")@Valid  DispatchForm form, BindingResult result,Model model) throws ParseException {
		// 正常系
				dispatchService.editDispatch(form);
				return "dispatch/dispatchEditConfirm";
	}
}
