package jp.co.ccube.ss.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class SubprojectForm {
	@NotEmpty
	@Pattern(regexp = "^[0-9]+$")
	private Integer projectId;
	private String projectName;
	private Integer caseId;
	private String caseName;
	private Integer clientId;
	private Integer branchNo;
	private Boolean agreementType;
	private String name;
	private String companyName;
	private String classificationName;

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(Integer branchNo) {
		this.branchNo = branchNo;
	}

	public Boolean getAgreementType() {
		return agreementType;
	}

	public void setAgreementType(Boolean agreementType) {
		this.agreementType = agreementType;
	}

}
