package nus.iss.sa45.team13.stockist.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterForm {
	private Integer userId;
	
	@Size(min=4, max=30)
	private String name;
	
	@Size(min=4, max=30)
	private String userName;
	
	@Size(min=4, max=30)
	private String password;
	
	@NotNull
	private boolean adminStatus;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(boolean adminStatus) {
		this.adminStatus = adminStatus;
	}	
}
