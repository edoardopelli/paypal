package com.cheetah.payments.paypal.subscription.response;

import java.util.Date;
import java.util.List;

import com.cheetah.payments.paypal.subscription.ShippingAmount;
import com.cheetah.payments.paypal.subscription.Subscriber;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SubscriptionResponse {
	private String status;
	private Date status_update_time;
	private String id;
	private String plan_id;
	private Date start_time;
	private String quantity;
	private ShippingAmount shipping_amount;
	private Subscriber subscriber;
	private Date create_time;
	private boolean plan_overridden;
	private List<Link> links;
}
