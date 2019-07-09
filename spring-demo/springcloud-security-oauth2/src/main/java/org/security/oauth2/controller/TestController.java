package org.security.oauth2.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user/")
@Slf4j
public class TestController {

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(Principal principal) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
		log.info(principal.toString());
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
		return principal;
	}
}
