package org.product.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_album")
@ApiModel(value = "相册")
public class PcAlbum extends BaseEntity {

	private static final long serialVersionUID = -6809628359436907353L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50)
	private String code;

	@ApiModelProperty("相册照片总数")
	@Column(name = "total")
	private BigDecimal total;

	@OneToMany
	@JoinColumn(name = "album")
	private List<PcAlbumPic> pic;
	
	@Column(name = "create_time", insertable = true, updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creatTime;
}
