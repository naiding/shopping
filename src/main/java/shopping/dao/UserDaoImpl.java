package shopping.dao;

import java.util.Date;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopping.entity.User;
import shopping.hibernate.PersistentUser;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	public boolean registerUser(User user) {
		
		PersistentUser pUser = new PersistentUser();
		pUser.setEmailId(user.getEmail());
		pUser.setPassword(user.getPassword());
		pUser.setEnabled(user.isEnabled());
		
		pUser.setFirstName(user.getFirstName());
		pUser.setLastName(user.getLastName());
		pUser.setWechatName(user.getWechatName());
		pUser.setPhoneNumber(user.getPhoneNumber());
		
		pUser.setRegisterDate(new Timestamp(new Date().getTime()));
		pUser.setFavoriteList(null);
		pUser.setSaleList(null);
		
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(pUser);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return false;
	}

	public User login(String emailId, String password) {
		return null;
	}

}
