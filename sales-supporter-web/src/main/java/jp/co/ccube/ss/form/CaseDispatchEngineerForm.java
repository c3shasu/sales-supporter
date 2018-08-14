package jp.co.ccube.ss.form;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class CaseDispatchEngineerForm {
	@NotEmpty
	private Integer projectID;
	@NotEmpty
	private Integer caseID;
	@NotEmpty
	private Date dispatchStartDate;
	@NotEmpty
	private Date dispatchEndDate;

	private Integer lowerTime;
	private Integer upperTIme;
	private Integer lowerTimem;
	private Integer upperTImem;
	private String production;
	private String dispatchStartYear;
	private String dispatchStartMonth;
	private String dispatchStartDay;
	private String dispatchEndYear;
	private String dispatchEndMonth;
	private String dispatchEndDay;

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

	private String engineerStartYear;
	private String engineerStartMonth;
	private String engineerStartDay;
	private String engineerEndYear;
	private String engineerEndMonth;
	private String engineerEndDay;




	public Integer getProjectID() {
		return projectID;
	}
	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}
	public Integer getCaseID() {
		return caseID;
	}
	public void setCaseID(Integer caseID) {
		this.caseID = caseID;
	}
	public Date getDispatchStartDate() {
		return dispatchStartDate;
	}
	public void setDispatchStartDate(Date dispatchStartDate) {
		this.dispatchStartDate = dispatchStartDate;
	}
	public Date getDispatchEndDate() {
		return dispatchEndDate;
	}
	public void setDispatchEndDate(Date dispatchEndDate) {
		this.dispatchEndDate = dispatchEndDate;
	}
	public Integer getLowerTime() {
		return lowerTime;
	}
	public void setLowerTime(Integer lowerTime) {
		this.lowerTime = lowerTime;
	}
	public Integer getUpperTIme() {
		return upperTIme;
	}
	public void setUpperTIme(Integer upperTIme) {
		this.upperTIme = upperTIme;
	}
	public Integer getLowerTimem() {
		return lowerTimem;
	}
	public void setLowerTimem(Integer lowerTimem) {
		this.lowerTimem = lowerTimem;
	}
	public Integer getUpperTImem() {
		return upperTImem;
	}
	public void setUpperTImem(Integer upperTImem) {
		this.upperTImem = upperTImem;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getDispatchStartYear() {
		return dispatchStartYear;
	}
	public void setDispatchStartYear(String dispatchStartYear) {
		this.dispatchStartYear = dispatchStartYear;
	}
	public String getDispatchStartMonth() {
		return dispatchStartMonth;
	}
	public void setDispatchStartMonth(String dispatchStartMonth) {
		this.dispatchStartMonth = dispatchStartMonth;
	}
	public String getDispatchStartDay() {
		return dispatchStartDay;
	}
	public void setDispatchStartDay(String dispatchStartDay) {
		this.dispatchStartDay = dispatchStartDay;
	}
	public String getDispatchEndYear() {
		return dispatchEndYear;
	}
	public void setDispatchEndYear(String dispatchEndYear) {
		this.dispatchEndYear = dispatchEndYear;
	}
	public String getDispatchEndMonth() {
		return dispatchEndMonth;
	}
	public void setDispatchEndMonth(String dispatchEndMonth) {
		this.dispatchEndMonth = dispatchEndMonth;
	}
	public String getDispatchEndDay() {
		return dispatchEndDay;
	}
	public void setDispatchEndDay(String dispatchEndDay) {
		this.dispatchEndDay = dispatchEndDay;
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
	public String getEngineerStartYear() {
		return engineerStartYear;
	}
	public void setEngineerStartYear(String engineerStartYear) {
		this.engineerStartYear = engineerStartYear;
	}
	public String getEngineerStartMonth() {
		return engineerStartMonth;
	}
	public void setEngineerStartMonth(String engineerStartMonth) {
		this.engineerStartMonth = engineerStartMonth;
	}
	public String getEngineerStartDay() {
		return engineerStartDay;
	}
	public void setEngineerStartDay(String engineerStartDay) {
		this.engineerStartDay = engineerStartDay;
	}
	public String getEngineerEndYear() {
		return engineerEndYear;
	}
	public void setEngineerEndYear(String engineerEndYear) {
		this.engineerEndYear = engineerEndYear;
	}
	public String getEngineerEndMonth() {
		return engineerEndMonth;
	}
	public void setEngineerEndMonth(String engineerEndMonth) {
		this.engineerEndMonth = engineerEndMonth;
	}
	public String getEngineerEndDay() {
		return engineerEndDay;
	}
	public void setEngineerEndDay(String engineerEndDay) {
		this.engineerEndDay = engineerEndDay;
	}
}
