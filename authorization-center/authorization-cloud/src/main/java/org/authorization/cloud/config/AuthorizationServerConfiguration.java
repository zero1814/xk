package org.authorization.cloud.config;

import java.util.concurrent.TimeUnit;

import org.authorization.cloud.service.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private DruidDataSource dataSource;

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Autowired
	private IScUserService userDetailsService;

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("test-jwt.jks"),
				"test123".toCharArray());
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyStoreKeyFactory.getKeyPair("test-jwt"));
		return converter;
	}

	@Bean
	public ClientDetailsService clientDetailsService() {
		return new JdbcClientDetailsService(dataSource);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// 允许表单认证
		security.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetailsService);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
		// 配置tokenServices参数
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(endpoints.getTokenStore());
		tokenServices.setSupportRefreshToken(false);
		tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
		tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
		tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30)); // 30天
		endpoints.tokenServices(tokenServices);

	}

}
