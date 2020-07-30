package restaurantapp.model;

import java.io.Serializable;

public class LoginEntity implements Serializable {
	String userId;
	String password;

	public LoginEntity() {

	}

	public LoginEntity(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
