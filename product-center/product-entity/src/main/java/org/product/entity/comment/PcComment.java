package org.product.entity.comment;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.product.entity.label.PcLabel;
import org.product.entity.product.PcProduct;
import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcComment <br>
 * 描述: 商品评论 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月2日 下午2:35:59
 */
@Setter
@Getter
@Entity
@Table(name = "pc_comment")
public class PcComment extends BaseEntity {

	private static final long serialVersionUID = 2150168946407134291L;

	/**
	 * 商品编码
	 */
	@ManyToOne
	@JoinColumn(name = "product_code")
	private PcProduct product;

	/**
	 * 评价星数：0->5
	 */
	@Column(name = "start", columnDefinition = "int default 0")
	private Integer start;

	/**
	 * 评论内容
	 */
	@Column(name = "content", length = 500, nullable = false)
	private String content;

	/**
	 * 评论相册
	 */
	@OneToOne
	@JoinColumn(name = "album")
	private PcCommentAlbum album;

	/**
	 * 评价标签
	 */
	@OneToMany
	@JoinTable(name = "pc_comment_label", joinColumns = { @JoinColumn(name = "comment_code") }, inverseJoinColumns = {
			@JoinColumn(name = "label_code") })
	private List<PcLabel> labels;

	/**
	 * 评价回复列表
	 */
	@OneToMany
	@JoinTable(name = "comment_code")
	private List<PcCommentReplay> replays;
}
