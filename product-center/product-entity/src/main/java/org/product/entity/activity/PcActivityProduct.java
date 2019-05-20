package org.product.entity.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.product.entity.product.PcProduct;
import org.product.entity.product.PcSku;
import org.product.entity.store.PcStore;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcActivityProduct <br>
 * 描述: 活动商品 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午2:46:39
 */
@Getter
@Setter
@Entity
@Table(name = "pc_activity_product")
@ApiModel("活动商品列表")
public class PcActivityProduct extends BaseEntity {

	private static final long serialVersionUID = -7643204064521311008L;

	@ApiModelProperty("店铺")
	@OneToOne
	@JoinColumn(name = "store")
	private PcStore store;

	@ApiModelProperty("商品")
	@OneToOne
	@JoinColumn(name = "product")
	private PcProduct product;

	@ApiModelProperty("商品sku")
	@OneToOne
	@JoinColumn(name = "sku")
	private PcSku sku;
	/**
	 * 商品活动库存
	 */
	@ApiModelProperty("商品活动库存")
	@Column(name = "stock", nullable = false)
	private Long stock;
}
