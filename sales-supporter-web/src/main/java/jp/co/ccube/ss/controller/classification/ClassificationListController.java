package jp.co.ccube.ss.controller.classification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.entity.MClassification;
import jp.co.ccube.ss.form.ClassificationForm;
import jp.co.ccube.ss.service.ClassificationService;

@Controller
public class ClassificationListController {
	@Autowired
	ClassificationService classificationService;

	// マスタ検索画面に遷移
	@RequestMapping(value = "/classification", method = RequestMethod.GET)
	public String classificationList(@ModelAttribute("form") ClassificationForm form, Model model) {
		return "classification/classificationList";
	}

	// 検索処理
	@RequestMapping(value = "/classificationList", params = "search", method = RequestMethod.POST)
	public ModelAndView classificationSearch(ModelAndView mav, @ModelAttribute("form") ClassificationForm form,
			Model model) {

		mav.setViewName("/classification/classificationList");
		List<MClassification> result = classificationService.search(form);
		// model.addAttribute("checkItems",
		// CheckBoxItemConfig.PREMISSION_ITEMS);
		mav.addObject("serachClassificationList", result);
		return mav;
	}

	// 編集画面遷移処理
	@RequestMapping(value = "/classificationList", params = "edit", method = RequestMethod.POST)
	public String classficationEdit(ModelAndView mav, @ModelAttribute("form") ClassificationForm form, Model model) {
		// チェックボックスに一個のチェックがある時だけ編集画面に遷移
		if (form.getCheck().length != 1) {
			// model.addAttribute("checkItems",
			// CheckBoxItemConfig.CLIENTTYPE_ITEMS);
			return "/classification/classificationList";
		}
		String[] codeId = form.getCheck();
		String[] idCode = codeId[0].split(" ", 0);
		String code = idCode[0];
		System.out.println(idCode[1].length());
		Integer id = Integer.parseInt(idCode[1], 2);
		form.setClassificationCode(code);
		form.setClassificationId(id);
		model.addAttribute("form", classificationService.classificationSearch(form));
		// model.addAttribute("checkItems",
		// CheckBoxItemConfig.CLIENTTYPE_ITEMS);

		return "/classification/classificationEdit";
	}

	// 削除確認画面遷移処理
	@RequestMapping(value = "/classificationList", params = "delete", method = RequestMethod.POST)
	public String classificationDelete(ModelAndView mav, @ModelAttribute("form") ClassificationForm form, Model model) {
		// チェックボックスに一個のチェックがある時だけ編集画面に遷移
		if (form.getCheck().length != 1) {
			// model.addAttribute("checkItems",
			// CheckBoxItemConfig.CLIENTTYPE_ITEMS);
			return "/classification/classificationList";
		}
		String[] codeId = form.getCheck();
		String[] idCode = codeId[0].split(" ", 0);
		String code = idCode[0];
//		System.out.println(idCode[1].length());
		Integer id = Integer.parseInt(idCode[1], 2);
		form.setClassificationCode(code);
		form.setClassificationId(id);
		System.out.println(id);
		model.addAttribute("form", classificationService.classificationSearch(form));
		return "/classification/classificationDeleteCheck";
	}
}
