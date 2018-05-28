package jp.co.ccube.ss.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import jp.co.ccube.ss.validation.EmployeeNoValid;
import jp.co.ccube.ss.validation.NumberFormValid;

public class EmployeeRegistForm {

	//社員番号
	@NotNull
	@NumberFormValid
	@EmployeeNoValid
	private String employeeNo;

	//部署
	@NotEmpty
	private String department;

	//役職
	private String position;

	//氏名
	@NotEmpty
	private String name;

	//電話番号
	@NotEmpty
	private String tel;

	//メールアドレス
	@NotEmpty
	@Pattern(regexp = "^([\\w])+([\\w\\._-])*\\@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$")
	private String mail;

	//原価
	@NotNull
	@NumberFormValid
	private String cost;

	//役割
	@NotNull
	@NumberFormValid
	private String role;


	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}