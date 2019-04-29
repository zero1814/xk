package org.product.entity.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcStoreLevel <br>
 * 描述: 店铺等级 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:33:46
 */
@Getter
@Setter
@Entity
@Table(name = "pc_store_level")
public class PcStoreLevel extends FlagEnabledEntity {

	private static final long serialVersionUID = 1288800409170659739L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
}
