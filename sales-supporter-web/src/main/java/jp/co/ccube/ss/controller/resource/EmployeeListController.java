package jp.co.ccube.ss.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.login.NonSessionCheck;

@Controller
public class EmployeeListController extends AbstractController {

	/**
	 * ログイン画面初期表示
	 *
	 * @return テンプレートパス
	 */
		@NonSessionCheck
		@RequestMapping("/employeeList")
	public String employeeList() {
		return "resource/employeeList";
	}

}
