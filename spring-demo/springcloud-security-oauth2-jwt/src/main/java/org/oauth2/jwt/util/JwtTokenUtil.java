package org.oauth2.jwt.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/***
 * 
 * 类: JwtTokenUtil <br>
 * 描述: <br>
 * JwtToken生成的工具类 <br>
 * JWT token的格式：header.payload.signature <br>
 * header的格式（算法、token的类型）： <br>
 * {"alg": "HS512","typ": "JWT"} <br>
 * payload的格式（用户名、创建时间、生成时间）： <br>
 * {"sub":"wang","created":1489079981393,"exp":1489684781} <br>
 * signature的生成算法： <br>
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 * 作者: zhy<br>
 * 时间: 2019年7月10日 上午10:58:15
 */
@Component
public class JwtTokenUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
	private static final String CLAIM_KEY_USERNAME = "sub";
	private static final String CLAIM_KEY_CREATED = "created";
	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private Long expiration;

	/**
	 * 
	 * 方法: generateToken <br>
	 * 描述: 根据负责生成JWT的token <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:34:52
	 * 
	 * @param claims
	 * @return
	 */
	private String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	/**
	 * 
	 * 方法: getClaimsFromToken <br>
	 * 描述: 从token中获取JWT中的负载 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:34:59
	 * 
	 * @param token
	 * @return
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			LOGGER.info("JWT格式验证失败:{}", token);
		}
		return claims;
	}

	/**
	 * 
	 * 方法: generateExpirationDate <br>
	 * 描述: 生成token的过期时间 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:35:09
	 * 
	 * @return
	 */
	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + expiration * 1000);
	}

	/**
	 * 
	 * 方法: getUserNameFromToken <br>
	 * 描述: 从token中获取登录用户名 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:35:19
	 * 
	 * @param token
	 * @return
	 */
	public String getUserNameFromToken(String token) {
		String username;
		try {
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	/**
	 * 
	 * 方法: validateToken <br>
	 * 描述: 验证token是否还有效 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:36:51
	 * 
	 * @param token
	 *            客户端传入的token
	 * @param userDetails
	 *            从数据库中查询出来的用户信息
	 * @return
	 */
	public boolean validateToken(String token, UserDetails userDetails) {
		String username = getUserNameFromToken(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	/**
	 * 
	 * 方法: isTokenExpired <br>
	 * 描述: 判断token是否已经失效 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:37:38
	 * 
	 * @param token
	 * @return
	 */
	private boolean isTokenExpired(String token) {
		Date expiredDate = getExpiredDateFromToken(token);
		return expiredDate.before(new Date());
	}

	/**
	 * 
	 * 方法: getExpiredDateFromToken <br>
	 * 描述: 从token中获取过期时间 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:37:16
	 * 
	 * @param token
	 * @return
	 */
	private Date getExpiredDateFromToken(String token) {
		Claims claims = getClaimsFromToken(token);
		return claims.getExpiration();
	}

	/**
	 * 
	 * 方法: generateToken <br>
	 * 描述: 根据用户信息生成token <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:37:23
	 * 
	 * @param userDetails
	 * @return
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		claims.put(CLAIM_KEY_CREATED, new Date());
		return generateToken(claims);
	}

	/**
	 * 
	 * 方法: canRefresh <br>
	 * 描述: 判断token是否可以被刷新 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:33:13
	 * 
	 * @param token
	 * @return
	 */
	public boolean canRefresh(String token) {
		return !isTokenExpired(token);
	}

	/**
	 * 
	 * 方法: refreshToken <br>
	 * 描述: 刷新token <br>
	 * 作者: zhy<br>
	 * 时间: 2019年7月10日 上午10:33:19
	 * 
	 * @param token
	 * @return
	 */
	public String refreshToken(String token) {
		Claims claims = getClaimsFromToken(token);
		claims.put(CLAIM_KEY_CREATED, new Date());
		return generateToken(claims);
	}

}
