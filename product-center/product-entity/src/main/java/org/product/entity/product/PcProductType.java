package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcProductType <br>
 * 描述: 商品类型 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:15:22
 */
@Getter
@Setter
@Entity
@Table(name = "pc_product")
public class PcProductType extends FlagEnabledEntity {

	private static final long serialVersionUID = -5440105805994876355L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
}
