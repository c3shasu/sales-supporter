package jp.co.ccube.ss.form;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

public class ChargeForm {
	@NotEmpty
	private Integer project_id;
	@NotEmpty
	private Integer case_id;
	@NotEmpty
	private Integer branch_no;

	private Integer employeeNo;

	private Integer clientId;

	private String engineerName;

	private Integer price;

	private Integer excessAmount;

	// private Date startDate;
	//
	// private Date endDate;
	private String startYear;
	private String startMonth;
	private String startDay;
	private String endYear;
	private String endMonth;
	private String endDay;

	private BigDecimal manHours;

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public Integer getCase_id() {
		return case_id;
	}

	public void setCase_id(Integer case_id) {
		this.case_id = case_id;
	}

	public Integer getBranch_no() {
		return branch_no;
	}

	public void setBranch_no(Integer branch_no) {
		this.branch_no = branch_no;
	}

	public Integer getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Integer employeeNo) {
		this.employeeNo = employeeNo;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	// public Date getStartDate() {
	// return startDate;
	// }
	//
	// public void setStartDate(Date startDate) {
	// this.startDate = startDate;
	// }
	//
	// public Date getEndDate() {
	// return endDate;
	// }
	//
	// public void setEndDate(Date endDate) {
	// this.endDate = endDate;
	// }

	public Integer getExcessAmount() {
		return excessAmount;
	}

	public void setExcessAmount(Integer excessAmount) {
		this.excessAmount = excessAmount;
	}

	public BigDecimal getManHours() {
		return manHours;
	}

	public void setManHours(BigDecimal manHours) {
		this.manHours = manHours;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

}
