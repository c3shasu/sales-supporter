package jp.co.ccube.ss.controller.engineer;

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
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.controller.dispatch.DispatchEditController;
import jp.co.ccube.ss.form.EngineerForm;
import jp.co.ccube.ss.service.EngineerService;

@Controller
public class EngineerEditController {
	@Autowired
	EngineerService engineerService;
	private static final Logger log = LoggerFactory.getLogger(DispatchEditController.class);
	@RequestMapping(value = "/engineerEdit", method = RequestMethod.GET)
		public ModelAndView EngineerEdit(@ModelAttribute("form")@Valid  EngineerForm form, BindingResult result,ModelAndView mav,Model model) throws ParseException {

		engineerService.engineerSearch(form);
		if(form.getEmployeeNo()==null){
			mav.setViewName("engineer/engineerBpEdit");}
		mav.setViewName("engineer/engineerEmployeeEdit");
		mav.addObject("ya", form);
			return mav;
	}
	@RequestMapping(value = "/engineerEditConfirm", method = RequestMethod.POST)
	public ModelAndView EngineerEditConfirm(@ModelAttribute("form")@Valid  EngineerForm form, BindingResult result,ModelAndView mav,Model model) throws ParseException {
		engineerService.engineerUpdate(form);
		mav.setViewName("engineer/engineerEditConfirm");
		return mav;
}
}