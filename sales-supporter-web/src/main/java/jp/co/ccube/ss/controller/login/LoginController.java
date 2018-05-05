package jp.co.ccube.ss.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.login.NonSessionCheck;

@Controller
public class LoginController extends AbstractController {

	/**
	 * ログイン画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@NonSessionCheck
	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}

}
