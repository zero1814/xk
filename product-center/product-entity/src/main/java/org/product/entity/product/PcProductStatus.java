package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcProductStatus <br>
 * 描述: 商品状态表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:51:08
 */
@Getter
@Setter
@Entity
@Table(name = "pc_product_status")
public class PcProductStatus extends FlagEnabledEntity {

	private static final long serialVersionUID = -1382764944182869324L;
	@Column(name = "name", length = 50, nullable = false)
	private String name;

}
