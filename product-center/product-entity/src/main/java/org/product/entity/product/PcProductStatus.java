package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "商品状态表")
public class PcProductStatus extends FlagEnabledEntity {

	private static final long serialVersionUID = -7099499428276362536L;

	public PcProductStatus() {

	}

	public PcProductStatus(String code, String name) {
		setCode(code);
		setName(name);
	}

	@Id
	@Column(name = "code", length = 50)
	@ApiModelProperty("编码")
	private String code;
	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	@ApiModelProperty("名称")
	private String name;
}
