package org.system.entity.role;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private String name;

	@OneToMany
	@JoinTable(name = "sc_role_permission", joinColumns = { @JoinColumn(name = "role_code") }, inverseJoinColumns = {
			@JoinColumn(name = "permission_code") })
	private List<ScPermission> permissions;

}
