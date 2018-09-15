package shopping.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import shopping.entity.User;

@Entity
@Table(name = "users")
public class PersistentUser implements Serializable {

	private static final long serialVersionUID = 6032603002668143274L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String emailId;
	private String password;
	private boolean enabled;
	
	private String firstName;
	private String lastName;
	
	private String wechatName;
	private String phoneNumber;

	private Timestamp registerDate;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<PersistentProduct> favoriteList;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<PersistentProduct> saleList;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	
	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public List<PersistentProduct> getFavoriteList() {
		return favoriteList;
	}

	public void setFavoriteList(List<PersistentProduct> favoriteList) {
		this.favoriteList = favoriteList;
	}

	public List<PersistentProduct> getSaleList() {
		return saleList;
	}

	public void setSaleList(List<PersistentProduct> saleList) {
		this.saleList = saleList;
	}
}
