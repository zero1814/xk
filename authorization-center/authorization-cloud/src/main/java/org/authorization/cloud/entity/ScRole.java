package org.authorization.cloud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sc_role")
public class ScRole extends BaseEntity implements GrantedAuthority {

	private static final long serialVersionUID = -7403705598868166058L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "sc_role_permission", joinColumns = {
			@JoinColumn(name = "role", unique = false) }, inverseJoinColumns = {
					@JoinColumn(name = "permission", unique = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "role", "permission" }) })
	private List<ScRole> authorities;

	@Override
	public String getAuthority() {
		return name;
	}

}
