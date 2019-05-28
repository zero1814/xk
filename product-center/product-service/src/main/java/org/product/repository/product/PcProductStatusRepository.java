package org.product.repository.product;

import java.util.List;

import org.product.entity.product.PcProductStatus;
import org.springframework.data.jpa.repository.Query;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcProductStatusRepository <br>
 * 描述: 商品状态数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:10:17
 */
public interface PcProductStatusRepository extends BaseRepository<PcProductStatus, String> {

	@Query("select new PcProductStatus(code,name) from PcProductStatus where flagEnabled=0 order by createTime desc")
	public List<PcProductStatus> all();
}
