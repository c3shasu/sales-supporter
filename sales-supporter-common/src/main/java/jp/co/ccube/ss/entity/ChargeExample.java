package jp.co.ccube.ss.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ChargeExample {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	protected String orderByClause;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	protected boolean distinct;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public ChargeExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andProjectIdIsNull() {
			addCriterion("project_id is null");
			return (Criteria) this;
		}

		public Criteria andProjectIdIsNotNull() {
			addCriterion("project_id is not null");
			return (Criteria) this;
		}

		public Criteria andProjectIdEqualTo(Integer value) {
			addCriterion("project_id =", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdNotEqualTo(Integer value) {
			addCriterion("project_id <>", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdGreaterThan(Integer value) {
			addCriterion("project_id >", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("project_id >=", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdLessThan(Integer value) {
			addCriterion("project_id <", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
			addCriterion("project_id <=", value, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdIn(List<Integer> values) {
			addCriterion("project_id in", values, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdNotIn(List<Integer> values) {
			addCriterion("project_id not in", values, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdBetween(Integer value1, Integer value2) {
			addCriterion("project_id between", value1, value2, "projectId");
			return (Criteria) this;
		}

		public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
			addCriterion("project_id not between", value1, value2, "projectId");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNull() {
			addCriterion("case_id is null");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNotNull() {
			addCriterion("case_id is not null");
			return (Criteria) this;
		}

		public Criteria andCaseIdEqualTo(Integer value) {
			addCriterion("case_id =", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotEqualTo(Integer value) {
			addCriterion("case_id <>", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThan(Integer value) {
			addCriterion("case_id >", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("case_id >=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThan(Integer value) {
			addCriterion("case_id <", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThanOrEqualTo(Integer value) {
			addCriterion("case_id <=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdIn(List<Integer> values) {
			addCriterion("case_id in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotIn(List<Integer> values) {
			addCriterion("case_id not in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdBetween(Integer value1, Integer value2) {
			addCriterion("case_id between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("case_id not between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andBranchNoIsNull() {
			addCriterion("branch_no is null");
			return (Criteria) this;
		}

		public Criteria andBranchNoIsNotNull() {
			addCriterion("branch_no is not null");
			return (Criteria) this;
		}

		public Criteria andBranchNoEqualTo(Integer value) {
			addCriterion("branch_no =", value, "branchNo");
			return (Criteria) this;
		}

		public Criteria andBranchNoNotEqualTo(Integer value) {
			addCriterion("branch_no <>", value, "branchNo");
			return (Criteria) this;
		}

		public Criteria andBranchNoGreaterThan(Integer value) {
			addCriterion("branch_no >", value, "branchNo");
			return (Criteria) this;
		}

		public Criteria andBranchNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("branch_no >=", value, "branchNo");
			return (Criteria) this;
		}

		public Criteria andBranchNoLessThan(Integer value) {
			addCriterion("branch_no <", value, "branchNo");
			return (Criteria) this;
		}

		public Criteria andBranchNoLessThanOrEqualTo(Integer value) {
			addCriterion("branch_no <=", value, "branchNo");
			return (Criteria) this;
		}

		public Criteria andBranchNoIn(List<Integer> values) {
			addCriterion("branch_no in", values, "branchNo");
			return (Criteria) this;
		}

		public Criteria andBranchNoNotIn(List<Integer> values) {
			addCriterion("branch_no not in", values, "branchNo");
			return (Criteria) this;
		}

		public Criteria andBranchNoBetween(Integer value1, Integer value2) {
			addCriterion("branch_no between", value1, value2, "branchNo");
			return (Criteria) this;
		}

		public Criteria andBranchNoNotBetween(Integer value1, Integer value2) {
			addCriterion("branch_no not between", value1, value2, "branchNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoIsNull() {
			addCriterion("employee_no is null");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoIsNotNull() {
			addCriterion("employee_no is not null");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoEqualTo(Integer value) {
			addCriterion("employee_no =", value, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoNotEqualTo(Integer value) {
			addCriterion("employee_no <>", value, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoGreaterThan(Integer value) {
			addCriterion("employee_no >", value, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("employee_no >=", value, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoLessThan(Integer value) {
			addCriterion("employee_no <", value, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoLessThanOrEqualTo(Integer value) {
			addCriterion("employee_no <=", value, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoIn(List<Integer> values) {
			addCriterion("employee_no in", values, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoNotIn(List<Integer> values) {
			addCriterion("employee_no not in", values, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoBetween(Integer value1, Integer value2) {
			addCriterion("employee_no between", value1, value2, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andEmployeeNoNotBetween(Integer value1, Integer value2) {
			addCriterion("employee_no not between", value1, value2, "employeeNo");
			return (Criteria) this;
		}

		public Criteria andClientIdIsNull() {
			addCriterion("client_id is null");
			return (Criteria) this;
		}

		public Criteria andClientIdIsNotNull() {
			addCriterion("client_id is not null");
			return (Criteria) this;
		}

		public Criteria andClientIdEqualTo(Integer value) {
			addCriterion("client_id =", value, "clientId");
			return (Criteria) this;
		}

		public Criteria andClientIdNotEqualTo(Integer value) {
			addCriterion("client_id <>", value, "clientId");
			return (Criteria) this;
		}

		public Criteria andClientIdGreaterThan(Integer value) {
			addCriterion("client_id >", value, "clientId");
			return (Criteria) this;
		}

		public Criteria andClientIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("client_id >=", value, "clientId");
			return (Criteria) this;
		}

		public Criteria andClientIdLessThan(Integer value) {
			addCriterion("client_id <", value, "clientId");
			return (Criteria) this;
		}

		public Criteria andClientIdLessThanOrEqualTo(Integer value) {
			addCriterion("client_id <=", value, "clientId");
			return (Criteria) this;
		}

		public Criteria andClientIdIn(List<Integer> values) {
			addCriterion("client_id in", values, "clientId");
			return (Criteria) this;
		}

		public Criteria andClientIdNotIn(List<Integer> values) {
			addCriterion("client_id not in", values, "clientId");
			return (Criteria) this;
		}

		public Criteria andClientIdBetween(Integer value1, Integer value2) {
			addCriterion("client_id between", value1, value2, "clientId");
			return (Criteria) this;
		}

		public Criteria andClientIdNotBetween(Integer value1, Integer value2) {
			addCriterion("client_id not between", value1, value2, "clientId");
			return (Criteria) this;
		}

		public Criteria andEngineerNameIsNull() {
			addCriterion("engineer_name is null");
			return (Criteria) this;
		}

		public Criteria andEngineerNameIsNotNull() {
			addCriterion("engineer_name is not null");
			return (Criteria) this;
		}

		public Criteria andEngineerNameEqualTo(String value) {
			addCriterion("engineer_name =", value, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameNotEqualTo(String value) {
			addCriterion("engineer_name <>", value, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameGreaterThan(String value) {
			addCriterion("engineer_name >", value, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameGreaterThanOrEqualTo(String value) {
			addCriterion("engineer_name >=", value, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameLessThan(String value) {
			addCriterion("engineer_name <", value, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameLessThanOrEqualTo(String value) {
			addCriterion("engineer_name <=", value, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameLike(String value) {
			addCriterion("engineer_name like", value, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameNotLike(String value) {
			addCriterion("engineer_name not like", value, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameIn(List<String> values) {
			addCriterion("engineer_name in", values, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameNotIn(List<String> values) {
			addCriterion("engineer_name not in", values, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameBetween(String value1, String value2) {
			addCriterion("engineer_name between", value1, value2, "engineerName");
			return (Criteria) this;
		}

		public Criteria andEngineerNameNotBetween(String value1, String value2) {
			addCriterion("engineer_name not between", value1, value2, "engineerName");
			return (Criteria) this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("price is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("price is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(Integer value) {
			addCriterion("price =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(Integer value) {
			addCriterion("price <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(Integer value) {
			addCriterion("price >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("price >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(Integer value) {
			addCriterion("price <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(Integer value) {
			addCriterion("price <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<Integer> values) {
			addCriterion("price in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<Integer> values) {
			addCriterion("price not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(Integer value1, Integer value2) {
			addCriterion("price between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(Integer value1, Integer value2) {
			addCriterion("price not between", value1, value2, "price");
			return (Criteria) this;
		}

		// 超過金額
		public Criteria andExcessAmountIsNull() {
			addCriterion("excess_amount is null");
			return (Criteria) this;
		}

		public Criteria andExcessAmountIsNotNull() {
			addCriterion("excess_amount is not null");
			return (Criteria) this;
		}

		public Criteria andExcessAmountEqualTo(Integer value) {
			addCriterion("excess_amount =", value, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andExcessAmountNotEqualTo(Integer value) {
			addCriterion("excess_amount <>", value, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andExcessAmountGreaterThan(Integer value) {
			addCriterion("excess_amount >", value, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andExcessAmountGreaterThanOrEqualTo(Integer value) {
			addCriterion("excess_amount >=", value, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andExcessAmountLessThan(Integer value) {
			addCriterion("excess_amount <", value, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andExcessAmountLessThanOrEqualTo(Integer value) {
			addCriterion("excess_amount <=", value, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andExcessAmountIn(List<Integer> values) {
			addCriterion("excess_amount in", values, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andExcessAmountNotIn(List<Integer> values) {
			addCriterion("excess_amount not in", values, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andExcessAmountBetween(Integer value1, Integer value2) {
			addCriterion("excess_amount between", value1, value2, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andExcessAmountNotBetween(Integer value1, Integer value2) {
			addCriterion("excess_amount not between", value1, value2, "excess_amount");
			return (Criteria) this;
		}

		public Criteria andStartDateIsNull() {
			addCriterion("start_date is null");
			return (Criteria) this;
		}

		public Criteria andStartDateIsNotNull() {
			addCriterion("start_date is not null");
			return (Criteria) this;
		}

		public Criteria andStartDateEqualTo(Date value) {
			addCriterionForJDBCDate("start_date =", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("start_date <>", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateGreaterThan(Date value) {
			addCriterionForJDBCDate("start_date >", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("start_date >=", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateLessThan(Date value) {
			addCriterionForJDBCDate("start_date <", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("start_date <=", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateIn(List<Date> values) {
			addCriterionForJDBCDate("start_date in", values, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("start_date not in", values, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
			return (Criteria) this;
		}

		public Criteria andEndDateIsNull() {
			addCriterion("end_date is null");
			return (Criteria) this;
		}

		public Criteria andEndDateIsNotNull() {
			addCriterion("end_date is not null");
			return (Criteria) this;
		}

		public Criteria andEndDateEqualTo(Date value) {
			addCriterionForJDBCDate("end_date =", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("end_date <>", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateGreaterThan(Date value) {
			addCriterionForJDBCDate("end_date >", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("end_date >=", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateLessThan(Date value) {
			addCriterionForJDBCDate("end_date <", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("end_date <=", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateIn(List<Date> values) {
			addCriterionForJDBCDate("end_date in", values, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("end_date not in", values, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
			return (Criteria) this;
		}

		public Criteria andManHoursIsNull() {
			addCriterion("man_hours is null");
			return (Criteria) this;
		}

		public Criteria andManHoursIsNotNull() {
			addCriterion("man_hours is not null");
			return (Criteria) this;
		}

		public Criteria andManHoursEqualTo(BigDecimal value) {
			addCriterion("man_hours =", value, "manHours");
			return (Criteria) this;
		}

		public Criteria andManHoursNotEqualTo(BigDecimal value) {
			addCriterion("man_hours <>", value, "manHours");
			return (Criteria) this;
		}

		public Criteria andManHoursGreaterThan(BigDecimal value) {
			addCriterion("man_hours >", value, "manHours");
			return (Criteria) this;
		}

		public Criteria andManHoursGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("man_hours >=", value, "manHours");
			return (Criteria) this;
		}

		public Criteria andManHoursLessThan(BigDecimal value) {
			addCriterion("man_hours <", value, "manHours");
			return (Criteria) this;
		}

		public Criteria andManHoursLessThanOrEqualTo(BigDecimal value) {
			addCriterion("man_hours <=", value, "manHours");
			return (Criteria) this;
		}

		public Criteria andManHoursIn(List<BigDecimal> values) {
			addCriterion("man_hours in", values, "manHours");
			return (Criteria) this;
		}

		public Criteria andManHoursNotIn(List<BigDecimal> values) {
			addCriterion("man_hours not in", values, "manHours");
			return (Criteria) this;
		}

		public Criteria andManHoursBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("man_hours between", value1, value2, "manHours");
			return (Criteria) this;
		}

		public Criteria andManHoursNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("man_hours not between", value1, value2, "manHours");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table charge
	 *
	 * @mbggenerated do_not_delete_during_merge Thu Jul 26 11:44:04 JST 2018
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table charge
	 *
	 * @mbggenerated Thu Jul 26 11:44:04 JST 2018
	 */
	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}