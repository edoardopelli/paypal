package com.cheetah.payments.paypal.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cheetah.payments.paypal.config.PaymentsPaypalConfig;

public abstract class AbstractService<REQUEST, RESPONSE> {

	@Autowired
	private PaymentsPaypalConfig config;

	@Autowired
	private RestTemplate restTemplate;

	public HttpHeaders getCommonHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(config.getAccessToken());
		headers.add("PayPal-Request-Id", UUID.randomUUID().toString());
		headers.add("Prefer", "return=representation");
		return headers;
	}

	public HttpEntity<REQUEST> createEntity(REQUEST t, HttpHeaders headers) {
		return new HttpEntity<REQUEST>(t, headers);
	}

	public HttpEntity<REQUEST> createEntity(REQUEST t) {
		return new HttpEntity<REQUEST>(t);
	}

	public HttpEntity<REQUEST> createEntity(HttpHeaders headers) {
		return new HttpEntity<REQUEST>(headers);
	}

	public ResponseEntity<RESPONSE> exec(String url, HttpMethod method, HttpEntity<REQUEST> entity,
			Class<RESPONSE> _class) {
		ResponseEntity<RESPONSE> re = restTemplate.exchange(url, method, entity, _class);
		return re;
	}
}
