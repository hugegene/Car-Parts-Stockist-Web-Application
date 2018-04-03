package nus.iss.sa45.team13.stockist.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import nus.iss.sa45.team13.stockist.model.User;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		User u = (User) arg0;
		ValidationUtils.rejectIfEmpty(arg1, "userid", "error.suppliers.name.empty");
		ValidationUtils.rejectIfEmpty(arg1, "password", "error.suppliers.address.empty");
		
		System.out.println(u.toString());
	
	}
}
