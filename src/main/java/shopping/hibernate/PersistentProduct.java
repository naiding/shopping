package shopping.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "products")
public class PersistentProduct implements Serializable {

	private static final long serialVersionUID = 1529150892368175741L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String productName;
	
	@Column(name = "category")
	private String productCategory;

	@Column(name = "description")
	private String productDescription;

	@Column(name = "price")
	private double productPrice;
	
	@Column(name = "post_date")
	private Timestamp productPostDate;
	
	@Column(name = "is_sold")
	private boolean productIsSold;
	
	@Column(name = "delivery")
	private String productDelivery;
	
	@Transient
	private MultipartFile productImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Timestamp getProductPostDate() {
		return productPostDate;
	}

	public void setProductPostDate(Timestamp productPostDate) {
		this.productPostDate = productPostDate;
	}

	public boolean isProductIsSold() {
		return productIsSold;
	}

	public void setProductIsSold(boolean productIsSold) {
		this.productIsSold = productIsSold;
	}

	public String getProductDelivery() {
		return productDelivery;
	}

	public void setProductDelivery(String productDelivery) {
		this.productDelivery = productDelivery;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	
}
