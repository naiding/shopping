package shopping.entity;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
	
	private String user_id;
	private String email;
	private String password;
	private boolean enabled;
	
	private String first_name;
	private String last_name;
	
	private String wechat;
	private String phone;
	
	private String register_date;

	private List<Product> favorites;
	private List<Product> sales;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public List<Product> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Product> favorites) {
		this.favorites = favorites;
	}

	public List<Product> getSales() {
		return sales;
	}

	public void setSales(List<Product> sales) {
		this.sales = sales;
	}
	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("user_id", user_id);
			obj.put("email", email);
			obj.put("enabled", enabled);
			obj.put("first_name", first_name);
			obj.put("last_name", last_name);
			obj.put("wechat", wechat);
			obj.put("phone", phone);
			obj.put("register_date", register_date);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
