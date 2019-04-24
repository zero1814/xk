package org.system.entity.user;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class ScUserInfoExtend extends ScUserInfo {

	private static final long serialVersionUID = 4240729963097405841L;

	/**
	 * 新密码
	 */
	@Transient
	private String newPassword;
}
