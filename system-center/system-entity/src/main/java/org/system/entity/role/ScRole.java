package org.system.entity.role;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.system.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sc_role")
public class ScRole extends FlagEnabledEntity {

	private static final long serialVersionUID = -3569376630891554712L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	@NotBlank(message="访问url不能为空")
	private String name;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "sc_role_permission", joinColumns = { @JoinColumn(name = "role_code") }, inverseJoinColumns = {
			@JoinColumn(name = "permission_code") })
	private List<ScPermission> permissions;

}
