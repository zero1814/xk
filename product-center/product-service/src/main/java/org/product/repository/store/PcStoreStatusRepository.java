package org.product.repository.store;

import java.util.List;

import org.product.entity.store.PcStoreStatus;
import org.springframework.data.jpa.repository.Query;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcStoreStatusRepository <br>
 * 描述: 店铺状态数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:13:43
 */
public interface PcStoreStatusRepository extends BaseRepository<PcStoreStatus, String> {

	/**
	 * 
	 * 方法: all <br>
	 * 描述: 查询可用店铺状态 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:24:50
	 * 
	 * @param type
	 * @return
	 */
	@Query("select new PcStoreStatus(code,name) from PcStoreStatus where flagEnabled=0")
	public List<PcStoreStatus> all();
}
