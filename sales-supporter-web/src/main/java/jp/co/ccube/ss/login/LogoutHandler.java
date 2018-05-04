package jp.co.ccube.ss.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import jp.co.ccube.ss.service.SessionService;

@Component
public class LogoutHandler implements org.springframework.security.web.authentication.logout.LogoutHandler {

	private static final Logger logger = LoggerFactory.getLogger(LogoutHandler.class);

	@Autowired
	private SessionService service;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		logger.info("ログアウトしました。ログインID[" + authentication.getName() + "]");

		// セッション情報 削除
		try {
			service.removeSessionByAccountId(authentication.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
