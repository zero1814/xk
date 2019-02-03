package org.system.entity;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScMenu <br>
 * 描述: 系统菜单 <br>
 * 作者: zhy<br>
 * 时间: 2019年2月3日 下午1:43:37
 */
public class ScMenu extends BaseEntity {

	private static final long serialVersionUID = 632534795462058462L;

	/**
	 * 父级编码
	 */
	private String parentCode;
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 链接url
	 */
	private String linkUrl;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 状态
	 */
	private String status;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}