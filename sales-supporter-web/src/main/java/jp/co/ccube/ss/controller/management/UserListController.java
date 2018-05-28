package jp.co.ccube.ss.controller.management;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.entity.Users;
import jp.co.ccube.ss.form.ManagementForm;
import jp.co.ccube.ss.service.UserListService;

@Controller
public class UserListController extends AbstractController {

	@Autowired
	UserListService userListService;

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

	@RequestMapping("/userList")
	public String userList(@ModelAttribute("form") ManagementForm registForm, Model model){
		model.addAttribute("checkItems", CHECK_ITEMS);
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
