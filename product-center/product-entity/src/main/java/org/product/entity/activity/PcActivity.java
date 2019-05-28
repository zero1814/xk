package org.product.entity.activity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_activity", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "title", "start_time", "end_time" }) })
@ApiModel(value = "活动管理")
public class PcActivity extends BaseEntity {

	private static final long serialVersionUID = -5995695622362979571L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50)
	private String code;

	@ApiModelProperty("标题")
	@Column(name = "title", length = 100)
	private String title;

	@ApiModelProperty("副标题")
	@Column(name = "subheading", length = 200)
	private String subheading;

	@ApiModelProperty("主图")
	@Column(name = "main_pic", length = 50)
	private String mainPic;

	@ApiModelProperty("开始时间")
	@Column(name = "start_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	@ApiModelProperty("结束时间")
	@Column(name = "end_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	@ApiModelProperty("简介")
	@Column(name = "intro", length = 1000)
	private String intro;

	@ApiModelProperty("类型")
	@ManyToOne
	@JoinColumn(name = "type")
	private PcActivityType type;

	@ApiModelProperty("状态")
	@ManyToOne
	@JoinColumn(name = "status")
	private PcActivityStatus status;

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

	@ApiModelProperty("活动商品集合")
	@OneToMany
	@JoinColumn(name = "activity")
	private List<PcActivityProduct> productList;
}
