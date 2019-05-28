package org.product.repository.label;

import java.util.List;

import org.product.entity.PcLabel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcLabelRepository <br>
 * 描述: 标签数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:06:30
 */
public interface PcLabelRepository extends BaseRepository<PcLabel, String> {

	/**
	 * 
	 * 方法: all <br>
	 * 描述: 根据类型查询可用标签 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:28:11
	 * 
	 * @param type
	 * @return
	 */
	@Query("select new PcLabel(code,name) from PcLabel where flagEnabled=0 and type=:type order by sort desc,createTime desc")
	public List<PcLabel> all(@Param("type") Integer type);
}
