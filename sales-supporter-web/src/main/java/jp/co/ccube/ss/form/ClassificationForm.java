package jp.co.ccube.ss.form;

import org.hibernate.validator.constraints.NotEmpty;

public class ClassificationForm {
	@NotEmpty
	private String classificationCode;
	@NotEmpty
	private Integer classificationId;
	@NotEmpty
	private String classificationName;

	private Integer[] check;

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

	public Integer[] getCheck() {
		return check;
	}

	public void setCheck(Integer[] check) {
		this.check = check;
	}

}
