package org.product.entity.activity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.product.entity.album.PcAlbum;
import org.zero.spring.jpa.BaseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcActivity <br>
 * 描述: 活动 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午2:46:12
 */
@Getter
@Setter
@Entity
@Table(name = "pc_activity")
public class PcActivity extends BaseEntity {

	private static final long serialVersionUID = 5035818803827796670L;

	/**
	 * 标题
	 */
	@Column(name = "title", length = 100, nullable = false)
	private String title;

	/**
	 * 副标题
	 */
	@Column(name = "subheading", length = 100, nullable = false)
	private String subheading;

	/**
	 * 主图
	 */
	@JsonProperty(value = "main_pic")
	@Column(name = "main_pic", length = 100, nullable = false)
	private String mainPic;

	/**
	 * 开始时间
	 */
	@Column(name = "start_time", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date startTime;

	/**
	 * 结束时间
	 */
	@Column(name = "end_time", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date endTime;

	/**
	 * 简介
	 */
	@Column(name = "intro", nullable = false)
	private String intro;

	/**
	 * 类型
	 */
	@ManyToOne
	@JoinColumn(name = "type")
	private PcActivityType type;

	/**
	 * 相册
	 */
	@OneToOne
	@JoinColumn(name = "album")
	private PcAlbum album;

	/**
	 * 状态
	 */
	@ManyToOne
	@JoinColumn(name = "status")
	private PcActivityStatus status;
	
	@OneToMany
	@JoinColumn(name="activity")
	private List<PcActivityProduct> products;

}
