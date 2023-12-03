package com.cheetah.payments.paypal.service.orders;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cheetah.payments.paypal.config.PaymentsPaypalConfig;
import com.cheetah.payments.paypal.order.request.OrderRequest;
import com.cheetah.payments.paypal.order.response.OrderResponse;

@Service
public class OrdersService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PaymentsPaypalConfig config;
	
	@Value("${paypal.create.order.url}")
	private String createOrderUrl;
	
	public OrderResponse createOrder(OrderRequest request) {
		String authToken = config.getAccessToken();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Paypal-Request-Id", UUID.randomUUID().toString());
		headers.add("Prefer", "return=representation");
		headers.setBearerAuth(authToken);
		HttpEntity<OrderRequest> entity = new HttpEntity<OrderRequest>(request, headers);
		ResponseEntity<OrderResponse> re = restTemplate.exchange(createOrderUrl, HttpMethod.POST, entity,OrderResponse.class);
		if(re.getStatusCode().is2xxSuccessful()) {
			return re.getBody();
		}
		return null;
		
		
	}
}
