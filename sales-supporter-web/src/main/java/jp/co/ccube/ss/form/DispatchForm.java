package jp.co.ccube.ss.form;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class DispatchForm {
	@NotEmpty
	private Integer projectID;
	@NotEmpty
	private Integer caseID;
	@NotEmpty
	private Date startDate;
	@NotEmpty
	private Date endDate;

	private Integer lowerTime;
	private Integer upperTIme;
	private Integer lowerTimem;
	private Integer upperTImem;
	private String production;
	private String startYear;
	private String startMonth;
	private String startDay;
	private String endYear;
	private String endMonth;
	private String endDay;




	//プロジェクトID
	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	//案件ID
	public Integer getCaseID() {
		return caseID;
	}

	public void setCaseID(Integer caseID) {
		this.caseID = caseID;
	}

	//開始予定日
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	//終了予定日
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	//下限時間
	public Integer getLowerTime() {
		return lowerTime;
	}

	public void setLowerTime(Integer lowerTime) {
		this.lowerTime = lowerTime;
	}

	//上限時間
	public Integer getUpperTIme() {
		return upperTIme;
	}

	public void setUpperTIme(Integer upperTIme) {
		this.upperTIme = upperTIme;
	}

	//精算方法
	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
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
}
