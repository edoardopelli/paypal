package com.cheetah.payments.paypal.subscription.request;

import com.cheetah.payments.paypal.subscription.ShippingAmount;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ApplicationContext{
    private String brand_name;
    private String locale;
    private String shipping_preference;
    private String user_action;
    private PaymentMethod payment_method;
    private String return_url;
    private String cancel_url;
}
