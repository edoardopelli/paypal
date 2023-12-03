package com.cheetah.payments.paypal.plan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Frequency{
    private String interval_unit;
    private int interval_count;
}
