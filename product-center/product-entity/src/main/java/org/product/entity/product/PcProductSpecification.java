package org.product.entity.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_product_specification", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "product", "name" }) })
@ApiModel(value = "商品规格参数管理")
public class PcProductSpecification extends BaseEntity {

	private static final long serialVersionUID = 8699451341546241659L;

	public PcProductSpecification() {

	}

	public PcProductSpecification(String code, List<PcProductSpecificationValue> specValues) {
		this.code = code;
		this.specValues = specValues;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "product")
	private PcProduct product;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@ApiModelProperty("排序")
	@Column(name = "sort", length = 100, nullable = false)
	private Integer sort;

	@ApiModelProperty("商品规格参数值列表")
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	@JoinColumn(name = "specification")
	private List<PcProductSpecificationValue> specValues;

}
