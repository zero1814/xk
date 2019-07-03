package org.product.repository;

import java.util.List;

import org.product.entity.PcKeyword;
import org.springframework.data.jpa.repository.Query;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcKeywordRepository <br>
 * 描述: 常用关键词数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:47:02
 */
public interface PcKeywordRepository extends BaseRepository<PcKeyword, String> {

	/**
	 * 
	 * 方法: keywordAll <br>
	 * 描述: 查询可用关键字 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:55:34
	 * 
	 * @return
	 */
	@Query("select new PcKeyword(code,name) from PcKeyword where flagEnabled=0 order by createTime desc")
	List<PcKeyword> keywordAll();
}
