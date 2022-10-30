package com.passwordverification.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordVerificationServiceTest {
	
	@Autowired
	private PasswordVerificationService passwordVerificationServiceTest; 
	
	@Test
	public void testVerifyPassword_success()
	{
		assertEquals("Valid Password",passwordVerificationServiceTest.verifyPassword("ValidPassword"));
	}
	
	@Test
	public void testVerifyPassword_failure()
	{
		assertEquals("Invald Password",passwordVerificationServiceTest.verifyPassword("invalid"));
	}
	
	@Test
	public void testVerifyPassword_ContainsMinLength()
	{
		assertEquals("Valid Password",passwordVerificationServiceTest.verifyPassword("ValidateByLength"));
	}
	
	@Test
	public void testVerifyPassword_ContainsLowerCase()
	{
		assertEquals("Valid Password",passwordVerificationServiceTest.verifyPassword("ValidateByLowerCase"));
	}
	
	@Test
	public void testVerifyPassword_ContainsUpperCase()
	{
		assertEquals("Valid Password",passwordVerificationServiceTest.verifyPassword("ValidateByUpperCase"));
	}
	
	@Test
	public void testVerifyPassword_ContainsNumber()
	{
		assertEquals("Valid Password",passwordVerificationServiceTest.verifyPassword("ValidateByNum123"));
	}
	
	@Test
	public void testVerifyPassword_NotNull()
	{
		assertEquals("Valid Password",passwordVerificationServiceTest.verifyPassword("PasswordNotNull"));
	}
	
	@Test
	public void testVerifyPassword_Null()
	{
		assertEquals("Password should not be Empty",passwordVerificationServiceTest.verifyPassword(null));
	}
	
	@Test
	public void testVerifyPassword_NotContainsLowerCase()
	{
		assertEquals("Password should have one lowercase letter at least",passwordVerificationServiceTest.verifyPassword("NOLOWERCASE"));
	}
}
