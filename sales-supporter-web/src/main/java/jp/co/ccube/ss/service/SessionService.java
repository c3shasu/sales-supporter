package jp.co.ccube.ss.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ccube.ss.dao.SessionDao;
import jp.co.ccube.ss.entity.Session;

@Service
public class SessionService {

	@Autowired
	private SessionDao sessionDao;

	@Transactional(rollbackFor = Exception.class)
	public void registerSession(String accountId, String sessionId) throws Exception {
		Session session = new Session();
		session.setAccountId(accountId);
		session.setJsessionid(sessionId);
		session.setCreatedAt(new Date());
		sessionDao.insert(session);
	}

	@Transactional(rollbackFor = Exception.class)
	public void removeSession(String sessionId) throws Exception {
		sessionDao.deleteByPrimaryKey(sessionId);
	}

	@Transactional(rollbackFor = Exception.class)
	public void removeSessionByAccountId(String accountId) throws Exception {
		sessionDao.deleteByAccountId(accountId);
	}
}
