package com.cheetah.payments.paypal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
