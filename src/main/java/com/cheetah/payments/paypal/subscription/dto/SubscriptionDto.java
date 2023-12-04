package com.cheetah.payments.paypal.subscription.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cheetah.payments.paypal.subscription.request.SubscriptionRequest;
import com.cheetah.payments.paypal.subscription.response.SubscriptionResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@Document("paypalSubscriptions")
@Builder
public class SubscriptionDto {

	@Id
	private String idSubscription;
	
	private SubscriptionRequest request;
	private SubscriptionResponse response;
}
