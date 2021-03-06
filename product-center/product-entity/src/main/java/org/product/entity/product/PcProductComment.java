package org.product.entity.product;

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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ps_product_comment")
@ApiModel(value = "商品评价管理")
public class PcProductComment extends BaseEntity {

	private static final long serialVersionUID = 635584964697556126L;

	public PcProductComment() {
	}

	public PcProductComment(List<PcProductCommentReply> replyList) {
		this.replyList = replyList;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;
	
	@ApiModelProperty("评价内容")
	@Column(name = "content", length = 1000, nullable = false)
	private String content;

	@ApiModelProperty("评价星级")
	@Column(name = "stars")
	private Integer stars;

	@ApiModelProperty("是否已删除 0 未删除 1 已删除")
	@Column(name = "flag_deleted")
	private Integer flagDeleted;

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

	@OneToMany
	@JoinColumn(name = "comment")
	@NotFound(action=NotFoundAction.IGNORE)
	List<PcProductCommentReply> replyList;
}
