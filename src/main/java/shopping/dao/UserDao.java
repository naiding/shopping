package shopping.dao;

import shopping.entity.Product;
import shopping.entity.User;

public interface UserDao {
	
	boolean register(User user);
	
	Integer login(String emailId, String password);
	
	User getProfile(int userId);
	
	boolean addProduct(Product product);
}
