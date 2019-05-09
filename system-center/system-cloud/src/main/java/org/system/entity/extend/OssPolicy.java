package org.system.entity.extend;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OssPolicy {

	/**
	 * 密钥
	 */
	private String accessKeyId;
	
	private String accessKeySecret;
	private String policy;
	private String signature;
	private String dir;
	private String host;

}
