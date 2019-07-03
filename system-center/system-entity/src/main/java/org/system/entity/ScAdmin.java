package org.system.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sc_admin")
@ApiModel(value = "系统用户")
public class ScAdmin extends BaseEntity {

	private static final long serialVersionUID = 8695264187581823945L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("名称")
	@Column(name = "nick_name", length = 100, nullable = false)
	private String nickName;

	@ApiModelProperty("用户名")
	@Column(name = "user_name", length = 100, nullable = false, unique = true)
	private String userName;

	@ApiModelProperty("密码")
	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@ApiModelProperty("电子邮件")
	@Column(name = "e_mail", length = 200, nullable = false)
	private String eMail;

	@ApiModelProperty("创建人")
	@Column(name = "create_user", length = 50, insertable = true, updatable = false, nullable = false)
	private String createUser;

	@ApiModelProperty("创建时间")
	@Column(name = "create_time", insertable = true, updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@ApiModelProperty("修改人")
	@Column(name = "update_user", length = 50, insertable = true, updatable = true, nullable = false)
	private String updateUser;

	@ApiModelProperty("修改时间")
	@Column(name = "update_time", insertable = true, updatable = true, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	@ApiModelProperty("管理员角色")
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "sc_admin_role", joinColumns = {
			@JoinColumn(name = "admin", unique = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role", unique = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "admin", "role" }) })
	private Set<ScRole> roles;
}
