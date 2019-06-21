package org.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_photograph")
@ApiModel(value = "相册图集")
public class PcPicture extends BaseEntity {

	private static final long serialVersionUID = -4517833807136641322L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("图片访问地址")
	@Column(name = "pic_url", insertable = true, nullable = false)
	private String picUrl;

	/**
	 * 标题: 构造器 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月17日 下午2:41:34
	 */
	public PcPicture() {
	}

	/**
	 * 标题: 构造器 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月17日 下午2:41:44
	 * 
	 * @param code
	 * @param picUrl
	 */
	public PcPicture(String code, String picUrl) {
		this.code = code;
		this.picUrl = picUrl;
	}
}
