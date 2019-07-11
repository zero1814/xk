package org.authorization.cloud.entity;

import java.util.Collection;
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
import org.springframework.security.core.userdetails.UserDetails;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sc_user")
public class ScUser extends BaseEntity implements UserDetails {

	private static final long serialVersionUID = 1011148391875393127L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@Column(name = "user_name", length = 100, nullable = false, unique = true)
	private String username;
	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "sc_user_role", joinColumns = {
			@JoinColumn(name = "user", unique = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role", unique = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "user", "role" }) })
	private List<ScRole> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
