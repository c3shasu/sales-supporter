package jp.co.ccube.ss.controller.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import jp.co.ccube.ss.dao.UsersDao;
import jp.co.ccube.ss.entity.Users;
import jp.co.ccube.ss.form.RegistForm;

@Controller
public class UserRegistController extends AbstractController {

	@Autowired
	private UsersDao usersDao;

	private static final Logger log = LoggerFactory.getLogger(UserRegistController.class);

	/**
	 * ユーザ登録画面初期表示
	 *
	 * @return テンプレートパス
	 */

	@RequestMapping("/userRegist")
	public String userRegist() {
		return "management/userRegist";
	}

	@RequestMapping(value = "/userRegist", method = RequestMethod.GET)
	public String dispCheck(@ModelAttribute("form") RegistForm registForm, BindingResult result, Model model){
		return "management/userRegist";
	}



	@RequestMapping(value = "/userConfirm", method = RequestMethod.POST)
	public String postCheck(@ModelAttribute("form") @Valid RegistForm registForm, BindingResult result, Model model) {

		if(result.hasErrors()){
			for(FieldError err: result.getFieldErrors()) {
                log.debug("error code = [" + err.getCode() + "]");
            }
			return  "management/userRegist";
		}

		model.addAttribute("accountId", registForm.getAccountId());

		Users users = new Users();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = sdf.format(cal.getTime());
        try{
        	date = sdf.parse(strDate);
        } catch(ParseException e) {
        	e.printStackTrace();
        }

        cal.setTime(date);
		cal.add(Calendar.DATE, 180);

		users.setAccountId(registForm.getAccountId());
		users.setDepartment(registForm.getDepartment());
		users.setPosition(registForm.getPosition());
		users.setName(registForm.getName());
		users.setTelephone(registForm.getTel());
		users.setMailAddress(registForm.getMail());
		users.setPassword(registForm.getPassword());
		users.setPasswordLimit(cal.getTime());
		users.setPermission(registForm.getPermission());

		usersDao.insertSelective(users);

		return "management/userConfirm";
	}


}
