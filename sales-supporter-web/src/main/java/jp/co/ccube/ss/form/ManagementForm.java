package jp.co.ccube.ss.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class ManagementForm {
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	//@AccountIdCheck
	private String accountId;

	@NotEmpty
	private String password;

	@NotEmpty
	private String name;

	@NotEmpty
	private String department;

	private String position;

	private String tel;

	@NotEmpty
	@Pattern(regexp = "^([\\w])+([\\w\\._-])*\\@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$")
	private String mail;

	@NotEmpty
	private Integer[] permission;

	private String[] check;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer[] getPermission() {
		return permission;
	}

	public void setPermission(Integer[] permission) {
		this.permission = permission;
	}

	public String[] getCheck() {
		return check;
	}

	public void setCheck(String[] check) {
		this.check = check;
	}

}