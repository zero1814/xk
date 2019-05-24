package org.product.entity.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="活动")
public class PcActivity extends BaseEntity {

	private static final long serialVersionUID = -3247434195162479668L;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "副标题")
	private String subheading;

	@ApiModelProperty(value = "主图")
	private String mainPic;

	@ApiModelProperty(value = "开始时间")
	private Date startTime;

	@ApiModelProperty(value = "结束时间")
	private Date endTime;

	@ApiModelProperty(value = "描述")
	private String intro;

	@ApiModelProperty(value = "相册")
	private String album;

	@ApiModelProperty(value = "类型")
	private String type;

	@ApiModelProperty(value = "状态")
	private String status;
}