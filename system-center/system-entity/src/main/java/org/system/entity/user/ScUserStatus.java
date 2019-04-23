package org.system.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.system.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: ScUserStatus <br>
 * 描述: 系统用户状态维护表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 上午11:09:47
 */
@Getter
@Setter
@Entity
@Table(name = "sc_user_status")
public class ScUserStatus extends FlagEnabledEntity {

	private static final long serialVersionUID = 6072090065005059927L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	@NotBlank(message="名称不能为空")
	private String name;

}
