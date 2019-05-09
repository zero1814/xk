package org.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

/**
 * 
 * 类: OssConfig <br>
 * 描述: 阿里云oss配置 <br>
 * 作者: zhy<br>
 * 时间: 2019年5月8日 下午2:54:21
 */
@Configuration
public class OssConfig {
	@Value("${aliyun.oss.endpoint}")
	private String ALIYUN_OSS_ENDPOINT;
	@Value("${aliyun.oss.accessKeyId}")
	private String ALIYUN_OSS_ACCESSKEYID;
	@Value("${aliyun.oss.accessKeySecret}")
	private String ALIYUN_OSS_ACCESSKEYSECRET;

	@Bean
	public OSS ossClient() {
		OSSClientBuilder builder = new OSSClientBuilder();
		OSS oss = builder.build(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID, ALIYUN_OSS_ACCESSKEYSECRET);
		return oss;
	}
}
