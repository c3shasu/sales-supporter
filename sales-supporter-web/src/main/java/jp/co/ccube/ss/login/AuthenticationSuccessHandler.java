package jp.co.ccube.ss.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import jp.co.ccube.ss.service.SessionService;

@Component
public class AuthenticationSuccessHandler
		implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);

	@Autowired
	private SessionService service;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info("ログインに成功しました。ログインID[" + authentication.getName() + "]");

		// セッション作成
		HttpSession httpSession = request.getSession(false);
		if (httpSession == null) {
			httpSession = request.getSession(true);
		}

		// セッション情報 削除 登録
		try {
			service.removeSessionByAccountId(authentication.getName());
			service.registerSession(authentication.getName(), httpSession.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/input");
	}
}
