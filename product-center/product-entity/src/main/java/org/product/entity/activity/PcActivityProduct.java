package org.product.entity.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.product.entity.product.PcSku;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_activity_product")
@ApiModel(value = "活动商品管理")
public class PcActivityProduct extends BaseEntity {

	private static final long serialVersionUID = -7643204064521311008L;

	@ApiModelProperty("商品sku")
	@ManyToOne
	@JoinColumn(name = "sku")
	private PcSku sku;

	@ApiModelProperty("商品sku活动库存")
	@Column(name = "stock")
	private Long stock;

}
