package jp.co.ccube.ss.controller.entrusted;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.form.EntrustedForm;
import jp.co.ccube.ss.service.EntrustedService;

@Controller
public class EntrustedRegistController extends AbstractController {
	@Autowired
	EntrustedService entrustedService;

	// 登録画面に遷移
	@RequestMapping(value = "/entrustedRegist", method = RequestMethod.GET)
	public String etrustedRegist(@ModelAttribute("form") EntrustedForm form, Model model) throws ParseException {
		return "entrusted/entrustedRegist";
	}

	@RequestMapping(value = "/entrustedConfirm", method = RequestMethod.POST)
	public String entrustedRegistConfirm(@ModelAttribute("form") EntrustedForm form, BindingResult result, Model model)
			throws ParseException {
		// if (result.hasErrors()) {
		// for (FieldError err : result.getFieldErrors()) {
		// log.debug("error code = [" + err.getCode() + "]");
		// }
		// return "entrusted/entrustedEdit";
		// }
		System.out.println("test");
		entrustedService.registEntrusted(form);
		// System.out.println(form.getProject_id());
		return "entrusted/entrustedConfirm";

	}
}
