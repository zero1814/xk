package org.customer.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Autowired
	private TokenStore tokenStore;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().antMatchers("/order/**").authenticated();
		http.csrf().disable().authorizeRequests().antMatchers("/product/**", "/registry/**", "/user/login/**")
				.permitAll().antMatchers("/**").authenticated();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		RemoteTokenServices tokenServices = new RemoteTokenServices();
		tokenServices.setClientId("client_2");
		tokenServices.setClientSecret("123456");
		tokenServices.setCheckTokenEndpointUrl("http://192.168.99.100:9098/oauth/check_token");
		resources.tokenServices(tokenServices);
		resources.tokenStore(tokenStore);
	}

}
