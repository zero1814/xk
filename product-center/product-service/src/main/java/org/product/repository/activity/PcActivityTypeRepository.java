package org.product.repository.activity;

import java.util.List;

import org.product.entity.activity.PcActivityType;
import org.springframework.data.jpa.repository.Query;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcActivityTypeRepository <br>
 * 描述: 活动类型数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:53:43
 */
public interface PcActivityTypeRepository extends BaseRepository<PcActivityType, String> {

	/**
	 * 
	 * 方法: statusAll <br>
	 * 描述: 查询可用活动类型 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:50:13
	 * 
	 * @return
	 */
	@Query("select new PcActivityType(code,name) from PcActivityType where flagEnabled=0 order by createTime desc")
	List<PcActivityType> statusAll();
}
