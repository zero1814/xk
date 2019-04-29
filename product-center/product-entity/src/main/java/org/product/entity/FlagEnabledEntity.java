package org.product.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@MappedSuperclass
@ApiModel(parent = BaseEntity.class)
public class FlagEnabledEntity extends BaseEntity {

	private static final long serialVersionUID = -8347045613257565292L;

	public FlagEnabledEntity() {

	}

	public FlagEnabledEntity(int flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

	/**
	 * 是否可用 0 可用 1 不可用
	 */
	@Column(name = "flag_enabled", columnDefinition = "int default 0")
	@ApiModelProperty(value="可用状态")
	private Integer flagEnabled;

	public Integer getFlagEnabled() {
		return flagEnabled;
	}

	public void setFlagEnabled(Integer flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

}
