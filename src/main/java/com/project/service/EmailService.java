package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class EmailService {

	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public String generateOTP() {
		
		Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
		
	}
	
	public void sendMail(String toMail) throws MessagingException
	{
		String otp=generateOTP();
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper= new MimeMessageHelper(message,true);
		
		List<String> recipientList = Arrays.asList("soundariyababu01@gmail.com", toMail);
        for (String recipient : recipientList) {
            helper.addTo(new InternetAddress(recipient));
        }
		//helper.setTo(toMail);
		//helper.setTo("soundariyababu01@gmail.com");

		helper.setSubject("OTP CODE");
		
		FileSystemResource file =new FileSystemResource("C:/Users/adfdf/eclipse-workspace/LMS/sampleFile.txt");
		
        helper.setText("OTP code is " +otp +
        		       " \n Click the link to view more details https://github.com/Soundariya-Babu/LMS");
		helper.addAttachment("sampleFile.txt", file);
		
		javaMailSender.send(message);
	}
}
