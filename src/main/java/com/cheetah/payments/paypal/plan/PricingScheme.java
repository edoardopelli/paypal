package com.cheetah.payments.paypal.plan;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PricingScheme{
	private int version;
	private FixedPrice fixed_price;
	private Date create_time;
	private Date update_time;}
