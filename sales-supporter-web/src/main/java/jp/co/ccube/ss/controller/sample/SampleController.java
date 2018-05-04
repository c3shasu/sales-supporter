package jp.co.ccube.ss.controller.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.dao.UsersDao;
import jp.co.ccube.ss.entity.Users;

@Controller
public class SampleController extends AbstractController {

	@Autowired
	UsersDao usersDao;

	/**
	 * [サンプル] はろー画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "sample/hello";
	}

	/**
	 * [サンプル] input画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping("/input")
	public String input() {
		return "sample/input";
	}

	/**
	 * [サンプル]sendボタン押下時処理
	 * <p>
	 * <ul>
	 * <li>画面からのパラメータ：param の値をキーに{@link usersDao#selectByPrimaryKey(String)
	 * ユーザ情報を検索する。}</li>
	 * <li>検索した結果を{@link Model#addAttribute(String, Object)
	 * 画面に受け渡すオブジェクトに設定する。}</li>
	 * </ul>
	 * </p>
	 *
	 * @param model Viewに渡すオブジェクト
	 * @param param 画面からのパラメータ：paramの値
	 * @return テンプレートパス
	 */
	@Transactional
	@RequestMapping(value = "/send", params = "send", method = RequestMethod.POST)
	public String send(Model model, @RequestParam("param") String param) {
		Users userInfo = usersDao.selectByPrimaryKey(param);
		if(userInfo != null){
			model.addAttribute("result", userInfo.getName());
		}else{
			model.addAttribute("result", "");
		}
		return "sample/result";
	}

	/**
	 * [サンプル]戻るボタン押下時処理
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/test", params = "back")
	public String back() {
		return "sample/input";
	}

}
