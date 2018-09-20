package shopping.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopping.entity.User;
import shopping.hibernate.PersistentUser;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	public boolean register(User user) {
		
		PersistentUser pUser = new PersistentUser();
		pUser.setEmailId(user.getEmail());
		pUser.setPassword(user.getPassword());
		pUser.setEnabled(user.isEnabled());
		
		pUser.setFirstName(user.getFirst_name());
		pUser.setLastName(user.getLast_name());
		pUser.setWechatName(user.getWechat());
		pUser.setPhoneNumber(user.getPhone());
		
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

	@SuppressWarnings("unchecked")
	public User login(String emailId, String password) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String hql = "from PersistentUser pu where pu.emailId = :emailId"
					+ " AND pu.password = :password";
			Query<PersistentUser> query = session.createQuery(hql)
					.setParameter("emailId", emailId)
					.setParameter("password", password);
			List<PersistentUser> pUsers = query.list();
			session.getTransaction().commit();
			if (pUsers.size() > 0) {
				return new User(pUsers.get(0));
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public User getProfile(String emailId) {
		return null;
	}

}
