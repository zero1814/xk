package org.product.service;

import org.product.entity.PcKeyword;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: IPcKeywordsService <br>
 * 描述: 常用关键字业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:49:02
 */
public interface IPcKeywordsService extends IBaseService<PcKeyword, String> {

	/**
	 * 
	 * 方法: keywordAll <br>
	 * 描述: 查询可用关键字 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:57:50
	 * 
	 * @return
	 */
	DataResult<PcKeyword> keywordAll();
}
