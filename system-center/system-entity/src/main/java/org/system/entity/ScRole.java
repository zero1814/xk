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
@ApiModel(value = "系统角色")
public class ScRole extends BaseEntity {

	private static final long serialVersionUID = 7881198167651082012L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@ApiModelProperty("是否可用 0 可用 1 不可用")
	@Column(name = "flag_enabled", columnDefinition = "int default 0 ", nullable = false)
	private Integer flagEnabled;

	@ApiModelProperty("是否已删除 0 未删除 1 已删除")
	@Column(name = "flag_deleted", columnDefinition = "int default 0 ", nullable = false)
	private Integer flagDeleted;

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

	@ApiModelProperty("角色权限")
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "sc_role_permission", joinColumns = {
			@JoinColumn(name = "role", unique = false) }, inverseJoinColumns = {
					@JoinColumn(name = "permission", unique = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "role", "permission" }) })
	private Set<ScPermission> permissions;
}
