package org.product.entity.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcCommentReplay <br>
 * 描述: 评价回复表 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月2日 下午3:33:14
 */
@Setter
@Getter
@Entity
@Table(name = "pc_comment_replay")
public class PcCommentReplay extends BaseEntity {

	private static final long serialVersionUID = 1731864687285877629L;

	/**
	 * 评论编码
	 */
	@ManyToOne
	@JoinColumn(name = "comment_code")
	private PcComment comment;

	@Column(name = "content", length = 500, nullable = false)
	private String content;
}
