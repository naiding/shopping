package shopping.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopping.entity.Product;
import shopping.hibernate.PersistentProduct;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
    private SessionFactory sessionFactory;

	public Product getProduct(int productId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			PersistentProduct pProduct = session.get(PersistentProduct.class, productId);
			session.getTransaction().commit();

			if (pProduct != null) {
				return new Product(pProduct);
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
