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
 * 描述: 商品状态 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:15:13
 */
@Getter
@Setter
@Entity
@Table(name = "pc_product_status")
public class PcProductStatus extends FlagEnabledEntity {

	private static final long serialVersionUID = -7099499428276362536L;

	public PcProductStatus() {

	}

	public PcProductStatus(String code, String name) {
		setCode(code);
		setName(name);
	}

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
}
