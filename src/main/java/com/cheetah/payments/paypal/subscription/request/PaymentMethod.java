package com.cheetah.payments.paypal.subscription.request;

import com.cheetah.payments.paypal.subscription.ShippingAmount;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PaymentMethod{
    private String payer_selected;
    private String payee_preferred;
}
