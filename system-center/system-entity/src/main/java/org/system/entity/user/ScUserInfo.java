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

import org.system.entity.role.ScRole;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "系统用户", parent = BaseEntity.class)
public class ScUserInfo extends BaseEntity {
	private static final long serialVersionUID = 4039559291617099759L;

	@ApiModelProperty("真实姓名")
	@Column(name = "real_name", length = 50, nullable = false)
	private String realName;

	@ApiModelProperty("头像")
	@Column(name = "header_pic", length = 200)
	private String headerPic;

	@ApiModelProperty("用户名")
	@Column(name = "user_name", length = 50, nullable = false, unique = true)
	private String userName;

	@ApiModelProperty("密码")
	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@ApiModelProperty("手机号")
	@Column(name = "phone", length = 50, nullable = false, unique = true)
	private String phone;

	@Column(name = "e_mail", length = 50, nullable = false, unique = true)
	private String mail;

	@ApiModelProperty("用户状态")
	@ManyToOne
	@JoinColumn(name = "status")
	private ScUserStatus status;

	/**
	 * 用户角色关系表
	 */
	@ApiModelProperty("用户角色列表")
	@OneToMany
	@JoinTable(name = "sc_user_role", joinColumns = { @JoinColumn(name = "user_code") }, inverseJoinColumns = {
			@JoinColumn(name = "role_code") })
	private List<ScRole> roles;

	/**
	 * 用户token
	 */
	@ApiModelProperty("用户token")
	@Transient
	private String token;

	/**
	 * 新密码
	 */
	@ApiModelProperty("新密码")
	@Transient
	private String newPassword;

}
