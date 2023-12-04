package com.cheetah.payments.paypal.subscription.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Link{
    private String href;
    private String rel;
    private String method;
}
