package jp.co.ccube.ss.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.ccube.ss.dao.UsersDao;

public class AccountIdValidator implements ConstraintValidator<MyValid, String> {

	private MyValid my;
	@Autowired
	private UsersDao usersDao;
	@Override
	public void initialize(MyValid annotation) {
		// TODO 自動生成されたメソッド・スタブ
		this.my = annotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		// TODO 自動生成されたメソッド・スタブ
		if ( !value.isEmpty() ) {
			int cnt = usersDao.countByPrimaryKey(value);
			if ( cnt > 0 ) {
				return false;
			}
		}
		return true;
	}


}
