package org.product.entity.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_activity_type")
@ApiModel("活动类型")
public class PcActivityType extends FlagEnabledEntity {

	private static final long serialVersionUID = 3037597503569263399L;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false,unique=true)
	private String name;
}
