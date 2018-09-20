package shopping.dao;

import shopping.entity.Product;
import shopping.entity.User;

public interface UserDao {
	
	boolean register(User user);
	
	User login(String emailId, String password);
	
	User getProfile(String emailId);
	
	boolean addProduct(Product product);
}
