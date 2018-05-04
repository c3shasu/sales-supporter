package jp.co.ccube.ss.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ccube.ss.controller.AbstractController;

@Controller
public class LoginController extends AbstractController {

	/**
	 * ログイン画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}

}
