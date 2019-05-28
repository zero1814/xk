package org.product.repository.product;

import java.util.List;

import org.product.entity.product.PcSkuStatus;
import org.springframework.data.jpa.repository.Query;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcSkuStatusRepository <br>
 * 描述: 商品sku数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:11:57
 */
public interface PcSkuStatusRepository extends BaseRepository<PcSkuStatus, String> {

	/**
	 * 
	 * 方法: all <br>
	 * 描述: 查询可用状态 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:46:42
	 * 
	 * @return
	 */
	@Query("select new PcSkuStatus(code,name) from PcSkuStatus where flagEnabled=0 order by creatTime desc")
	List<PcSkuStatus> all();
}
