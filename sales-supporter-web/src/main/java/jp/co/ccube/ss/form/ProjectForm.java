package jp.co.ccube.ss.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProjectForm {
	@NotNull
	private Integer projectId;
	@NotEmpty
	private String projectName;
	@NotNull
	private Integer clientId;

	private Integer[] check;

	private String companyName;

	private Date startDate;

	private Date endDate;


	public Integer getProject_id() {
		return projectId;
	}

	public void setProject_id(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer[] getCheck() {
		return check;
	}

	public void setCheck(Integer[] check) {
		this.check = check;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
