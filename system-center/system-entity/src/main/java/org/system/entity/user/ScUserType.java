package org.system.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.system.entity.FlagEnabledEntity;

/**
 * 
 * 类: ScUserType <br>
 * 描述: 系统用户类型维护表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 上午11:12:36
 */
@Entity
@Table(name = "sc_user_type")
public class ScUserType extends FlagEnabledEntity {

	private static final long serialVersionUID = -3569376630891554712L;

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
