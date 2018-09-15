package shopping.dao;

import shopping.entity.User;

public interface UserDao {
	
	boolean registerUser(User user);
	
	User login(String emailId, String password);
}
