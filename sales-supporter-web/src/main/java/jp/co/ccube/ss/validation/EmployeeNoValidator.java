package jp.co.ccube.ss.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.ccube.ss.dao.EmployeeDao;

public class EmployeeNoValidator implements ConstraintValidator<EmployeeNoValid, String> {

	private EmployeeNoValid my;
	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public void initialize(EmployeeNoValid annotation) {
		// TODO 自動生成されたメソッド・スタブ
		this.my = annotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		// TODO 自動生成されたメソッド・スタブ
		if ( !value.isEmpty() ) {
			int cnt = employeeDao.countByPrimaryKey(Integer.parseInt(value));
			if ( cnt > 0 ) {
				return false;
			}
		}
		return true;
	}
}