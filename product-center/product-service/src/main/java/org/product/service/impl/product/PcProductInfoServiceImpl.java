package org.product.service.impl.product;

import java.util.List;

import org.product.entity.product.PcBrandInfo;
import org.product.entity.product.PcCategory;
import org.product.entity.product.PcLabel;
import org.product.entity.product.PcProductInfo;
import org.product.repository.product.PcBrandInfoRepository;
import org.product.repository.product.PcCategoryRepository;
import org.product.repository.product.PcLabelRepository;
import org.product.repository.product.PcProductInfoRepository;
import org.product.result.PcProductResult;
import org.product.service.product.IPcProductInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.ResultType;

@Service
public class PcProductInfoServiceImpl extends BaseServiceImpl<PcProductInfo, String, PcProductInfoRepository>
		implements IPcProductInfoService {
	private static final Logger logger = LoggerFactory.getLogger(PcProductInfoServiceImpl.class);
	@Autowired
	private PcBrandInfoRepository brandRepository;
	@Autowired
	private PcCategoryRepository categoryRepository;
	@Autowired
	private PcLabelRepository labelRepository;

	/**
	 * 
	 * 方法: initProperties <br>
	 * 
	 * @return
	 * @see org.product.service.product.IPcProductInfoService#initProperties()
	 */
	@Override
	public PcProductResult initProperties() {
		PcProductResult result = new PcProductResult();
		try {
			List<PcBrandInfo> brandList = brandRepository.findAll(Example.of(new PcBrandInfo(0)));
			result.setBrandList(brandList);
			List<PcCategory> categoryList = categoryRepository.findAll(Example.of(new PcCategory(0)));
			result.setCategoryList(categoryList);
			List<PcLabel> labelList = labelRepository.findAll(Example.of(new PcLabel(0)));
			result.setLabelList(labelList);
			result.setCode(ResultType.SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("查询商品参数报错，错误原因：" + e.getMessage());
		}
		return result;
	}

}
