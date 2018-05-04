package jp.co.ccube.ss.listner;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jp.co.ccube.ss.service.SessionService;

public class SessionListener implements HttpSessionListener {

	private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.debug("セッションを新しく作成しました。: " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		try {
			ApplicationContext ctx = WebApplicationContextUtils
					.getWebApplicationContext(se.getSession().getServletContext());
			SessionService sessionService = (SessionService) ctx.getBean("sessionService");
			sessionService.removeSession(se.getSession().getId());
			logger.debug("セッションを破棄しました。: " + se.getSession().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
