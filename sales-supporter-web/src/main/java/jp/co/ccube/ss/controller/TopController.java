package jp.co.ccube.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ccube.ss.login.NonSessionCheck;

@Controller
public class TopController extends AbstractController {

	/**
	 * ログイン画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@NonSessionCheck
	@RequestMapping("/top")
	public String top() {
		return "top";
	}

}
