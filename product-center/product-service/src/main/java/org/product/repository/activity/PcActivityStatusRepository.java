package org.product.repository.activity;

import java.util.List;

import org.product.entity.activity.PcActivityStatus;
import org.springframework.data.jpa.repository.Query;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcActivityStatusRepository <br>
 * 描述: 活动状态数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:53:12
 */
public interface PcActivityStatusRepository extends BaseRepository<PcActivityStatus, String> {

	/**
	 * 
	 * 方法: statusAll <br>
	 * 描述: 查询可用活动状态 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:50:13
	 * 
	 * @return
	 */
	@Query("select new PcActivityStatus(code,name) from PcActivityStatus where flagEnabled=0 order by createTime desc")
	List<PcActivityStatus> statusAll();
}
