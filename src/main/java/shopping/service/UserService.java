package shopping.service;

import shopping.entity.Product;
import shopping.entity.User;

public interface UserService {
	
	boolean register(User user);
	
	User login(String emailId, String password);
	
	User getProfile(String emailId);
	
	boolean addProduct(Product product);

}
