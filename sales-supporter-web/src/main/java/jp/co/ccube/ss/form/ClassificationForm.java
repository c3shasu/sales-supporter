package jp.co.ccube.ss.form;

import org.hibernate.validator.constraints.NotEmpty;

public class ClassificationForm {
	@NotEmpty
	private String classificationCode;
	@NotEmpty
	private Integer classificationId;
	@NotEmpty
	private String classificationName;

	private String[] check;

	public String getClassificationCode() {
		return classificationCode;
	}

	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}

	public Integer getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(Integer classificationId) {
		this.classificationId = classificationId;
	}

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	public String[] getCheck() {
		return check;
	}

	public void setCheck(String[] check) {
		this.check = check;
	}

}
