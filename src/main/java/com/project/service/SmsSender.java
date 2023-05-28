package com.project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import com.twilio.Twilio;

@Service
public class SmsSender {

	@Value("{$twilio.account.sid}")
	private String accountId;
	
	@Value("{$twilio.auth.token}")
	private String token;
	
	@Value("{$twilio.phone.number")
	private String phoneNumber;
	
	public void sendMessage(String recipientPhoneNo, String messageBody)
	{
		Twilio.init("soundariyab0301@gmail.com",token,accountId);
		
		Message message= Message.creator(new PhoneNumber(recipientPhoneNo),
				                         new PhoneNumber(phoneNumber), messageBody).create();
		
		System.out.println(message.getSid());
		
	}
}