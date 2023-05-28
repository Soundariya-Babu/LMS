package com.project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class PaymentService {

	@Value("{$stripe.apiKey}")
	private String apiKey;
	
	public String createPaymentIntend(double amount, String currency) throws StripeException
	{
		Stripe.apiKey=apiKey;
		
		 PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
	                .setAmount(Math.round(amount * 100))
	                .setCurrency(currency)
	                .build();

	        PaymentIntent paymentIntent = PaymentIntent.create(createParams);

	        return paymentIntent.getClientSecret();
	}
}
