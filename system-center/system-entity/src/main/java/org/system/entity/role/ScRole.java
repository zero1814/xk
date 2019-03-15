package org.system.entity.role;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

@Entity
@Table(name = "sc_role")
public class ScRole extends BaseEntity {

	private static final long serialVersionUID = -3569376630891554712L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	/**
	 * 是否可用 0 可用 1 不可用
	 */
	@Column(name = "flag_enabled", columnDefinition = "int null default 0")
	private Integer flagEnabled;

	@OneToMany
	@JoinTable(name = "sc_role_api", joinColumns = { @JoinColumn(name = "role_code") }, inverseJoinColumns = {
			@JoinColumn(name = "api_code") })
	private List<ScApiInfo> api;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFlagEnabled() {
		return flagEnabled;
	}

	public void setFlagEnabled(Integer flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

}
