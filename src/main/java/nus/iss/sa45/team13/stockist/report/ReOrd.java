package nus.iss.sa45.team13.stockist.report;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class ReOrd extends JRDefaultScriptlet {
	
	public void Reord()
	{
		
	}

public Integer getMinOrdReq() throws JRScriptletException{
	
		Integer reord = (Integer) getFieldValue("reorderpoint");
		Integer qty = (Integer) getFieldValue("storeqty");
		Integer minord = (Integer) getFieldValue("minorder");
		
		if (qty<reord) {
			Integer temp = reord - qty;
			return ((temp / minord) + 1) * minord;
		} else {
			return 0;
		}
	}
	
	public Integer getMinOrdReq(int reord, int qty, int minord) throws JRScriptletException
	{
		if (reord < qty) {
			Integer temp = reord - qty;
			return ((temp / minord) + 1) * minord;
		} else {
			return 0;
		}
	}

	public Double calcTotal() throws JRScriptletException {
		Double uprice = (Double) getFieldValue("unitprice");
		return getMinOrdReq() * uprice;
	}

}
