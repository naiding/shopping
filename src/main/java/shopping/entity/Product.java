package shopping.entity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import shopping.hibernate.PersistentCategory;
import shopping.hibernate.PersistentProduct;

public class Product {
	
	private int product_id;
	private int user_id;
		
	private String name;
	private String description;
	private double price;
	private String post_date;
	private boolean is_sold;
	private String delivery;
	
	private List<String> categories;

	public Product() {
		
	}
	
	public Product(PersistentProduct pProduct) {
		this.product_id = pProduct.getId();
		this.user_id = pProduct.getOwner().getId();
		
		this.name = pProduct.getProductName();
		this.description = pProduct.getProductDescription();
		this.price = pProduct.getProductPrice();
		this.post_date = pProduct.getProductPostDate().toString();
		this.is_sold = pProduct.isProductIsSold();
		this.delivery = pProduct.getProductDelivery();
		
		this.categories = new ArrayList<String>();
		for (PersistentCategory pCategory : pProduct.getProductCategories()) {
			this.categories.add(pCategory.getCategory());
		}
	}
	
	public int getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public List<String> getCategories() {
		return categories;
	}
	
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getPost_date() {
		return post_date;
	}
	
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	
	public boolean isIs_sold() {
		return is_sold;
	}
	
	public void setIs_sold(boolean is_sold) {
		this.is_sold = is_sold;
	}
	
	public String getDelivery() {
		return delivery;
	}
	
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("product_id", product_id);
			obj.put("user_id", user_id);
			obj.put("name", name);
			obj.put("description", description);
			obj.put("price", price);
			obj.put("post_date", post_date);
			obj.put("is_sold", is_sold);
			obj.put("delivery", delivery);
			obj.put("categories", new JSONArray(this.categories)); 
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", user_id=" + user_id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", post_date=" + post_date + ", is_sold=" + is_sold + ", delivery="
				+ delivery + ", categories=" + categories + "]";
	}
	
	
}
