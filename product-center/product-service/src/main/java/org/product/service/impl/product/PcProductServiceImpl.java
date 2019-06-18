package org.product.service.impl.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.product.entity.PcAlbum;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcProductAttribute;
import org.product.entity.product.PcSku;
import org.product.query.product.PcProductQuery;
import org.product.repository.product.PcProductRepository;
import org.product.service.IPcAlbumService;
import org.product.service.product.IPcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.StringUtils;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.PageResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcProductServiceImpl <br>
 * 描述: 商品业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:18
 */
@Slf4j
@Service
public class PcProductServiceImpl extends BaseServiceImpl<PcProduct, String, PcProductRepository>
		implements IPcProductService {
	@Autowired
	private IPcAlbumService albumService;
	@Autowired
	private PcProductQuery query;

	@Override
	@Transactional
	public EntityResult<PcProduct> create(PcProduct entity) {
		EntityResult<PcProduct> result = new EntityResult<PcProduct>();
		if (entity.getAlbum() != null) {
			int total = entity.getAlbum().getPics().size();
			entity.getAlbum().setTotal(BigDecimal.valueOf(total));
			EntityResult<PcAlbum> _result = albumService.create(entity.getAlbum());
			if (_result.getCode() != ResultType.SUCCESS) {
				result.setCode(_result.getCode());
				result.setMessage(_result.getMessage());
				return result;
			}
			entity.setAlbum(_result.getEntity());
		}
		List<PcProductAttribute> productAttributes = new ArrayList<PcProductAttribute>();
		if (entity.getAttributeList() != null && !entity.getAttributeList().isEmpty()) {
			for (PcProductAttribute ppa : entity.getAttributeList()) {
				String[] values = ppa.getValue().split(",");
				for (String value : values) {
					PcProductAttribute attribute = new PcProductAttribute();
					attribute.setCode(CodeHelper.getCode(PcProductAttribute.class));
					attribute.setName(ppa.getName());
					attribute.setValue(value);
					attribute.setSort(ppa.getSort());
					productAttributes.add(attribute);
				}
			}
		}
		entity.setAttributeList(productAttributes);
		BigDecimal minSellPrice = new BigDecimal(0.00);
		BigDecimal maxSellPrice = new BigDecimal(0.00);
		// 整理属性
		if (!entity.getSkuList().isEmpty() && entity.getSkuList().size() > 0) {
			minSellPrice = entity.getSkuList().get(0).getSellPrice();
			maxSellPrice = entity.getSkuList().get(0).getSellPrice();
			for (PcSku sku : entity.getSkuList()) {
				List<PcProductAttribute> skuAttributes = new ArrayList<PcProductAttribute>();
				for (PcProductAttribute attribute : entity.getAttributeList()) {
					for (PcProductAttribute productAttribute : productAttributes) {
						if (StringUtils.equals(attribute.getName(), productAttribute.getName())
								&& StringUtils.equals(attribute.getValue(), productAttribute.getValue())) {
							skuAttributes.add(productAttribute);
						} else {
							continue;
						}
					}
				}
				sku.setAttributes(skuAttributes);
				sku.setCreateUser(entity.getCreateUser());
				if (sku.getSellPrice().compareTo(minSellPrice) == -1) {
					minSellPrice = sku.getSellPrice();
				} else if (sku.getSellPrice().compareTo(maxSellPrice) == 1) {
					maxSellPrice = sku.getSellPrice();
				}
			}
		}
		entity.setCode(CodeHelper.getCode(PcProduct.class));
		entity.setMinSellPrice(minSellPrice);
		entity.setMaxSellPrice(maxSellPrice);
		System.out.println(JSON.toJSONString(entity));
		return super.create(entity);
	}

	public PageResult<PcProduct> page(PcProduct entity) {
		PageResult<PcProduct> result = new PageResult<PcProduct>();
		try {
			log.info("------------>查询商品列表");
			List<PcProduct> products = query.pageListQuery(entity);
			if (products == null || products.isEmpty()) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询为空");
				return result;
			}
			Long total = query.pageTotalQuery(entity);
			result.setData(products);
			result.setTotal(total);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询报错");
		}
		log.info("处理结果" + JSON.toJSONString(result));
		return result;
	}

	@Override
	@Transactional
	public EntityResult<PcProduct> getProduct(String code) {
		EntityResult<PcProduct> result = new EntityResult<PcProduct>();
		try {
			if (StringUtils.isBlank(code)) {
				result.setCode(ResultType.ERROR);
				result.setMessage("商品编码不能为空");
				return result;
			}
			PcProduct product = query.productQuery(code);
			if (product == null) {
				result.setCode(ResultType.NULL);
				result.setMessage("商品不存在");
				return result;
			}
			result.setCode(ResultType.SUCCESS);
			result.setEntity(product);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询失败");
		}
		return result;
	}
}
