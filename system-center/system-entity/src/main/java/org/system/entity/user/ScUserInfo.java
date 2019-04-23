package org.system.entity.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
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
	@NotBlank(message = "真实姓名不能为空")
	private String realName;

	@Column(name = "header_pic", length = 200)
	@NotBlank(message = "头像不能为空")
	private String headerPic;

	@Column(name = "user_name", length = 50, nullable = false, unique = true)
	@NotBlank(message = "用户名不能为空")
	private String userName;

	@Column(name = "password", length = 50, nullable = false)
	@NotBlank(message = "密码不能为空")
	@Length(min = 6, max = 10, message = "密码长度为6-10位")
	private String password;

	@Column(name = "phone", length = 50, nullable = false, unique = true)
	@NotBlank(message = "手机号不能为空")
	private String phone;

	@Column(name = "e_mail", length = 50, nullable = false, unique = true)
	@NotBlank(message = "电子邮箱不能为空")
	@Email(message = "电子邮箱格式不正确")
	private String eMail;

	@ManyToOne
	@JoinColumn(name = "status")
	@NotEmpty(message = "用户状态不能为空")
	private ScUserStatus status;

	/**
	 * 用户角色关系表
	 */
	@OneToMany
	@JoinTable(name = "sc_user_role", joinColumns = { @JoinColumn(name = "user_code") }, inverseJoinColumns = {
			@JoinColumn(name = "role_code") })
	private List<ScRole> roles;

	/**
	 * 用户token
	 */
	@Transient
	private String token;

}
