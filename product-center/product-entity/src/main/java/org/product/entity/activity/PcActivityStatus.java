package org.product.entity.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcActivityStatus <br>
 * 描述: 活动状态 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午2:50:12
 */
@Getter
@Setter
@Entity
@Table(name = "pc_activity_status")
@ApiModel("活动状态")
public class PcActivityStatus extends FlagEnabledEntity {

	private static final long serialVersionUID = 5254869214130216041L;
	@ApiModelProperty("名称")
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
}
