package jp.co.ccube.ss.entity;

import java.util.Date;

public class Case extends CaseKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case.case_name
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    private String caseName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case.client_id
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    private Integer clientId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case.branch_no
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    private Integer branchNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case.agreement_type
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    private Boolean agreementType;


    private Date deletedAt;

    public Date getDeleteAt() {
		return deletedAt;
	}

	public void setDeleteAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the  value of the database column case.case_name
     *
     * @return the value of case.case_name
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    public String getCaseName() {
        return caseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case.case_name
     *
     * @param caseName the value for case.case_name
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case.client_id
     *
     * @return the value of case.client_id
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case.client_id
     *
     * @param clientId the value for case.client_id
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case.branch_no
     *
     * @return the value of case.branch_no
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    public Integer getBranchNo() {
        return branchNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case.branch_no
     *
     * @param branchNo the value for case.branch_no
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    public void setBranchNo(Integer branchNo) {
        this.branchNo = branchNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case.agreement_type
     *
     * @return the value of case.agreement_type
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    public Boolean getAgreementType() {
        return agreementType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case.agreement_type
     *
     * @param agreementType the value for case.agreement_type
     *
     * @mbggenerated Thu Jul 26 11:02:32 JST 2018
     */
    public void setAgreementType(Boolean agreementType) {
        this.agreementType = agreementType;
    }
}