package com.cheetah.payments.paypal.auth.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientMetadata {
	private String name;
	private String display_name;
	private String logo_uri;
	private ArrayList<String> scopes;
	private String ui_type;
}
