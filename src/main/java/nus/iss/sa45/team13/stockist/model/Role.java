package nus.iss.sa45.team13.stockist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="staffDetails")
public class Role {
	@Id
	@Column(name="staffid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer staffId;
	
	@Column(name="name")
	@Size(min=4, max=20)
	private String name;
	
	@Column(name="role")
	private String role;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Role() {}

	public Role(Integer staffId, String name, String role) {
		super();
		this.staffId = staffId;
		this.name = name;
		this.role = role;
	}
	
	
}
