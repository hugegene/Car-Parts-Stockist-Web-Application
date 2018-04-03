package nus.iss.sa45.team13.stockist.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jfree.ui.about.SystemPropertiesTableModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import nus.iss.sa45.team13.stockist.model.LocalinventoryList;;

@Component
public class TransationValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	//String STRING_PATTERN = "[a-zA-Z\\s0-9]+";
	String MOBILE_PATTERN = "[0-9]{10}";
	//String COUNTRY_PATTERN = "[a-zA-Z]+";
	

	@Override
	public boolean supports(Class<?> arg0) {
		return LocalinventoryList.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) throws NumberFormatException{
		
		LocalinventoryList l = (LocalinventoryList) arg0;
		
		ValidationUtils.rejectIfEmpty(arg1, "partNumber", "error.quantity.empty");
		
		System.out.println(l.toString());

		 //input string contains numeric values only for contact
//		  if (l.getStoreqty() < 0) {  
//			  arg1.rejectValue("partNumber", "number.negative", "Number is negative");    
//				      
//		   }  
	}
	
//    public static boolean isIntegerParseInt(String str) {
//        try {
//            Integer.parseInt(str);
//            return true;
//        } catch (NumberFormatException nfe) {}
//        return false;
//    }

}
