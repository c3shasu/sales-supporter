package jp.co.ccube.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.EmployeeDao;
import jp.co.ccube.ss.entity.Employee;

@Service
public class EmployeeListService {
	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> search(String employeeNo, String name, String dept){
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
}