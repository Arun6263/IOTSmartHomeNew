package com.akshar.iot.smarthome.validator;

import org.springframework.validation.Errors;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.akshar.iot.smarthome.form.LoginForm;

@Component("loginValidator")
public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> type){
		return LoginForm.class.isAssignableFrom(type);
		
	}
	@Override
	public void validate(Object command, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId", "LoginId/EmailId is Invalid");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password is Invalid");
		
		
		LoginForm loginForm = (LoginForm)command;
		if(null==loginForm.getPhoneNo()){
			errors.reject("EMail", "LoginId should not be empty");
			System.out.println("---------EMailId should not be empty--------");
		}
		else{
        	System.out.println("Email Address Not Null");
        	/*try{
        	internetAddress internetAddress = new InternetAddress(loginForm.getLoginId());
        	internetAddress.validate();
        	}
        	catch(Exception e){
        		errors.rejectValue("loginId", "field.emailId.invalid");
        	}
*/        }
	}
}
