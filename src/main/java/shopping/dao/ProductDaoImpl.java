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
import shopping.hibernate.PersistentCategory;
import shopping.hibernate.PersistentProduct;
import shopping.hibernate.PersistentUser;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
    private SessionFactory sessionFactory;

}
