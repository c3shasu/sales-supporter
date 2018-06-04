package jp.co.ccube.ss.controller.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ccube.ss.controller.AbstractController;

@Controller
public class UserConfirmController extends AbstractController {

	/**
	 * ユーザ登録完了画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping("/userConfirm")
	public String userConfirm() {
		return "management/userConfirm";
	}

}
