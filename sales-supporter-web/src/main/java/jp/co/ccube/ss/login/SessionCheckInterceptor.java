package jp.co.ccube.ss.login;

import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jp.co.ccube.ss.dao.SessionDao;
import jp.co.ccube.ss.entity.Session;

/**
 * セッションの存在を確認する
 *
 */
public class SessionCheckInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SessionCheckInterceptor.class);

	@Autowired
	private SessionDao sessionDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		if (isSessionCheckPath(requestURI) == false) {
			return true;
		}
		boolean isAvailableSession = true;
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		NonSessionCheck annotation = AnnotationUtils.findAnnotation(method, NonSessionCheck.class);
		if (annotation == null) {
			HttpSession session = request.getSession(false);
			if (session == null) {
				isAvailableSession = false;
			} else {
				Session sessionInfo = sessionDao.selectByPrimaryKey(session.getId());
				if (sessionInfo == null) {
					isAvailableSession = false;
				}
			}
		}
		if (!isAvailableSession) {
			logger.debug("セッションチェックNG");
			request.setAttribute("message", "セッションが切れました。再度ログインして下さい。");
			RequestDispatcher dispatch = request.getRequestDispatcher("login");
			dispatch.forward(request, response);
			return false;
		}
		return true;
	}

	private static final  String[] checkPath = new String[] { "javascript", "css", "fonts", "images", "403", "404", "500" };

	private boolean isSessionCheckPath(String requestUri) {
		logger.debug(requestUri);
		for(int i = 0; i < checkPath.length; i++){
			if(requestUri.contains(checkPath[i])){
				return false;
			}
		}
		return true;
	}
}
