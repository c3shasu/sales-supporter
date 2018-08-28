package jp.co.ccube.ss.controller.engineer;

import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.config.CheckBoxItemConfig;
import jp.co.ccube.ss.entity.Employee;
import jp.co.ccube.ss.entity.ResultClient;
import jp.co.ccube.ss.form.ClientForm;
import jp.co.ccube.ss.form.EmployeeForm;
import jp.co.ccube.ss.service.ClientService;
import jp.co.ccube.ss.service.EmployeeService;

@Controller
public class EngineerSearchController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	ClientService clientService;
	@RequestMapping(value = "/engineerBpSearch", method = RequestMethod.GET)
	public String userList(@ModelAttribute("form") ClientForm form, Model model) throws ParseException {
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
		return "engineer/engineerBpSearch";
	}

	@RequestMapping(value = "/engineerBpSearch", params = "search", method = RequestMethod.POST)
	public ModelAndView clientSearch(ModelAndView mav, @ModelAttribute("form") ClientForm form, Model model) {
		mav.setViewName("engineer/engineerBpSearch");
		List<ResultClient> result = clientService.searchClient(form);
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
		clientService.typeNameMapping(result);
		mav.addObject("serachClientList", result);
		return mav;
	}

	@RequestMapping(value = "/engineerEmployeeSearch", method = RequestMethod.GET)
	public String List(@ModelAttribute("form") EmployeeForm form, Model model) throws ParseException {
	return "engineer/engineerEmployeeSearch";
	}

	@RequestMapping(value = "/engineerEmployeeSearch", method = RequestMethod.POST)
	public ModelAndView employeeSearch(ModelAndView mav, @ModelAttribute("form") EmployeeForm form) {
		mav.setViewName("engineer/engineerEmployeeSearch");

		if (Pattern.compile("^[0-9]*$").matcher(form.getEmployeeNo()).find()) {
			List<Employee> mavresult = employeeService.search(form);
			// 検索件数の表示
			mav.addObject("serachEmployeeResult", mavresult.size());
			mav.addObject("serachEmployeeList", mavresult);
			return mav;
		}
		return mav;
	}
}
