package org.system.entity;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScPermission <br>
 * 描述: 权限表 <br>
 * 作者: zhy<br>
 * 时间: 2019年2月3日 下午1:43:57
 */
public class ScPermission extends BaseEntity {

	private static final long serialVersionUID = -9121278231607667052L;

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