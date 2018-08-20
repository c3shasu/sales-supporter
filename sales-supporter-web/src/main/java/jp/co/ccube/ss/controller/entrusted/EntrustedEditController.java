package jp.co.ccube.ss.controller.entrusted;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.form.EntrustedForm;
import jp.co.ccube.ss.service.EntrustedService;

@Controller
public class EntrustedEditController extends AbstractController {
	@Autowired
	EntrustedService entrustedService;

	// private static final Logger log =
	// LoggerFactory.getLogger(EntrustedEditController.class);

	// 編集画面遷移処理
	@RequestMapping(value = "/entrustedSearch", method = RequestMethod.GET)
	public String entrustedEdit(ModelAndView mav, @ModelAttribute("form") EntrustedForm form, Model model) {
		model.addAttribute("form", entrustedService.editEntrustedSearch(form));
		return "/entrusted/entrustedEdit";
	}

	// 案件詳細画面へ戻る
	@RequestMapping(value = "/entrustedEdit", params = "back", method = RequestMethod.POST)
	public String entrustedEditBack(@ModelAttribute("form") EntrustedForm form, BindingResult result, Model model) {
		return "subproject/subProjectDetail2";
	}

	// 受託情報更新画面
	@RequestMapping(value = "/entrustedEdit", params = "confirm", method = RequestMethod.POST)
	public String entrustedEditConfirm(@ModelAttribute("form") EntrustedForm form, BindingResult result, Model model)
			throws ParseException {
		// if (result.hasErrors()) {
		// for (FieldError err : result.getFieldErrors()) {
		// log.debug("error code = [" + err.getCode() + "]");
		// }
		// return "entrusted/entrustedEdit";
		// }
		entrustedService.editEntrusted(form);
		// System.out.println(form.getProject_id());
		return "entrusted/entrustedConfirm";
	}
}
