package org.system.entity;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScRole <br>
 * 描述: 角色表 <br>
 * 作者: zhy<br>
 * 时间: 2019年2月3日 下午1:44:34
 */
public class ScRole extends BaseEntity {

	private static final long serialVersionUID = -7906771805541954362L;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 状态
	 */
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}