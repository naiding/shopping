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
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Product getProduct(int productId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String hql = "from PersistentProduct pp where pp.id = :productId";
			Query<PersistentProduct> query = session.createQuery(hql)
								.setParameter("productId", productId);
			List<PersistentProduct> pProducts = query.list();
			session.getTransaction().commit();
			if (pProducts.size() > 0) {
				return new Product(pProducts.get(0));
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

}
