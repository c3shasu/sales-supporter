package jp.co.ccube.ss.controller.resource;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.entity.Employee;
import jp.co.ccube.ss.form.EmployeeRegistForm;
import jp.co.ccube.ss.service.EmployeeListService;

@Controller
public class EmployeeListController extends AbstractController {
	@Autowired
	EmployeeListService employeelistservice;

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String employeeList(@ModelAttribute("form") EmployeeRegistForm registForm, Model model){
		return "resource/employeeList";
	}

	@RequestMapping(value = "/employeeList", method = RequestMethod.POST)
	public ModelAndView employeeSearch(ModelAndView mav,  @ModelAttribute("form")  EmployeeRegistForm form) {

		mav.setViewName("resource/employeeList");

		if(Pattern.compile("^[0-9]*$").matcher(form.getEmployeeNo()).find())
		{
			List<Employee> mavresult = employeelistservice.search(form.getEmployeeNo(), form.getName(), form.getDepartment());
			mav.addObject("serachEmployeeList",mavresult);
			return mav;
		}else{
			return mav;
		}


	}

}
