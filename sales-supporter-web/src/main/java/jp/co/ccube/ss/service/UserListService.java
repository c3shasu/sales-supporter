package jp.co.ccube.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.UsersDao;
import jp.co.ccube.ss.entity.Users;

@Service
public class UserListService {
	@Autowired
	private UsersDao usersDao;

	public List<Users> search(String accountId, String name, String dept){
		Users users = new Users();
		if (!accountId.isEmpty()) {
		users.setAccountId(accountId);
		}
		if (!name.isEmpty()) {
		users.setName(name);
		}
		if (!dept.isEmpty()) {
		users.setDepartment(dept);
		}
		return usersDao.selectByUsers(users);
	}
}
