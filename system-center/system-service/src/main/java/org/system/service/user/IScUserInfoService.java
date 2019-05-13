package org.system.service.user;

import org.system.dto.LoginParam;
import org.system.entity.user.ScUserInfo;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;

/**
 * 
 * 类: IScUserInfoService <br>
 * 描述: 系统用户表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:03:49
 */
public interface IScUserInfoService extends IBaseService<ScUserInfo, String> {

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 用户登录 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月8日 上午11:48:25
	 * 
	 * @param entity
	 * @return
	 */
	EntityResult<ScUserInfo> login(LoginParam param);

	/**
	 * 
	 * 方法: get <br>
	 * 描述: 根据token查询缓存用户信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月16日 下午5:28:33
	 * 
	 * @param token
	 * @return
	 */
	EntityResult<ScUserInfo> get(String token);

	/**
	 * 
	 * 方法: logout <br>
	 * 描述: 用户登出 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月8日 上午9:54:12
	 * 
	 * @param userCode
	 * @return
	 */
	BaseResult logout(String token);

}
