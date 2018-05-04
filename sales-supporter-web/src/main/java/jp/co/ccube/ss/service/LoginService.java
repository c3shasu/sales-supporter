package jp.co.ccube.ss.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.UsersDao;
import jp.co.ccube.ss.entity.Users;
import jp.co.ccube.ss.login.LoginUser;

@Service
public class LoginService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private UsersDao usersDao;

	@Override
	public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
		Users user = null;
		try {
			user = usersDao.selectByAccountId(accountId);
		} catch (Exception e) {
			throw new UsernameNotFoundException("ユーザ情報取得時に例外が発生しました。", e);
		}

		// ユーザー情報を取得できなかった場合
		if (user == null) {
			logger.warn("ユーザ情報が見つかりませんでした。ログインID[" + accountId + "]");
			throw new UsernameNotFoundException("ユーザ情報が見つかりませんでした。ログインID[" + accountId + "]");
		}

		return new LoginUser(user);
	}
}
