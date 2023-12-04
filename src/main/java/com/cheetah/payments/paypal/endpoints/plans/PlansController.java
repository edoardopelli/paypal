package com.cheetah.payments.paypal.endpoints.plans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheetah.payments.paypal.plan.request.PlanRequest;
import com.cheetah.payments.paypal.plan.response.PlanResponse;
import com.cheetah.payments.paypal.service.plans.PlansService;

@RestController
@RequestMapping("/paypal")
public class PlansController {
	
	
	@Autowired
	private PlansService service;

	@PostMapping("/create/plan")
	public ResponseEntity<PlanResponse> createPlan(@RequestBody PlanRequest request){

		PlanResponse response = service.create(request);
		if(response == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
}
