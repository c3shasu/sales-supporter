package jp.co.ccube.ss.controller.resource;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.form.EmployeeForm;
import jp.co.ccube.ss.service.EmployeeService;

@Controller
public class EmployeeRegistController extends AbstractController {

	@Autowired
	EmployeeService employeeregistservice;

	private static final Logger log = LoggerFactory.getLogger(EmployeeRegistController.class);

	/**
	 * 社員登録画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/employeeRegist", method = RequestMethod.GET)
	public String dispCheck(@ModelAttribute("form") EmployeeForm registForm, Model model) {
		return "resource/employeeRegist";

	}

	@RequestMapping(value = "/employeeConfirm", method = RequestMethod.POST)
	public String postCheck(@ModelAttribute("form") @Valid EmployeeForm registForm, BindingResult result, Model model) {

		// エラー表示判定
		if (result.hasErrors()) {
			for (FieldError err : result.getFieldErrors()) {
				log.debug("error code = [" + err.getCode() + "]");
			}
			return "resource/employeeRegist";
		}
		employeeregistservice.addEmployee(registForm);
		model.addAttribute("employeeNo", registForm.getEmployeeNo());
		return "resource/employeeConfirm";
	}

}
