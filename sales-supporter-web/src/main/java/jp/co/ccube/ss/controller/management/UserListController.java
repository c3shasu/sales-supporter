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
import jp.co.ccube.ss.service.UserListService;

@Controller
public class UserListController extends AbstractController {

	@Autowired
	UserListService userListService;

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userList(@ModelAttribute("form") ManagementForm registForm, Model model){
		model.addAttribute("checkItems", CheckBoxItemConfig.PREMISSION_ITEMS);
		return "management/userList";
	}

	@RequestMapping(value = "/userSearch", method = RequestMethod.POST)
	public ModelAndView search(ModelAndView mav, @ModelAttribute("form") ManagementForm form) {
		mav.setViewName("/management/userList");
		List<Users> result = userListService.search(form.getAccountId(), form.getName(), form.getDepartment());
		mav.addObject("serachUserList",result);
		return mav;
	}

}
