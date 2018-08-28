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

	// 案件担当者登録画面に遷移
	@RequestMapping(value = "/classificationList", method = RequestMethod.GET)
	public String classificationList(@ModelAttribute("form") ClassificationForm form, Model model) {
		return "classification/classificationList";
	}

	// 検索処理
	@RequestMapping(value = "/classificationList", params = "search", method = RequestMethod.POST)
	public ModelAndView projectSearch(ModelAndView mav, @ModelAttribute("form") ClassificationForm form, Model model) {

		mav.setViewName("/classification/classificationList");
		List<MClassification> result = classificationService.search(form);
		// model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		mav.addObject("serachClassificationList", result);
		return mav;
	}
}
