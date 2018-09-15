package shopping.service;

import shopping.entity.User;

public interface UserService {
	
	boolean registerUser(User user);
	User login(String emailId, String password);
}
