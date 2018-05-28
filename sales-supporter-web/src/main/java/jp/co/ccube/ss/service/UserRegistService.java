package jp.co.ccube.ss.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.UsersDao;
import jp.co.ccube.ss.entity.Users;
import jp.co.ccube.ss.form.ManagementForm;

@Service
public class UserRegistService {
	@Autowired
	private UsersDao usersDao;

	public void addUser(ManagementForm form){

		//権限の取得
		int permission = 0;
		for ( int data: form.getPermission()) {
			permission |= data;
		}

//		String strPremission = String.format("%8s",Integer.toBinaryString(permission)).replace(" ", "0");


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

/*
		byte[] array;
		array = new byte[1];

		ByteBuffer byteBuffer = ByteBuffer.wrap(array);
		byteBuffer.putShort(0, (short) 1);
		byteBuffer.putShort(1, (short) 0);
		byteBuffer.putShort(2, (short) 0);
		byteBuffer.putShort(3, (short) 1);
		byteBuffer.putShort(4, (short) 0);
		byteBuffer.putShort(5, (short) 0);
		byteBuffer.putShort(6, (short) 0);
		byteBuffer.putShort(7, (short) 0);
*/
		//DBアクセス
		Users users = new Users();

		users.setAccountId(form.getAccountId());
		users.setDepartment(form.getDepartment());
		users.setPosition(form.getPosition());
		users.setName(form.getName());
		users.setTelephone(form.getTel());
		users.setMailAddress(form.getMail());
		users.setPassword(form.getPassword());
		users.setPasswordLimit(cal.getTime());
		users.setPermission(permission);
//		users.setPermission(byteBuffer.get());

		usersDao.insertSelective(users);

	}

}
