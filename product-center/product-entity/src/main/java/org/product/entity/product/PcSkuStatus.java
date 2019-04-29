package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcSkuStatus <br>
 * 描述: sku状态 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:24:29
 */
@Getter
@Setter
@Entity
@Table(name = "pc_sku_status")
public class PcSkuStatus extends FlagEnabledEntity {

	private static final long serialVersionUID = -3542785689740139359L;

	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
}
