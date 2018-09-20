package shopping.hibernate;

import java.io.Serializable;

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

	private String category;

	public PersistentCategory() {
		
	}
	
	public PersistentCategory(PersistentProduct product, String category) {
		this.product = product;
		this.category = category;
	}
	
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
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
