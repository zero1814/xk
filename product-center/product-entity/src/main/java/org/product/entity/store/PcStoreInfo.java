package org.product.entity.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

@Entity
@Table(name = "pc_store_info")
public class PcStoreInfo extends BaseEntity {

	private static final long serialVersionUID = 4489490336780416138L;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "type",foreignKey=@ForeignKey(name="type_fk"))
	private PcStoreType type;

	@Column(name = "principal_name", length = 50, nullable = false)
	private String principalName;

	@Column(name = "principal_phone", length = 50, nullable = false)
	private String principalPhone;

	@Column(name = "icon_url", length = 200, nullable = false)
	private String iconUrl;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "status",foreignKey=@ForeignKey(name="status_fk"))
	private PcStoreStatus status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getPrincipalPhone() {
		return principalPhone;
	}

	public void setPrincipalPhone(String principalPhone) {
		this.principalPhone = principalPhone;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public PcStoreType getType() {
		return type;
	}

	public void setType(PcStoreType type) {
		this.type = type;
	}

	public PcStoreStatus getStatus() {
		return status;
	}

	public void setStatus(PcStoreStatus status) {
		this.status = status;
	}

}
