package jp.co.ccube.ss.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.UsersDao;
import jp.co.ccube.ss.entity.Users;
import jp.co.ccube.ss.form.RegistForm;

@Service
public class UserRegistService {
	@Autowired
	private UsersDao usersDao;

	public void addUser(RegistForm registForm){

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

	}

}
