package com.akshar.iot.smarthome.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.akshar.iot.smarthome.form.UserForm;

@Component("userValidator")
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> type){
		return UserForm.class.isAssignableFrom(type);
	 	
	}
	@Override
	public void validate(Object obj, Errors errors){
		UserForm userForm = (UserForm)obj;
		/*
		try{
		
			if(null != addressBean.getState() && !addressBean.getState().trim().equals("")){
				System.out.println("-------- AddressValidator -------IF State");
				
			}
			else
			{
				errors.reject("state", "Address State should not be empty");
			}
			if(null != addressBean.getCity() && !addressBean.getCity().trim().equals("")){
				System.out.println("-------- AddressValidator -------IF City");
				
			}
			else
			{
				errors.reject("city", "Address City should not be empty");
			}
		
		System.out.println("-------- AddressValidator -------End ");
		}
		catch(Exception ex){
			System.out.println("AddressValidator   ---- Exception : "+ex);
		}
*/	}

}
