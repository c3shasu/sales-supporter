package jp.co.ccube.ss.form;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class EngineerForm {

	@NotEmpty
	private Integer projectId;
	@NotEmpty
	private Integer cameId;
	@NotEmpty
	private Integer branchNo;
	private Integer employeeNo;
	private Integer clientId;
	private String engineerName;
	@NotEmpty
	private Integer price;
	@NotEmpty
	private Integer excessPrice;
	@NotEmpty
	private Integer deductionPrice;
	@NotEmpty
	private Integer cost;
	@NotEmpty
	private Integer excessCost;
	@NotEmpty
	private Integer deductionCost;
	@NotEmpty
	private Date startDate;
	@NotEmpty
	private Date endDate;
	@NotEmpty
	private java.math.BigDecimal manHours;

	private String startYear;
	private String startMonth;
	private String startDay;
	private String endYear;
	private String endMonth;
	private String endDay;




	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getCameId() {
		return cameId;
	}
	public void setCameId(Integer cameId) {
		this.cameId = cameId;
	}
	public Integer getBranchNo() {
		return branchNo;
	}
	public void setBranchNo(Integer branchNo) {
		this.branchNo = branchNo;
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
	public Integer getExcessPrice() {
		return excessPrice;
	}
	public void setExcessPrice(Integer excessPrice) {
		this.excessPrice = excessPrice;
	}
	public Integer getDeductionPrice() {
		return deductionPrice;
	}
	public void setDeductionPrice(Integer deductionPrice) {
		this.deductionPrice = deductionPrice;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getExcessCost() {
		return excessCost;
	}
	public void setExcessCost(Integer excessCost) {
		this.excessCost = excessCost;
	}
	public Integer getDeductionCost() {
		return deductionCost;
	}
	public void setDeductionCost(Integer deductionCost) {
		this.deductionCost = deductionCost;
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
	public java.math.BigDecimal getManHours() {
		return manHours;
	}
	public void setManHours(java.math.BigDecimal manHours) {
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


