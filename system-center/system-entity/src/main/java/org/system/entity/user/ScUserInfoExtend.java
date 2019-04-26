package org.system.entity.user;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@ApiModel(value="用户扩展类",parent=ScUserInfo.class)
public class ScUserInfoExtend extends ScUserInfo {

	private static final long serialVersionUID = 4240729963097405841L;

	/**
	 * 新密码
	 */
	@ApiModelProperty("新密码")
	@Transient
	private String newPassword;
}
