package jp.co.ccube.ss.controller.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.config.CheckBoxItemConfig;
import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.entity.Users;
import jp.co.ccube.ss.form.ManagementForm;
import jp.co.ccube.ss.service.ManagementService;

@Controller
public class UserListController extends AbstractController {

	@Autowired
	ManagementService managementService;

	/**
	 * ユーザ一覧画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userList(@ModelAttribute("form") ManagementForm form, Model model) {
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		return "management/userList";
	}

	// 検索処理
	@RequestMapping(value = "/userSearch", params = "search", method = RequestMethod.POST)
	public ModelAndView search(ModelAndView mav, @ModelAttribute("form") ManagementForm form, Model model) {

		mav.setViewName("/management/userList");
		List<Users> result = managementService.searchUser(form);
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		mav.addObject("serachUserList", result);
		return mav;
	}

	// 削除処理
	@RequestMapping(value = "/userSearch", params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, @ModelAttribute("form") ManagementForm form, Model model) {
		// 削除対象確認
		if (form.getCheck().length != 0) {
			managementService.deleteUser(form);
		}
		mav.setViewName("/management/userList");
		List<Users> result = managementService.searchUser(form);
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		mav.addObject("serachUserList", result);
		return mav;
	}

	 //変更画面遷移処理
	 @RequestMapping(value = "/userSearch", params = "edit", method = RequestMethod.POST)
	 public String userEdit(ModelAndView mav, @ModelAttribute("form") ManagementForm form, Model model) {
	if (form.getCheck().length != 1) {
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		return "management/userList";
	}

	model.addAttribute("form",managementService.editUserSearch(form));
	model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
	 return "management/userEdit";
	 }

}
