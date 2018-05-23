package jp.co.ccube.ss.controller.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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

	/**
	 * ユーザ登録画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/userRegist", method = RequestMethod.GET)
	public String dispCheck(@ModelAttribute("form") RegistForm registForm, Model model){

		model.addAttribute("checkItems", CHECK_ITEMS);
		return "management/userRegist";
	}

	@RequestMapping(value = "/userConfirm", method = RequestMethod.POST)
	public String postCheck(@ModelAttribute("form") @Valid RegistForm registForm, BindingResult result, Model model) {

		//エラー表示判定
		if(result.hasErrors()){
			for(FieldError err: result.getFieldErrors()) {
                log.debug("error code = [" + err.getCode() + "]");
            }
			model.addAttribute("checkItems", CHECK_ITEMS);
			return  "management/userRegist";
		}

		model.addAttribute("accountId", registForm.getAccountId());

		//権限の取得
		int permission = 0;
		for ( int data: registForm.getPermission()) {
			permission += data;
		}

		//パスワード有効期限の設定
		int addDate = 180;
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
		cal.add(Calendar.DATE, addDate);

		//DBアクセス
		Users users = new Users();

		users.setAccountId(registForm.getAccountId());
		users.setDepartment(registForm.getDepartment());
		users.setPosition(registForm.getPosition());
		users.setName(registForm.getName());
		users.setTelephone(registForm.getTel());
		users.setMailAddress(registForm.getMail());
		users.setPassword(registForm.getPassword());
		users.setPasswordLimit(cal.getTime());
		users.setPermission(permission);

		usersDao.insertSelective(users);



		return "management/userConfirm";
	}
}
