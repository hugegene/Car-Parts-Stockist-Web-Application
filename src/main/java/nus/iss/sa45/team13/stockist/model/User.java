package nus.iss.sa45.team13.stockist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userLogin")
public class User {
	
	@Column(name = "staffid")
	private Integer staffId;
	
	@Id
	@Column(name = "userid")
	private String userId;
	
	@Column(name = "password")
	private String password;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "staffdetails", joinColumns = @JoinColumn(name = "staffid"), inverseJoinColumns = @JoinColumn(name = "staffid"))
//	private Set<Role> roles;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
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
	
	public User() {}

	public User(Integer staffId, String userId, String password) {
		super();
		this.staffId = staffId;
		this.userId = userId;
		this.password = password;
	}

//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
	
	
}
