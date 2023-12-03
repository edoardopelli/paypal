package com.cheetah.payments.paypal.plan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PaymentPreferences{
	private boolean auto_bill_outstanding;
	private SetupFee setup_fee;
	private String setup_fee_failure_action;
	private int payment_failure_threshold;}
