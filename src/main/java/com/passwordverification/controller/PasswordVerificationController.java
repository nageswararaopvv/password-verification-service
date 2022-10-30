package com.passwordverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.passwordverification.service.PasswordVerificationService;

@RestController
public class PasswordVerificationController {
	@Autowired
	private PasswordVerificationService passwordVerificationService;
	private String verifyPasswordMessage = "";
	
	@GetMapping("/isValidPassword/{password}")
	 public ResponseEntity<Object> verifyPassword(@PathVariable("password") String password)
		{
			verifyPasswordMessage = passwordVerificationService.verifyPassword(password);
			return ResponseEntity.status(HttpStatus.OK).body(verifyPasswordMessage);
		}
}
