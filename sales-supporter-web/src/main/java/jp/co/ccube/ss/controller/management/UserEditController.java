package jp.co.ccube.ss.controller.management;

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

import jp.co.ccube.ss.config.CheckBoxItemConfig;
import jp.co.ccube.ss.form.ManagementForm;
import jp.co.ccube.ss.service.ManagementService;

@Controller
public class UserEditController {

	@Autowired
	ManagementService managementService;

	private static final Logger log = LoggerFactory.getLogger(UserRegistController.class);

	/**
	 * ユーザ変更画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/userEdit", method = RequestMethod.GET)
	public String userRegist(@ModelAttribute("form") ManagementForm form, Model model) {
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		return "management/userEdit";
	}

	@RequestMapping(value = "/userEditConfirm", method = RequestMethod.POST)
	public String registCheck(@ModelAttribute("form") @Valid ManagementForm form, BindingResult result, Model model) {
		// エラー表示判定
		if (result.hasErrors()) {
			for (FieldError err : result.getFieldErrors()) {
				log.debug("error code = [" + err.getCode() + "]");
			}
			model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
			return "management/userEdit";
		}
		managementService.addUser(form);
		model.addAttribute("accountId", form.getAccountId());
		return "management/userConfirm";
	}
}
