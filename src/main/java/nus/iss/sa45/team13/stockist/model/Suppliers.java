package nus.iss.sa45.team13.stockist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.annotations.Type;

@Entity
@Table (name="suppliers")
public class Suppliers {

@Id
private int supplierid;

@Column(name="name")
private String name;

@Column(name="address")
private String address;

@Column(name="country")
private String country;

@Column(name="contact")
private Integer contact;

public Suppliers() {
	super();
	// TODO Auto-generated constructor stub
}

public Suppliers(int supplierid, String name, String address, String country, Integer contact) {
	super();
	this.supplierid = supplierid;
	this.name = name;
	this.address = address;
	this.country = country;
	this.contact = contact;
}

public int getSupplierid() {
	return supplierid;
}

public void setSupplierid(int supplierid) {
	this.supplierid = supplierid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public Integer getContact() {
	return contact;
}

public void setContact(int contact) {
	this.contact = contact;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + contact;
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + supplierid;
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
	Suppliers other = (Suppliers) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (contact != other.contact)
		return false;
	if (country == null) {
		if (other.country != null)
			return false;
	} else if (!country.equals(other.country))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (supplierid != other.supplierid)
		return false;
	return true;
}

@Override
public String toString() {
	return "Suppliers [supplierid=" + supplierid + ", name=" + name + ", address=" + address + ", country=" + country
			+ ", contact=" + contact + "]";
}



}
