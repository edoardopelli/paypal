package com.cheetah.payments.paypal.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/payments/paypal/v1")
public @interface PaypalRestController {

}
