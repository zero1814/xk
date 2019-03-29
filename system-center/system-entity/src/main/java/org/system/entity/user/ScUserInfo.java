package org.system.entity.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.system.entity.role.ScRole;
import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: ScUserInfo <br>
 * 描述: 系统用户管理表<br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 上午11:07:39
 */
@Getter
@Setter
@Entity
@Table(name = "sc_user_info")
public class ScUserInfo extends BaseEntity {
	private static final long serialVersionUID = 4039559291617099759L;

	@Column(name = "real_name", length = 50, nullable = false)
	private String realName;

	@Column(name = "header_pic", length = 200)
	private String headerPic;

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

	@OneToMany
	@JoinTable(name = "sc_user_role", joinColumns = { @JoinColumn(name = "user_code") }, inverseJoinColumns = {
			@JoinColumn(name = "role_code") })
	private List<ScRole> roles;

}
