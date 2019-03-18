package org.system.service.user;

import org.system.entity.user.ScUserInfo;
import org.system.result.user.ScUserPropertyResult;
import org.zero.spring.jpa.IBaseService;

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
	 * 方法: initProperty <br>
	 * 描述: 获取用户的初始化参数 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年3月18日 上午9:12:21
	 * 
	 * @return
	 */
	ScUserPropertyResult initProperty();
}
