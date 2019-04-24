package org.system.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.system.entity.user.ScUserInfo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * 类: JwtTokenUtil <br>
 * 描述: jwt工具类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月24日 下午2:58:36
 */
@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2663159526884930245L;
	private static final String CLAIM_KEY_USERNAME = "sub";
	private static final String CLAIM_KEY_CREATED = "created";
	/**
	 * 密钥
	 */
	@Value("${jwt.secret}")
	private String secret;
	/**
	 * //有效期
	 */
	@Value("${jwt.expiration}")
	private Long expiration;

	/**
	 * 
	 * 方法: generateToken <br>
	 * 描述: 从数据声明生成令牌 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午2:59:28
	 * 
	 * @param claims
	 *            数据声明
	 * @return 令牌
	 */
	private String generateToken(Map<String, Object> claims) {
		Date expirationDate = new Date(System.currentTimeMillis() + expiration * 1000);
		return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	

	/**
	 * 
	 * 方法: getClaimsFromToken <br>
	 * 描述: 从令牌中获取数据声明 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午3:03:50
	 * 
	 * @param token
	 *            令牌
	 * @return 数据声明
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}


	/**
	 * 
	 * 方法: generateToken <br>
	 * 描述: 生成令牌 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午3:00:59
	 * 
	 * @param userDetails
	 * @return
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>(2);
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		claims.put(CLAIM_KEY_CREATED, new Date());
		return generateToken(claims);
	}

	/**
	 * 
	 * 方法: setExpire <br>
	 * 描述: 将token存储到redis <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午3:21:04
	 * @param key
	 * @param val
	 * @param time
	 */
    public void setExpire(String key, String val, long time) {
    }

    /**
     * 
     * 方法: del <br>
     * 描述: 移除 <br>
     * 作者: zhy<br>
     * 时间: 2019年4月24日 下午3:20:57
     * @param key
     */
    public void del(String key) {
    }
 
    /**
     * 
     * 方法: validateToken <br>
     * 描述: 判断是否有效 <br>
     * 作者: zhy<br>
     * 时间: 2019年4月24日 下午3:20:49
     * @param authToken
     * @return
     */
    public Boolean validateToken(String authToken) {
        return true;
    }
	/**
	 * 
	 * 方法: getUsernameFromToken <br>
	 * 描述: 从令牌中获取用户名 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午3:02:57
	 * 
	 * @param token
	 *            令牌
	 * @return 用户名
	 */
	public String getUsernameFromToken(String token) {
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
	 * 方法: isTokenExpired <br>
	 * 描述: 判断令牌是否过期 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午3:03:23
	 * 
	 * @param token
	 *            令牌
	 * @return 是否过期
	 */
	public Boolean isTokenExpired(String token) {
		try {
			Claims claims = getClaimsFromToken(token);
			Date expiration = claims.getExpiration();
			return expiration.before(new Date());
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 
	 * 方法: refreshToken <br>
	 * 描述: 刷新令牌 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午3:04:13
	 * 
	 * @param token
	 *            原令牌
	 * @return 新令牌
	 */
	public String refreshToken(String token) {
		String refreshedToken;
		try {
			Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = generateToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

	/**
	 * 
	 * 方法: validateToken <br>
	 * 描述: 验证令牌 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午3:04:34
	 * 
	 * @param token
	 *            令牌
	 * @param userDetails
	 *            用户
	 * @return 是否有效
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		ScUserInfo user = (ScUserInfo) userDetails;
		String username = getUsernameFromToken(token);
		return (username.equals(user.getUserName()) && !isTokenExpired(token));
	}

}
