package jp.co.ccube.ss.login;

import org.springframework.security.core.authority.AuthorityUtils;

import jp.co.ccube.ss.entity.Users;
import lombok.Getter;

@Getter
public class LoginUser extends org.springframework.security.core.userdetails.User {

	private final Users loginUserInfo;

	public LoginUser(Users user) {
		super(user.getAccountId(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.loginUserInfo = user;
	}

}
