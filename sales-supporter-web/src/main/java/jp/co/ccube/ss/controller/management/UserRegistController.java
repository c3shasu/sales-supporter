package jp.co.ccube.ss.controller.management;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

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
import jp.co.ccube.ss.form.ManagementForm;
import jp.co.ccube.ss.service.UserRegistService;

@Controller
public class UserRegistController extends AbstractController {

@Autowired
UserRegistService userRegistService;

	private static final Logger log = LoggerFactory.getLogger(UserRegistController.class);

	//チェックボックスの設定
	final static Map<String, Integer> CHECK_ITEMS =
		    Collections.unmodifiableMap(new LinkedHashMap<String, Integer>() {
		    {
		      put("管理職", 8);
		      put("企画開発部", 4);
		      put("営業部", 2);
		      put("総務部", 1);
		    }
		  });

	/**
	 * ユーザ登録画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/userRegist", method = RequestMethod.GET)
	public String dispCheck(@ModelAttribute("form") ManagementForm form, Model model){
		model.addAttribute("checkItems", CHECK_ITEMS);
		return "management/userRegist";
	}

	@RequestMapping(value = "/userConfirm", method = RequestMethod.POST)
	public String postCheck(@ModelAttribute("form") @Valid ManagementForm form, BindingResult result, Model model) {
		//エラー表示判定
		if(result.hasErrors()){
			for(FieldError err: result.getFieldErrors()) {
                log.debug("error code = [" + err.getCode() + "]");
            }
			model.addAttribute("checkItems", CHECK_ITEMS);
			return  "management/userRegist";
		}
		userRegistService.addUser(form);
		model.addAttribute("accountId", form.getAccountId());
		return "management/userConfirm";
	}
}
