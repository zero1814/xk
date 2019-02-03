package org.system.entity;

import org.zero.spring.mybatis.BaseEntity;
/**
 * 
 * 类: ScUserInfo <br>
 * 描述: 用户表 <br>
 * 作者: zhy<br>
 * 时间: 2019年2月3日 下午1:46:54
 */
public class ScUserInfo extends BaseEntity {

	private static final long serialVersionUID = -8941966785314334390L;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 电子邮箱
	 */
	private String email;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 状态
	 */
	private String status;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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