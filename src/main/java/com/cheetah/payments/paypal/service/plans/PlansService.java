package com.cheetah.payments.paypal.service.plans;

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
import com.cheetah.payments.paypal.plan.dto.PlanDto;
import com.cheetah.payments.paypal.plan.request.PlanRequest;
import com.cheetah.payments.paypal.plan.response.PlanResponse;
import com.cheetah.payments.paypal.repositories.plan.PlansRepository;
import com.cheetah.payments.paypal.service.AbstractService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlansService extends AbstractService{

	@Autowired
	private RestTemplate restTemplate;
	

	@Value("${paypal.create.plan.url}")
	private String createPlanUrl;
	
	@Autowired
	private PlansRepository repository;

	public PlanResponse create(PlanRequest request) {
		HttpHeaders h = getCommonHeaders();
		HttpEntity<PlanRequest> entity = new HttpEntity<PlanRequest>(request, h);
		ResponseEntity<PlanResponse> re = restTemplate.exchange(createPlanUrl, HttpMethod.POST, entity, PlanResponse.class);
		if(re.getStatusCode().is2xxSuccessful()) {
			PlanResponse response = re.getBody();
			PlanDto dto = new PlanDto();
			dto.setRequest(request);
			dto.setResponse(response);
			repository.save(dto);
			return response;
		}
		log.error(re.getBody().toString());
		return null;
	}
	
	
}
