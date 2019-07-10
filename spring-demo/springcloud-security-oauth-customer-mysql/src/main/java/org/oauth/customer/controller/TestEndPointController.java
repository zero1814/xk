package org.oauth.customer.controller;

import java.security.Principal;

import org.apache.commons.lang.StringUtils;
import org.oauth.customer.model.ScUser;
import org.oauth.customer.service.IScUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndPointController {
	Logger logger = LoggerFactory.getLogger(TestEndPointController.class);

	@Autowired
	private IScUserService service;

	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable String id) {
		return "product id : " + id;
	}

	@GetMapping("/order/{id}")
	public String getOrder(@PathVariable String id) {
		return "order id : " + id;
	}

	@GetMapping("/getPrinciple")
	public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal,
			Authentication authentication) {
		logger.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
		logger.info(oAuth2Authentication.toString());
		logger.info("principal.toString() " + principal.toString());
		logger.info("principal.getName() " + principal.getName());
		logger.info("authentication: " + authentication.getAuthorities().toString());

		return oAuth2Authentication;
	}

	@RequestMapping(value = "/registry", method = RequestMethod.POST)
	public ScUser createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
			ScUser user = new ScUser();
			user.setUserName(username);
			user.setPassword(password);
			return service.create(user);
		}
		return null;
	}
}
