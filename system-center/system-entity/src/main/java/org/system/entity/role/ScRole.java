package org.system.entity.role;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.system.entity.FlagEnabledEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sc_role")
@ApiModel(value = "系统角色", parent = FlagEnabledEntity.class)
public class ScRole extends FlagEnabledEntity {

	private static final long serialVersionUID = -3569376630891554712L;

	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	@ApiModelProperty("角色权限列表")
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "sc_role_permission", joinColumns = { @JoinColumn(name = "role_code") }, inverseJoinColumns = {
			@JoinColumn(name = "permission_code") })
	private List<ScPermission> permissions;

}
