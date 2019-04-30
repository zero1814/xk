package org.product.entity.store;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.product.entity.product.PcProduct;
import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcStore <br>
 * 描述: 店铺 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:31:31
 */
@Getter
@Setter
@Entity
@Table(name = "pc_store")
public class PcStore extends BaseEntity {

	private static final long serialVersionUID = -7833056372217206242L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 图标
	 */
	@Column(name = "icon", length = 200, nullable = false)
	private String icon;

	/**
	 * logo
	 */
	@Column(name = "logo", length = 200, nullable = false)
	private String logo;

	/**
	 * 等级
	 */
	@ManyToOne
	@JoinColumn(name = "level")
	private PcStoreLevel level;

	/**
	 * 类型
	 */
	@ManyToOne
	@JoinColumn(name = "type")
	private PcStoreType type;

	/**
	 * 状态
	 */
	@ManyToOne
	@JoinColumn(name = "status")
	private PcStoreStatus status;

	@OneToMany
	@JoinColumn(name = "store")
	private List<PcProduct> productList;
}
