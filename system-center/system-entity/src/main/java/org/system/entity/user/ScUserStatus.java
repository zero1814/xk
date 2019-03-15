package org.system.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.system.entity.FlagEnabledEntity;

/**
 * 
 * 类: ScUserStatus <br>
 * 描述: 系统用户状态维护表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 上午11:09:47
 */
@Entity
@Table(name = "sc_user_status")
public class ScUserStatus extends FlagEnabledEntity {

	private static final long serialVersionUID = 6072090065005059927L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
