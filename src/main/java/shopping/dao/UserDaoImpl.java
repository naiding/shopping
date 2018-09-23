package shopping.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopping.entity.Product;
import shopping.entity.User;
import shopping.hibernate.PersistentCategory;
import shopping.hibernate.PersistentProduct;
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
//		pUser.setFavoriteList(null);
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

	public Integer login(String emailId, String password) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String hql = "from PersistentUser pu where pu.emailId = :emailId";
			Query<PersistentUser> query = session.createQuery(hql, PersistentUser.class)
								.setParameter("emailId", emailId);
			PersistentUser pUser = query.getSingleResult();
			session.getTransaction().commit();
			if (pUser != null && pUser.getPassword().equals(password)) {
				return Integer.valueOf(pUser.getId());
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

	public User getProfile(int userId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String hql = "from PersistentUser pu where pu.id = :userId";
			Query<PersistentUser> query = session.createQuery(hql, PersistentUser.class)
								.setParameter("userId", userId);
			PersistentUser pUser = query.getSingleResult();
			session.getTransaction().commit();
			
			if (pUser != null) {
				return new User(pUser);
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

	public boolean addProduct(Product product) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String hql = "from PersistentUser pu where pu.id = :userId";
			Query<PersistentUser> query = session.createQuery(hql, PersistentUser.class)
								.setParameter("userId", product.getUser_id());
			PersistentUser pUser = query.getSingleResult();
			session.getTransaction().commit();
			
			if (pUser == null) {
				return false;
			}	
			session.beginTransaction();
			PersistentProduct pProduct = new PersistentProduct();
			pProduct.setOwner(pUser);
			pProduct.setProductName(product.getName());
			pProduct.setProductDescription(product.getDescription());
			pProduct.setProductPrice(product.getPrice());
			pProduct.setProductPostDate(new Timestamp(new Date().getTime()));
			pProduct.setProductIsSold(product.isIs_sold());
			pProduct.setProductDelivery(product.getDelivery());
			List<PersistentCategory> pCategories = new ArrayList<PersistentCategory>();
			for (String s : product.getCategories()) {
				pCategories.add(new PersistentCategory(pProduct, s));
			}
			pProduct.setProductCategories(pCategories);
			session.save(pProduct);
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
}
