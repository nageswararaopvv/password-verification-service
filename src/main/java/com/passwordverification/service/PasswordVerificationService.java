package com.passwordverification.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordVerificationService {
	
	String errorMessage = "";
	
	public String verifyPassword(String password)
	{
		if(null != password)
		{
			if(!containsLowerCase(password))
				return "Password should have one lowercase letter at least";
			else if(password.length() > 8)
				return "Valid Password";
			else if(containsUpperCase(password))
				return "Valid Password";
			else if(containsNumber(password))
				return "Valid Password"; 
			else
				return "Invald Password";
		}
		else
			return "Password should not be Empty";
	}
	
	private boolean containsLowerCase(String password)
	{
		for(Character passwordChar : password.toCharArray())
		{
			if(Character.isLowerCase(passwordChar))
				return true;
		}
		return false;
	}
	
	private boolean containsUpperCase(String password)
	{
		for(Character passwordChar : password.toCharArray())
		{
			if(Character.isUpperCase(passwordChar))
				return true;
		}
		return false;
	}
	
	private boolean containsNumber(String password)
	{
		for(Character passwordChar : password.toCharArray())
		{
			if(Character.isDigit(passwordChar))
				return true;
		}
		return false;
	}
}
