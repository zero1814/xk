package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_product_attribute")
public class PcProductAttribute extends FlagEnabledEntity {

	private static final long serialVersionUID = 3311919813516625433L;

	/**
	 * 属性名称
	 */
	@Column(name = "attr_key", length = 100, nullable = false)
	private String attrKey;

	/**
	 * 属性值
	 */
	@Column(name = "attr_value", length = 500, nullable = false)
	private String attrValue;
}
