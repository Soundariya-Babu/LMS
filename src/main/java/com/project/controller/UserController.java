package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.service.EmailService;
import com.project.service.PaymentService;
import com.project.service.SmsSender;
import com.project.service.UserService;
import com.project.service.UserServiceInterface;
import com.stripe.exception.StripeException;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SmsSender smsService;
	
	@Autowired
	private PaymentService paymentService;

//	@GetMapping("/hello")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<String> loginmethod(){
//		return new ResponseEntity<String>("Hi you are successfully logged in", HttpStatus.OK);
//	}
	
	@PostMapping("/add")
	public ResponseEntity<String> newUser(@RequestBody User user)
	{
		  userService.addNewUser(user);
		  return new ResponseEntity<String>("Hi you are successfully logged in", HttpStatus.OK);
		  
		
	}
	
	@PostMapping("/send-mail")
	public ResponseEntity<String> sendMail(@RequestParam String toMail) throws MessagingException
	{
		  emailService.sendMail(toMail);
		  return new ResponseEntity<>("Mail Sent successfully", HttpStatus.OK);
		  
		
	}
	
	@GetMapping("/send-sms")
	public ResponseEntity<String> sendSms(@RequestParam String phoneNumber) 
	{
		  smsService.sendMessage(phoneNumber, "Hii.. this is sample sms");
		  return new ResponseEntity<>("SMS Sent successfully", HttpStatus.OK);
		  
		
	}
	
	@PostMapping("/payments")
	public ResponseEntity<String> payments(@RequestParam double amount)  
	{
		  try {
			paymentService.createPaymentIntend(amount, "INR");
		} catch (StripeException e) {
			
			return new ResponseEntity<>("payment failure" +e.getMessage(), HttpStatus.FORBIDDEN);
		}
		  return new ResponseEntity<>("payment successfully", HttpStatus.OK);
		  
	}
	
	
	
}
