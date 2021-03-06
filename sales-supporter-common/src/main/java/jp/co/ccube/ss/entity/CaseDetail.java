package jp.co.ccube.ss.entity;

public class CaseDetail extends CaseProject {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client.company_id
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	private Integer companyId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client.company_name
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	private String companyName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client.address
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	private String address;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client.telephone
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	private String telephone;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client.mail_address
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	private String mailAddress;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client.type
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	private Integer type;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client.description
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	private String description;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client_responsible.department
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	private String department;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client_responsible.position
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	private String position;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client_responsible.name
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	private String name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column client_responsible.kana
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	private String kana;

	private String classificationName;

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client.company_id
	 *
	 * @return the value of client.company_id
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client.company_id
	 *
	 * @param companyId the value for client.company_id
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client.company_name
	 *
	 * @return the value of client.company_name
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client.company_name
	 *
	 * @param companyName the value for client.company_name
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client.address
	 *
	 * @return the value of client.address
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client.address
	 *
	 * @param address the value for client.address
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client.telephone
	 *
	 * @return the value of client.telephone
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client.telephone
	 *
	 * @param telephone the value for client.telephone
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client.mail_address
	 *
	 * @return the value of client.mail_address
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client.mail_address
	 *
	 * @param mailAddress the value for client.mail_address
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client.type
	 *
	 * @return the value of client.type
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client.type
	 *
	 * @param type the value for client.type
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client.description
	 *
	 * @return the value of client.description
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client.description
	 *
	 * @param description the value for client.description
	 *
	 * @mbggenerated Mon Jun 04 11:52:17 JST 2018
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client_responsible.department
	 *
	 * @return the value of client_responsible.department
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client_responsible.department
	 *
	 * @param department the value for client_responsible.department
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client_responsible.position
	 *
	 * @return the value of client_responsible.position
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client_responsible.position
	 *
	 * @param position the value for client_responsible.position
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client_responsible.name
	 *
	 * @return the value of client_responsible.name
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client_responsible.name
	 *
	 * @param name the value for client_responsible.name
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column client_responsible.kana
	 *
	 * @return the value of client_responsible.kana
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	public String getKana() {
		return kana;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column client_responsible.kana
	 *
	 * @param kana the value for client_responsible.kana
	 *
	 * @mbggenerated Tue Aug 07 18:29:41 JST 2018
	 */
	public void setKana(String kana) {
		this.kana = kana;
	}

}
