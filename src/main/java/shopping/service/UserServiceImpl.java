package shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.dao.UserDao;
import shopping.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public boolean registerUser(User user) {
		return userDao.registerUser(user);
	}

	public User login(String emailId, String password) {
		return userDao.login(emailId, password);
	}

}
