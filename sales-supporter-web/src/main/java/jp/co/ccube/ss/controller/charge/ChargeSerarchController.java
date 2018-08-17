package jp.co.ccube.ss.controller.charge;

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
import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.entity.Employee;
import jp.co.ccube.ss.entity.ResultClient;
import jp.co.ccube.ss.form.ClientForm;
import jp.co.ccube.ss.form.EmployeeForm;
import jp.co.ccube.ss.service.ClientService;
import jp.co.ccube.ss.service.EmployeeService;

@Controller
public class ChargeSerarchController extends AbstractController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	ClientService clientService;

	// BP
	@RequestMapping(value = "/chargeBpSearch", method = RequestMethod.GET)
	public String chargeBpSearch(@ModelAttribute("form") ClientForm form, Model model) {
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
		return "charge/chargeBpSearch";
	}

	@RequestMapping(value = "/chargeBpSearch", params = "search", method = RequestMethod.POST)
	public ModelAndView clientSearch(ModelAndView mav, @ModelAttribute("form") ClientForm form, Model model) {
		mav.setViewName("charge/chargeBpSearch");
		List<ResultClient> result = clientService.searchClient(form);
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
		clientService.typeNameMapping(result);
		mav.addObject("serachClientList", result);
		return mav;
	}

	// 社員
	@RequestMapping(value = "/chargeEmployeeSearch", method = RequestMethod.GET)
	public String chargeEmployeeSearch(@ModelAttribute("form") EmployeeForm form, Model model) {
		return "charge/chargeEmployeeSearch";
	}

	@RequestMapping(value = "/chargeEmployeeSearch", method = RequestMethod.POST)
	public ModelAndView employeeSearch(ModelAndView mav, @ModelAttribute("form") EmployeeForm form) {
		mav.setViewName("charge/chargeEmployeeSearch");

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
