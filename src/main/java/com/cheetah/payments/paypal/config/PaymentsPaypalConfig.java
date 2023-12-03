package com.cheetah.payments.paypal.config;

import java.time.Duration;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.cheetah.payments.paypal.auth.response.OAuth2TokenResponse;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class PaymentsPaypalConfig{

	public static String PAYPAL_ACCESS_TOKEN;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${paypal.client.id}")
	private String clientId;

	@Value("${paypal.client.secret}")
	private String clientSecret;

	@Value("${paypal.oauth2.token.url}")
	private String authTokenUrl;

	@Getter
	private String accessToken;
	
	private static final long START_TIME = System.currentTimeMillis() ;

	@PostConstruct
	@Scheduled(fixedDelay = 32400000) // 9 ore
	public void recoverAccessToken() {
		if (accessToken == null || (System.currentTimeMillis()-START_TIME)>=32400000) {
			HttpHeaders headers = new HttpHeaders();
			String auth = clientId + ":" + clientSecret;
			byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
			String authHeader = "Basic " + new String(encodedAuth);
			log.info(authHeader);
			headers.set("Authorization", authHeader);
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> mm = new LinkedMultiValueMap<String, String>();
			mm.add("grant_type", "client_credentials");
			ResponseEntity<OAuth2TokenResponse> re = restTemplate.exchange(authTokenUrl, HttpMethod.POST,
					new HttpEntity<>(mm, headers), OAuth2TokenResponse.class);
			OAuth2TokenResponse response = re.getBody();
			accessToken = response.getAccess_token();
		}
	}

	



	

}
