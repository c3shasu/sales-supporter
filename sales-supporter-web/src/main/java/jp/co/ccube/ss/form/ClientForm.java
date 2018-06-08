package jp.co.ccube.ss.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class ClientForm {
	@NotEmpty
	private String clientName;

	@NotEmpty
	private String clientAddress;

	private String clientTel;

	@NotEmpty
	@Pattern(regexp = "^([\\w])+([\\w\\._-])*\\@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$")
	private String clientEmailAddress;

	private String clietDescription;

	@NotEmpty
	private Integer[] clientType;

	private Integer[] check;

	private Integer clientId;

	// 顧客名(会社名)
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	// 住所
	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	// 電話番号
	public String getClientTel() {
		return clientTel;
	}

	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
	}

	// メールアドレス
	public String getClientEmailAddress() {
		return clientEmailAddress;
	}

	public void setClientEmailAddress(String clientEmailAddress) {
		this.clientEmailAddress = clientEmailAddress;
	}

	// 備考
	public String getClietDescription() {
		return clietDescription;
	}

	public void setClietDescription(String clietDescription) {
		this.clietDescription = clietDescription;
	}

	// 顧客種別
	public Integer[] getClientType() {
		return clientType;
	}

	public void setClientType(Integer[] clientType) {
		this.clientType = clientType;
	}

	// 変更および削除対象のチェックボックス情報
	public Integer[] getCheck() {
		return check;
	}

	public void setCheck(Integer[] check) {
		this.check = check;
	}

	// 顧客名ID
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getCompanyId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}