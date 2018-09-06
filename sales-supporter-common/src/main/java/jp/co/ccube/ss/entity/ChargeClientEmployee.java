package jp.co.ccube.ss.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ChargeClientEmployee extends CaseDetail{
	private Integer employeeNo;
	private String engineerName;
	private Date startDate;
	private Date endDate;
	private Integer price;
	private Integer excessPrice;
	private Integer deductionPrice;
	private Integer cost;
	private Integer excessCost;
	private Integer deductionCost;
	private BigDecimal manHours;
	private Boolean role;
	public Integer getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(Integer employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEngineerName() {
		return engineerName;
	}
	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
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
	public BigDecimal getManHours() {
		return manHours;
	}
	public void setManHours(BigDecimal manHours) {
		this.manHours = manHours;
	}
	public Boolean getRole() {
		return role;
	}
	public void setRole(Boolean role) {
		this.role = role;
	}


}
