package jp.co.ccube.ss.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureHandler
		implements org.springframework.security.web.authentication.AuthenticationFailureHandler {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		logger.warn("ログインに失敗しました。ログインID[" + request.getParameter("loginId") + "]", exception);
		response.sendRedirect(request.getContextPath() + "/login" + "?error=1");
	}
}
