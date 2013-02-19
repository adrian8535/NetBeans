package org.koushik.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="USER_DETAILS")
public class UserDetails {

	private int userId;
	
	private String username;
	
	@Id
	@Column (name="USER_ID") 
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column (name="USER_NAME") 
	public String getUsername() {
		return username + "from getter";
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
