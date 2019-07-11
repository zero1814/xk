package org.authorization.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sc_permission")
public class ScPermission extends BaseEntity {

	private static final long serialVersionUID = -5189077557431767000L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;
}
