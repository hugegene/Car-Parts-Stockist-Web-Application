package nus.iss.sa45.team13.stockist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="localinventorylist")
public class LocalinventoryList {
	
	@Id
	@Column(name="partnumber")
	private int partnumber;
	@Column(name="storeqty")
	private int storeqty;
	
	
	public LocalinventoryList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalinventoryList(int partnumber, int storeqty) {
		super();
		this.partnumber = partnumber;
		this.storeqty = storeqty;
	}
	public int getPartnumber() {
		return partnumber;
	}
	public void setPartnumber(int partnumber) {
		this.partnumber = partnumber;
	}
	public int getStoreqty() {
		return storeqty;
	}
	public void setStoreqty(int storeqty) {
		this.storeqty = storeqty;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partnumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalinventoryList other = (LocalinventoryList) obj;
		if (partnumber != other.partnumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LocalinventoryList [partnumber=" + partnumber + ", storeqty=" + storeqty + "]";
	}
	
	

}
