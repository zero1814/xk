package org.springcloud.security.oauth2.jwt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class OauthTest {

	public static void main(String[] args) {
		System.out.println("{bcrypt}" + new BCryptPasswordEncoder().encode("123456"));
	}
}
