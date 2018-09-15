package shopping.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categories")
public class PersistentCategory implements Serializable {

	private static final long serialVersionUID = -1448653649904897603L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JsonIgnore
	private PersistentProduct product;
	
	@Column(name = "first_category")
	private String firstCategory;
	
	@Column(name = "second_category")
	private String secondCategory;
	
	@Column(name = "third_category")
	private String thirdCategory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PersistentProduct getProduct() {
		return product;
	}

	public void setProduct(PersistentProduct product) {
		this.product = product;
	}

	public String getFirstCategory() {
		return firstCategory;
	}

	public void setFirstCategory(String firstCategory) {
		this.firstCategory = firstCategory;
	}

	public String getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(String secondCategory) {
		this.secondCategory = secondCategory;
	}

	public String getThirdCategory() {
		return thirdCategory;
	}

	public void setThirdCategory(String thirdCategory) {
		this.thirdCategory = thirdCategory;
	}
}
