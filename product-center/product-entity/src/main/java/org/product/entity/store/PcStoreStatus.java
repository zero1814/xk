package org.product.entity.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

/**
 * 
 * 类: PcStoreStatus <br>
 * 描述: 店铺状态表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:42:58
 */
@Entity
@Table(name = "pc_store_status")
public class PcStoreStatus extends FlagEnabledEntity {

	private static final long serialVersionUID = -6227512494370735977L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
