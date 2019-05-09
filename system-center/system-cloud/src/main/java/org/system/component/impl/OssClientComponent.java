package org.system.component.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.system.component.IOssClientComponent;
import org.system.entity.extend.OssCallback;
import org.system.entity.extend.OssPolicy;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;

import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

@Component
public class OssClientComponent implements IOssClientComponent {

	@Value("${aliyun.oss.policy.expire}")
	private int ALIYUN_OSS_EXPIRE;
	@Value("${aliyun.oss.maxSize}")
	private int ALIYUN_OSS_MAX_SIZE;
	@Value("${aliyun.oss.bucketName}")
	private String ALIYUN_OSS_BUCKET_NAME;
	@Value("${aliyun.oss.endpoint}")
	private String ALIYUN_OSS_ENDPOINT;
	@Value("${aliyun.oss.dir.prefix}")
	private String ALIYUN_OSS_DIR_PREFIX;
	@Value("${aliyun.oss.accessKeyId}")
	private String ALIYUN_OSS_ACCESSKEYID;
	@Autowired
	private OSS client;

	/**
	 * 
	 * 方法: policy <br>
	 * 描述: 签名生成
	 * 
	 * @return
	 * @see org.system.component.IOssClientComponent#policy()
	 */
	@Override
	public EntityResult<OssPolicy> policy(String path) {
		EntityResult<OssPolicy> result = new EntityResult<OssPolicy>();
		// 存储目录
		String dir = ALIYUN_OSS_DIR_PREFIX + path;
		// 签名有效期
		long expireEndTime = System.currentTimeMillis() + ALIYUN_OSS_EXPIRE * 1000;
		Date expiration = new Date(expireEndTime);
		// 文件大小
		long maxSize = ALIYUN_OSS_MAX_SIZE * 1024 * 1024;
		String action = "http://" + ALIYUN_OSS_BUCKET_NAME + "." + ALIYUN_OSS_ENDPOINT;
		try {
			PolicyConditions policyConds = new PolicyConditions();
			policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, maxSize);
			policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
			String postPolicy = client.generatePostPolicy(expiration, policyConds);
			byte[] binaryData = postPolicy.getBytes("utf-8");
			String policy = BinaryUtil.toBase64String(binaryData);
			String signature = client.calculatePostSignature(postPolicy);
			OssPolicy _policy = new OssPolicy();
			_policy.setPolicy(policy);
			_policy.setSignature(signature);
			_policy.setAccessKeyId(ALIYUN_OSS_ACCESSKEYID);
			_policy.setDir(dir);
			_policy.setHost(action);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("签名成功");
			result.setEntity(_policy);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("阿里云签名创建错误，错误原因：" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: createBucket <br>
	 * 
	 * @param name
	 * @return
	 * @see org.system.component.IOssClientComponent#createBucket(java.lang.String)
	 */
	@Override
	public EntityResult<Bucket> createBucket(String name) {
		EntityResult<Bucket> result = new EntityResult<Bucket>();
		try {
			Bucket bucket = client.createBucket(name);
			if (bucket != null) {
				result.setCode(ResultType.SUCCESS);
				result.setMessage("创建成功");
				result.setEntity(bucket);
			} else {
				result.setCode(ResultType.ERROR);
				result.setMessage("创建失败");
			}
			client.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("创建报错，错误原因：" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: callback <br>
	 * 描述: TODO
	 * 
	 * @param request
	 * @return
	 * @see org.system.component.IOssClientComponent#callback(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public EntityResult<OssCallback> callback(HttpServletRequest request) {
		OssCallback callback = new OssCallback();
		String filename = request.getParameter("filename");
		filename = "http://".concat(ALIYUN_OSS_BUCKET_NAME).concat(".").concat(ALIYUN_OSS_ENDPOINT).concat("/")
				.concat(filename);
		callback.setFilename(filename);
		callback.setSize(request.getParameter("size"));
		callback.setMimeType(request.getParameter("mimeType"));
		callback.setWidth(request.getParameter("width"));
		callback.setHeight(request.getParameter("height"));
		EntityResult<OssCallback> result = new EntityResult<OssCallback>();
		result.setCode(ResultType.SUCCESS);
		result.setMessage("提交成功");
		return result;
	}

}
