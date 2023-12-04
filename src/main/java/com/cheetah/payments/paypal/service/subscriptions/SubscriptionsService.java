package com.cheetah.payments.paypal.service.subscriptions;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cheetah.payments.paypal.repositories.subscriptions.SubscriptionsRepository;
import com.cheetah.payments.paypal.service.AbstractService;
import com.cheetah.payments.paypal.subscription.dto.SubscriptionDto;
import com.cheetah.payments.paypal.subscription.request.SubscriptionRequest;
import com.cheetah.payments.paypal.subscription.response.SubscriptionResponse;

@Service
public class SubscriptionsService extends AbstractService<SubscriptionRequest, SubscriptionResponse> {

	@Autowired
	private SubscriptionsRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${paypal.create.subs.url}")
	private String createSubUrl;
	
	@Value("${paypal.details.subs.url}")
	private String detailsSubUrl;

	public SubscriptionResponse createSub(SubscriptionRequest request) {
		HttpHeaders headers = getCommonHeaders();
		ResponseEntity<SubscriptionResponse> re = this.exec(createSubUrl, HttpMethod.POST,
				createEntity(request, headers), SubscriptionResponse.class);
		if (re.getStatusCode().is2xxSuccessful()) {
			SubscriptionResponse response = re.getBody();
			SubscriptionDto dto = SubscriptionDto.builder().request(request).response(response).build();
			dto = repository.save(dto);
			return response;
		}
		return null;
	}

	public SubscriptionResponse verifySubActive(String subscriptionId) {
		SubscriptionDto dto =repository.findBySubscriptionId(subscriptionId);
		HttpHeaders headers = getCommonHeaders();
		
		StringSubstitutor sub = new StringSubstitutor();
		sub.setVariablePrefix(':');
		Map<String,String> map = new HashMap<>();
		map.put("subscription_id", subscriptionId);

		String tempUrl = StringSubstitutor.replace(detailsSubUrl, map,"{","}");
		
		ResponseEntity<SubscriptionResponse> re = exec(tempUrl, HttpMethod.GET, createEntity(headers), SubscriptionResponse.class);
		if(re.getStatusCode().is2xxSuccessful()) {
			SubscriptionResponse response = re.getBody();
			dto.setResponse(response);
			repository.save(dto);
			return response;
		}
		return null;
	}

}
