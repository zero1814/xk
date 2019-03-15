package org.system.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: ScUserInfo <br>
 * 描述: 系统用户管理表<br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 上午11:07:39
 */
@Entity
@Table(name = "sc_user_info")
public class ScUserInfo extends BaseEntity {
	private static final long serialVersionUID = 4039559291617099759L;

	@Column(name = "real_name", length = 50, nullable = false)
	private String realName;

	@Column(name = "user_name", length = 50, nullable = false, unique = true)
	private String userName;

	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@Column(name = "phone", length = 50, nullable = false, unique = true)
	private String phone;

	@Column(name = "e_mail", length = 50, nullable = false, unique = true)
	private String eMail;

	@ManyToOne
	@JoinColumn(name = "type")
	private ScUserType type;

	@ManyToOne
	@JoinColumn(name = "status")
	private ScUserStatus status;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public ScUserType getType() {
		return type;
	}

	public void setType(ScUserType type) {
		this.type = type;
	}

	public ScUserStatus getStatus() {
		return status;
	}

	public void setStatus(ScUserStatus status) {
		this.status = status;
	}

}
