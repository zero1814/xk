package org.file.service;

import javax.servlet.http.HttpServletRequest;

import org.file.entity.OssCallback;
import org.file.entity.OssPolicy;

import com.aliyun.oss.model.Bucket;

import zero.commons.basics.result.EntityResult;

public interface IOssClientService {

	EntityResult<OssPolicy> policy(String path);

	/**
	 * 
	 * 方法: createBucket <br>
	 * 描述: 创建存储空间 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月8日 下午3:56:10
	 * 
	 * @param name
	 * @return
	 */
	EntityResult<Bucket> createBucket(String name);

	/**
	 * 
	 * 方法: callback <br>
	 * 描述: oss回调函数 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月8日 下午4:51:00
	 * 
	 * @param request
	 * @return
	 */
	EntityResult<OssCallback> callback(HttpServletRequest request);

}
