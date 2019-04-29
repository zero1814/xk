package org.product.entity.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.product.entity.product.PcProduct;
import org.product.entity.product.PcSku;
import org.product.entity.store.PcStore;
import org.zero.spring.jpa.BaseEntity;

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
public class PcActivityProduct extends BaseEntity {

	private static final long serialVersionUID = -7643204064521311008L;

	/**
	 * 活动编码
	 */
	@ManyToOne
	@JoinColumn(name = "activity")
	private PcActivity activity;

	/**
	 * 店铺编码
	 */
	@ManyToOne
	@JoinColumn(name = "store")
	private PcStore store;

	/**
	 * 商品编码
	 */
	@ManyToOne
	@JoinColumn(name = "store")
	private PcProduct product;

	/**
	 * 店铺编码
	 */
	@OneToOne
	@JoinColumn(name = "sku")
	private PcSku sku;
	/**
	 * 商品活动库存
	 */
	@Column(name = "stock", nullable = false)
	private Long stock;
}
