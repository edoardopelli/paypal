package com.cheetah.payments.paypal.subscription.request;

import com.cheetah.payments.paypal.subscription.ShippingAmount;
import com.cheetah.payments.paypal.subscription.Subscriber;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SubscriptionRequest{
    private String plan_id;
    private String start_time;
    private ShippingAmount shipping_amount;
    private Subscriber subscriber;
    private ApplicationContext application_context;
}
