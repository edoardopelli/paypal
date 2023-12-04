package com.cheetah.payments.paypal.subscription;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Name{
    private String given_name;
    private String surname;
    private String full_name;
}
