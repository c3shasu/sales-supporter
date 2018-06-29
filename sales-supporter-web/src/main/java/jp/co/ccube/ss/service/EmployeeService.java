package jp.co.ccube.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.EmployeeDao;
import jp.co.ccube.ss.entity.Employee;
import jp.co.ccube.ss.form.EmployeeForm;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	// 登録
	public void addEmployee(EmployeeForm registForm) {

		Employee employee = new Employee();

		employee.setEmployeeNo(Integer.parseInt(registForm.getEmployeeNo()));
		employee.setDepartment(registForm.getDepartment());
		employee.setPosition(registForm.getPosition());
		employee.setName(registForm.getName());
		employee.setTelephone(registForm.getTel());
		employee.setMailAddress(registForm.getMail());
		employee.setCost(Integer.parseInt(registForm.getCost()));
		employee.setRole(role(registForm.getRole()));

		employeeDao.insertSelective(employee);

	}

	// 検索
	public List<Employee> search(EmployeeForm form) {
		String employeeNo = form.getEmployeeNo();
		String name = form.getName();
		String dept = form.getDepartment();

		Employee employee = new Employee();
		if (!employeeNo.isEmpty()) {
			employee.setEmployeeNo(Integer.parseInt(employeeNo));
		}
		if (!name.isEmpty()) {
			employee.setName(name);
		}
		if (!dept.isEmpty()) {
			employee.setDepartment(dept);
		}
		return employeeDao.selectByEmployee(employee);
	}

	// 役割の取得
	public int role(Integer[] role) {
		int res = 0;
		for (int data : role) {
			res += data;
		}
		return res;
	}

}
