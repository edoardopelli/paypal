package com.cheetah.payments.paypal.plan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class BillingCycle{
	private Frequency frequency;
	private String tenure_type;
	private int sequence;
	private int total_cycles;
	private PricingScheme pricing_scheme;
}
