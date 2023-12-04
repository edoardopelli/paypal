package com.cheetah.payments.paypal.endpoints.subscriptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cheetah.payments.paypal.service.subscriptions.SubscriptionsService;
import com.cheetah.payments.paypal.subscription.request.SubscriptionRequest;
import com.cheetah.payments.paypal.subscription.response.SubscriptionResponse;

@RestController
@RequestMapping("/paypal/subscription")
public class SubscriptionsController {

	@Autowired
	private SubscriptionsService service;
	
	@PostMapping("/create")
	public ResponseEntity<SubscriptionResponse> createSub(@RequestBody SubscriptionRequest request){
		SubscriptionResponse response = service.createSub(request);
		if(response == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/details")
	public ResponseEntity<SubscriptionResponse> verifySubActive(@RequestParam("subscription_id") String subscriptionId){
		
		SubscriptionResponse response = service.verifySubActive(subscriptionId);
		if(response == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		
	}
}
