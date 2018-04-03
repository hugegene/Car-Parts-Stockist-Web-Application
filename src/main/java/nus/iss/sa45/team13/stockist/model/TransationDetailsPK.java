package nus.iss.sa45.team13.stockist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Embeddable
public class TransationDetailsPK implements Serializable {

	@NotNull
	private int transid;
	@NotNull
	private int partnumber;
	
	
	
	@Override
	public boolean equals(Object obj) {
		TransationDetailsPK temp = (TransationDetailsPK)obj;
		return temp.getPartnumber() == partnumber && temp.getTransid() == transid;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	public int getTransid() {
		return transid;
	}

	public void setTransid(int transid) {
		this.transid = transid;
	}

	public int getPartnumber() {
		return partnumber;
	}

	public void setPartnumber(int partnumber) {
		this.partnumber = partnumber;
	}

	
}
