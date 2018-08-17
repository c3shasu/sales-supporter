package jp.co.ccube.ss.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EntrustedForm {
	@NotEmpty
	private Integer project_id;
	@NotEmpty
	private Integer case_id;
	@NotEmpty
	private Date startDate;
	@NotEmpty
	private Date endDate;
	@NotEmpty
	private String startYear;
	@NotEmpty
	private String startMonth;
	@NotEmpty
	private String startDay;
	@NotEmpty
	private String endYear;
	@NotEmpty
	private String endMonth;
	@NotEmpty
	private String endDay;
	@DecimalMax("9999999.999")
	@DecimalMin("0.0")
	private BigDecimal manHour;
	@NotNull
	private Integer price;
	@NotNull
	private Integer additional;
	@NotNull
	private Integer sales;

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

	public BigDecimal getManHour() {
		return manHour;
	}

	public void setManHour(BigDecimal manHour) {
		this.manHour = manHour;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAdditional() {
		return additional;
	}

	public void setAdditional(Integer additional) {
		this.additional = additional;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

}
