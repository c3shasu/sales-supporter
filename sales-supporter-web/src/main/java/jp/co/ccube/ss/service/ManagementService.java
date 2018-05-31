package jp.co.ccube.ss.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.UsersDao;
import jp.co.ccube.ss.entity.Users;
import jp.co.ccube.ss.form.ManagementForm;

@Service
public class ManagementService {
	@Autowired
	private UsersDao usersDao;

	// ユーザ登録
	public void addUser(ManagementForm form) {

		// パスワード有効期限の設定
		int addDate = 180;
		Date date = new Date();
		Calendar cal = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = sdf.format(cal.getTime());

		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(date);
		cal.add(Calendar.DATE, addDate);

		Users users = new Users();

		users.setAccountId(form.getAccountId());
		users.setDepartment(form.getDepartment());
		users.setPosition(form.getPosition());
		users.setName(form.getName());
		users.setTelephone(form.getTel());
		users.setMailAddress(form.getMail());
		users.setPassword(form.getPassword());
		users.setPasswordLimit(cal.getTime());
		users.setPermission(permission(form.getPermission()));

		usersDao.insertSelective(users);

	}

	// ユーザ検索
	public List<Users> search(ManagementForm form) {

		Users users = new Users();

		String accountId = form.getAccountId();
		String name = form.getName();
		String dept = form.getDepartment();
		int per = permission(form.getPermission());

		if (!accountId.isEmpty()) {
			users.setAccountId(accountId);
		}
		if (!name.isEmpty()) {
			users.setName(name);
		}
		if (!dept.isEmpty()) {
			users.setDepartment(dept);
		}
		if (per != 0) {
			users.setPermission(per);
		}
		return usersDao.selectByUsers(users);
	}

	// 権限の取得
	public int permission(Integer[] permission) {
		int res = 0;
		for (int data : permission) {
			res |= data;
		}
		return res;
	}

}
