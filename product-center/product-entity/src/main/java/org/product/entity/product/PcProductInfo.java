package org.product.entity.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.product.entity.store.PcStoreInfo;
import org.zero.spring.jpa.BaseEntity;

@Entity
@Table(name = "pc_product_info")
public class PcProductInfo extends BaseEntity {

	private static final long serialVersionUID = 7284650462326135240L;

	/**
	 * 店铺编码
	 */
	@ManyToOne
	@JoinColumn(name = "store_code")
	private PcStoreInfo store;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 英文名称
	 */
	@Column(name = "en_name", length = 50, nullable = false)
	private String enName;

	/**
	 * 分类编码
	 */
	@ManyToOne
	@JoinColumn(name = "category_code")
	private PcCategory category;

	/**
	 * 品牌编码
	 */
	@ManyToOne
	@JoinColumn(name = "brand_code")
	private PcBrandInfo brand;

	@ManyToOne
	@JoinColumn(name = "status")
	private PcProductStatus status;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "pc_product_label", joinColumns = {
			@JoinColumn(name = "product_code", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)) })
	private List<PcLabel> labels;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "product_code")
	private List<PcProductPic> pics;

	public List<PcLabel> getLabels() {
		return labels;
	}

	public void setLabels(List<PcLabel> labels) {
		this.labels = labels;
	}

	public PcStoreInfo getStore() {
		return store;
	}

	public void setStore(PcStoreInfo store) {
		this.store = store;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public PcCategory getCategory() {
		return category;
	}

	public void setCategory(PcCategory category) {
		this.category = category;
	}

	public PcBrandInfo getBrand() {
		return brand;
	}

	public void setBrand(PcBrandInfo brand) {
		this.brand = brand;
	}

	public PcProductStatus getStatus() {
		return status;
	}

	public void setStatus(PcProductStatus status) {
		this.status = status;
	}

}