package com.cheetah.payments.paypal.subscription;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Subscriber {
	private Name name;
	private String email_address;
	private ShippingAddress shipping_address;
}
