package jp.co.ccube.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HTTPエラー用コントローラクラス
 */
@Controller
public class HttpErrorController extends AbstractController {

	/**
	 * 403エラー画面表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping("/403")
	public String forbiddenError() {
		return "error/403";
	}

	/**
	 * 404エラー画面表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping("/404")
	public String notFoundError() {
		return "error/404";
	}

	/**
	 * 500エラー画面表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping("/500")
	public String internalServerError() {
		return "error/500";
	}
}
