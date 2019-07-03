package org.product.repository;

import java.util.List;

import org.product.entity.PcBrand;
import org.springframework.data.jpa.repository.Query;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcBrandRepository <br>
 * 描述: 品牌数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:46:15
 */
public interface PcBrandRepository extends BaseRepository<PcBrand, String> {

	/**
	 * 
	 * 方法: brandAll <br>
	 * 描述: 查询可用品牌 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:55:34
	 * 
	 * @return
	 */
	@Query("select new PcBrand(code,name) from PcBrand where flagEnabled=0 order by sort desc")
	List<PcBrand> brandAll();
}
