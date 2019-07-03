package org.product.repository.store;

import java.util.List;

import org.product.entity.store.PcStoreLevel;
import org.springframework.data.jpa.repository.Query;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcStoreLevelRepository <br>
 * 描述: 店铺等级数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:13:14
 */
public interface PcStoreLevelRepository extends BaseRepository<PcStoreLevel, String> {

	/**
	 * 
	 * 方法: all <br>
	 * 描述: 查询可用店铺等级 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:24:50
	 * 
	 * @param type
	 * @return
	 */
	@Query("select new PcStoreLevel(code,name) from PcStoreLevel where flagEnabled=0")
	public List<PcStoreLevel> all();
}