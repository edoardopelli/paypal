package com.cheetah.payments.paypal.plan.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cheetah.payments.paypal.plan.request.PlanRequest;
import com.cheetah.payments.paypal.plan.response.PlanResponse;

import lombok.Data;

@Document("paypalPlans")
@Data
public class PlanDto {
	
	@Id
	private String idPlan;
	private PlanRequest request;
	private PlanResponse response;

}
