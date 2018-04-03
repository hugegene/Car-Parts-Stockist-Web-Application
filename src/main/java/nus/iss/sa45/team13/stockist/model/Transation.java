package nus.iss.sa45.team13.stockist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transation {
	
	@Id
	@Column(name="transid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transid;
	@Column(name="staffid")
	private int staffid;
	@Column(name="datetime")
	private Date datetime;
	@Column(name="licenseplateno")
	private String licenseplateno;
	@Column(name="remarks")
	private String remarks;
	public Transation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transation(int transid, int staffid, Date datetime, String licenseplateno, String remarks) {
		super();
		this.transid = transid;
		this.staffid = staffid;
		this.datetime = datetime;
		this.licenseplateno = licenseplateno;
		this.remarks = remarks;
	}
	public int getTransid() {
		return transid;
	}
	public void setTransid(int transid) {
		this.transid = transid;
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getLicenseplateno() {
		return licenseplateno;
	}
	public void setLicenseplateno(String licenseplateno) {
		this.licenseplateno = licenseplateno;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Transation [transid=" + transid + ", staffid=" + staffid + ", datetime=" + datetime
				+ ", licenseplateno=" + licenseplateno + ", remarks=" + remarks + "]";
	}
	
	

}
