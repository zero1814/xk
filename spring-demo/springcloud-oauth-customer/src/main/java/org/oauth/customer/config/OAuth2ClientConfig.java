package org.oauth.customer.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import feign.RequestInterceptor;

@EnableOAuth2Client
@Configuration
public class OAuth2ClientConfig {
	@Bean
	public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
		ClientCredentialsResourceDetails detail = new ClientCredentialsResourceDetails();
		detail.setAccessTokenUri("http://192.168.99.100:9098/oauth/token");
		detail.setClientId("client_2");
		detail.setClientSecret("123456");
		detail.setGrantType("password");
		List<String> scopes = new ArrayList<>();
		scopes.add("server");
		detail.setScope(scopes);
		return detail;
	}

	@Bean
	public RequestInterceptor oauth2FeignRequestInterceptor() {
		return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
	}

	@Bean
	public OAuth2RestTemplate clientCredentialsRestTemplate() {
		return new OAuth2RestTemplate(clientCredentialsResourceDetails());
	}
}
