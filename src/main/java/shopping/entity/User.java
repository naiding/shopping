package shopping.entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class User {
	
	private String email;
	private String password;
	private boolean enabled;
	
	private String firstName;
	private String lastName;
	
	private String wechatName;
	private String phoneNumber;
	
	private String registerDate;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("email", email);
			obj.put("enabled", enabled);
			obj.put("first_name", firstName);
			obj.put("last_name", lastName);
			obj.put("wechatName", wechatName);
			obj.put("phoneNumber", phoneNumber);
			obj.put("register_date", registerDate);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
