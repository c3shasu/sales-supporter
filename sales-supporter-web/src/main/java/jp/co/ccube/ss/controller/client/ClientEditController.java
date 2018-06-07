package jp.co.ccube.ss.controller.client;

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
import jp.co.ccube.ss.form.ClientForm;
import jp.co.ccube.ss.service.ClientService;

@Controller
public class ClientEditController {

	@Autowired
	ClientService clientService;

	private static final Logger log = LoggerFactory.getLogger(ClientRegistController.class);

	/**
	 * ユーザ変更画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/clientEdit", method = RequestMethod.GET)
	public String clientRegist(@ModelAttribute("form") ClientForm form, Model model){
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
		return "client/clientEdit";
	}

	@RequestMapping(value = "/clientEditConfirm", method = RequestMethod.POST)
	public String registCheck(@ModelAttribute("form") @Valid ClientForm form, BindingResult result, Model model) {
		//エラー表示判定
		if(result.hasErrors()){
			for(FieldError err: result.getFieldErrors()) {
                log.debug("error code = [" + err.getCode() + "]");
            }
			model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
			return  "client/clientEdit";
		}
		clientService.editClient(form);
		model.addAttribute("clientName", form.getClientName());
		return "client/clientConfirm";
	}

}
