package jp.co.ccube.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.EmployeeDao;
import jp.co.ccube.ss.entity.Employee;
import jp.co.ccube.ss.form.EmployeeRegistForm;

@Service
public class EmployeeRegistService {
	@Autowired
	private EmployeeDao employeedao;

	public void addEmployee(EmployeeRegistForm registForm){

		//DBアクセス
		Employee employee = new Employee();

		employee.setEmployeeNo(Integer.parseInt(registForm.getEmployeeNo()));
		employee.setDepartment(registForm.getDepartment());
		employee.setPosition(registForm.getPosition());
		employee.setName(registForm.getName());
		employee.setTelephon(registForm.getTel());
		employee.setMailAddress(registForm.getMail());
		employee.setCost(Integer.parseInt(registForm.getCost()));
		employee.setRole(Integer.parseInt(registForm.getRole()));

		employeedao.insertSelective(employee);

	}

}
