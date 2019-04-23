package org.system.entity.role;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.system.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sc_permission")
public class ScPermission extends FlagEnabledEntity {

	private static final long serialVersionUID = -8444890942860733346L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	@NotBlank(message="名称不能为空")
	private String name;
	/**
	 * 访问url
	 */
	@Column(name = "url", length = 50, nullable = false, unique = true)
	@NotBlank(message="访问url不能为空")
	@Pattern(regexp="/^(?:([A-Za-z]+):)?(\\/{0,3})([0-9.\\-A-Za-z]+)(?::(\\d+))?(?:\\/([^?#]*))?(?:\\?([^#]*))?(?:#(.*))?$/",message="请输入合法的url地址")
	private String url;

	/**
	 * 权限描述
	 */
	@Column(name = "permission", length = 200, nullable = false)
	private String permission;

	/**
	 * 父级编码
	 */
	@ManyToOne
	@JoinColumn(name = "parent_code")
	private ScPermission parent;

	/**
	 * 子权限列表
	 */
	@OneToMany
	@JoinColumn(name = "parent_code")
	private List<ScPermission> children;
}
