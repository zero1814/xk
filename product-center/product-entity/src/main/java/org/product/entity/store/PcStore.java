package org.product.entity.store;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.product.entity.PcLabel;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_store")
@ApiModel(value = "店铺管理")
public class PcStore extends BaseEntity {

	private static final long serialVersionUID = -7833056372217206242L;

	public PcStore() {
	}

	public PcStore(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 50, unique = true)
	private String name;

	@ApiModelProperty("图标")
	@Column(name = "icon", length = 500)
	private String icon;

	@ApiModelProperty("logo")
	@Column(name = "logo", length = 500)
	private String logo;

	@ManyToOne
	@JoinColumn(name = "level")
	private PcStoreLevel level;

	@ManyToOne
	@JoinColumn(name = "status")
	private PcStoreStatus status;

	@ApiModelProperty("创建人")
	@Column(name = "create_user", length = 50, insertable = true, updatable = false, nullable = false)
	private String createUser;

	@ApiModelProperty("创建时间")
	@Column(name = "create_time", insertable = true, updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@ApiModelProperty("修改人")
	@Column(name = "update_user", length = 50, insertable = true, updatable = true, nullable = false)
	private String updateUser;

	@ApiModelProperty("修改时间")
	@Column(name = "update_time", insertable = true, updatable = true, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	/**
	 * 店铺标签
	 */
	@ApiModelProperty("店铺标签")
	@OneToMany
	@JoinTable(name = "pc_store_label", joinColumns = { @JoinColumn(name = "store") }, inverseJoinColumns = {
			@JoinColumn(name = "label", unique = false) }, uniqueConstraints = {
					@UniqueConstraint(columnNames = { "store", "label" }) })
	private List<PcLabel> labels;
}
