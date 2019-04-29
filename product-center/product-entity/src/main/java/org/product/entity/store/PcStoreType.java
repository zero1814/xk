package org.product.entity.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * 类: PcStoreType <br>
 * 描述: 店铺类型 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:33:31
 */
@Getter
@Setter
@Entity
@Table(name = "pc_store_type")
public class PcStoreType extends FlagEnabledEntity {

	private static final long serialVersionUID = 4526615436453852504L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
}
