package com.cheetah.payments.paypal.auth.response; 
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data; 
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAuth2TokenResponse{
	private String scope;
	private String access_token;
	private String token_type;
	private String app_id;
	private int expires_in;
	private ArrayList<String> supported_authn_schemes;
	private String nonce;
	private ClientMetadata client_metadata;}
