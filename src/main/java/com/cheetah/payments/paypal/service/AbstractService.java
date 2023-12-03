package com.cheetah.payments.paypal.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.cheetah.payments.paypal.config.PaymentsPaypalConfig;

public abstract class AbstractService {

	@Autowired
	private PaymentsPaypalConfig config;
	
	public HttpHeaders getCommonHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(config.getAccessToken());
		headers.add("PayPal-Request-Id", UUID.randomUUID().toString());
		return headers;
	}
}
