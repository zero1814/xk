package org.product.service.impl.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.transaction.Transactional;

import org.product.entity.PcKeyword;
import org.product.entity.PcLabel;
import org.product.entity.PcPicture;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcProductAttribute;
import org.product.entity.product.PcProductSpecification;
import org.product.entity.product.PcSku;
import org.product.query.product.PcProductQuery;
import org.product.repository.product.PcProductAttributeRepository;
import org.product.repository.product.PcProductRepository;
import org.product.repository.product.PcProductSpecificationRepository;
import org.product.repository.product.PcSkuRepository;
import org.product.service.product.IPcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.StringUtils;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.DataResult;
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
	private PcProductRepository repository;
	@Autowired
	private PcProductQuery query;
	@Autowired
	private PcProductSpecificationRepository ppsRepository;

	@Autowired
	private PcProductAttributeRepository ppaRepository;

	@Autowired
	private PcSkuRepository skuRepository;

	@Transactional
	public EntityResult<PcProduct> create(PcProduct entity) {
		// 商品属性
		List<PcProductAttribute> productAttributes = new ArrayList<PcProductAttribute>();
		String user = entity.getCreateUser();
		Date date = new Date();
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
		entity.setAttributeList(new HashSet<PcProductAttribute>(productAttributes));
		// 商品规格参数
		List<PcProductSpecification> productSpecifications = new ArrayList<PcProductSpecification>();
		if (entity.getSpecList() != null && !entity.getSpecList().isEmpty()) {
			for (PcProductSpecification ppa : entity.getSpecList()) {
				String[] values = ppa.getValue().split(",");
				for (String value : values) {
					PcProductSpecification spec = new PcProductSpecification();
					spec.setUid(CodeHelper.getUUID());
					spec.setCode(CodeHelper.getCode(PcProductSpecification.class));
					spec.setName(ppa.getName());
					spec.setValue(value);
					spec.setSort(ppa.getSort());
					productSpecifications.add(spec);
				}
			}
		}
		entity.setSpecList(productSpecifications);
		BigDecimal minSellPrice = new BigDecimal(0.00);
		BigDecimal maxSellPrice = new BigDecimal(0.00);
		// 整理SKU
		if (!entity.getSkuList().isEmpty() && entity.getSkuList().size() > 0) {
			for (PcSku sku : entity.getSkuList()) {
				sku.setUid(CodeHelper.getUUID());
				sku.setCode(CodeHelper.getCode(PcSku.class));
				// sku属性
				List<PcProductAttribute> skuAttributes = new ArrayList<PcProductAttribute>();
				for (PcProductAttribute attribute : sku.getAttributes()) {
					for (PcProductAttribute productAttribute : productAttributes) {
						if (StringUtils.equals(attribute.getName(), productAttribute.getName())
								&& StringUtils.equals(attribute.getValue(), productAttribute.getValue())) {
							skuAttributes.add(productAttribute);
						} else {
							continue;
						}
					}
				}
				Set<PcProductAttribute> _skuAttributes = new HashSet<PcProductAttribute>(skuAttributes);
				sku.setAttributes(_skuAttributes);
				sku.setCreateUser(user);
				sku.setCreateTime(date);
				sku.setUpdateUser(user);
				sku.setUpdateTime(date);
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
		return super.create(entity);
	}

	@Override
	public EntityResult<PcProduct> update(PcProduct entity) {
		EntityResult<PcProduct> result = new EntityResult<PcProduct>();
		try {
			boolean flag = isExistsEntityById(entity);
			if (!flag) {
				result.setCode(ResultType.NULL);
				result.setMessage("对象不存在");
				return result;
			}
			// 删除原有的属性设置
			// ppaRepository.deleteAttributeByProduct(entity.getCode());
			List<PcProductAttribute> productAttributes = new ArrayList<PcProductAttribute>();
			String user = entity.getCreateUser();
			Date date = new Date();
			if (entity.getAttributeList() != null && !entity.getAttributeList().isEmpty()) {
				for (PcProductAttribute ppa : entity.getAttributeList()) {
					String[] values = ppa.getValue().split(",");
					for (String value : values) {
						PcProductAttribute attribute = new PcProductAttribute();
						if (StringUtils.isBlank(attribute.getCode())) {
							attribute.setCode(CodeHelper.getCode(PcProductAttribute.class));
						}
						attribute.setName(ppa.getName());
						attribute.setValue(value);
						attribute.setSort(ppa.getSort());
						productAttributes.add(attribute);
					}
				}
			}
			entity.setAttributeList(new HashSet<PcProductAttribute>(productAttributes));

			// ppsRepository.deleteSpecificationByProduct(entity.getCode());
			// 商品规格参数
			List<PcProductSpecification> productSpecifications = new ArrayList<PcProductSpecification>();
			if (entity.getSpecList() != null && !entity.getSpecList().isEmpty()) {
				for (PcProductSpecification ppa : entity.getSpecList()) {
					String[] values = ppa.getValue().split(",");
					for (String value : values) {
						PcProductSpecification spec = new PcProductSpecification();
						spec.setUid(CodeHelper.getUUID());
						spec.setCode(CodeHelper.getCode(PcProductSpecification.class));
						spec.setName(ppa.getName());
						spec.setValue(value);
						spec.setSort(ppa.getSort());
						productSpecifications.add(spec);
					}
				}
			}
			entity.setSpecList(productSpecifications);

			BigDecimal minSellPrice = new BigDecimal(0.00);
			BigDecimal maxSellPrice = new BigDecimal(0.00);
			// 整理SKU
			if (!entity.getSkuList().isEmpty() && entity.getSkuList().size() > 0) {
				for (PcSku sku : entity.getSkuList()) {
					if (StringUtils.isBlank(sku.getUid())) {
						sku.setUid(CodeHelper.getUUID());
					}
					if (StringUtils.isBlank(sku.getCode())) {
						sku.setCode(CodeHelper.getCode(PcSku.class));
					}
					// sku属性
					List<PcProductAttribute> skuAttributes = new ArrayList<PcProductAttribute>();
					for (PcProductAttribute attribute : sku.getAttributes()) {
						for (PcProductAttribute productAttribute : productAttributes) {
							if (StringUtils.equals(attribute.getName(), productAttribute.getName())
									&& StringUtils.equals(attribute.getValue(), productAttribute.getValue())) {
								skuAttributes.add(productAttribute);
							} else {
								continue;
							}
						}
					}
					Set<PcProductAttribute> _skuAttributes = new HashSet<PcProductAttribute>(skuAttributes);
					sku.setAttributes(_skuAttributes);
					sku.setCreateUser(user);
					sku.setCreateTime(date);
					sku.setUpdateUser(user);
					sku.setUpdateTime(date);
					if (sku.getSellPrice().compareTo(minSellPrice) == -1) {
						minSellPrice = sku.getSellPrice();
					} else if (sku.getSellPrice().compareTo(maxSellPrice) == 1) {
						maxSellPrice = sku.getSellPrice();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.update(entity);
	}

	@Transactional
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
			PcProduct product = repository.getProduct(code);
			if (product == null) {
				result.setCode(ResultType.NULL);
				result.setMessage("商品不存在");
				return result;
			}
			// 标签
			Set<PcLabel> labels = repository.findLabels(code);
			product.setLabels(labels);
			// 关键字
			Set<PcKeyword> keywords = repository.findkeywords(code);
			product.setKeywords(keywords);
			// 图片
			Set<PcPicture> pics = repository.findProductPics(code);
			product.setPics(pics);
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

	@Transactional
	@Override
	public DataResult<PcProductSpecification> getSpecification(String code) {
		DataResult<PcProductSpecification> result = new DataResult<PcProductSpecification>();
		try {
			List<Object> list = ppsRepository.findProductSpecification(code);
			Map<String, String> values = new TreeMap<String, String>();
			Map<String, Integer> sorts = new TreeMap<String, Integer>();
			for (Object object : list) {
				Object[] data = (Object[]) object;
				String name = data[1].toString();
				String value = data[2].toString();
				Integer sort = Integer.valueOf(data[3].toString());
				if (values.containsKey(name)) {
					value = values.get(name) + "," + value;
					values.replace(name, value);
				} else {
					values.put(name, value);
				}
				if (sorts.containsKey(name)) {
					int _sort = sorts.get(name);
					if (sort < _sort) {
						sorts.replace(name, sort);
					}
				} else {
					sorts.put(name, sort);
				}
			}
			List<PcProductSpecification> data = new ArrayList<PcProductSpecification>();
			for (Entry<String, String> entry : values.entrySet()) {
				PcProductSpecification spec = new PcProductSpecification();
				spec.setName(entry.getKey());
				spec.setValue(entry.getValue());
				spec.setSort(sorts.get(entry.getKey()));
				data.add(spec);
			}
			result.setCode(ResultType.SUCCESS);
			result.setData(data);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询商品参数失败");
		}
		return result;
	}

	@Transactional
	@Override
	public DataResult<PcProductAttribute> getAttribute(String code) {
		DataResult<PcProductAttribute> result = new DataResult<PcProductAttribute>();
		try {

			List<Object> list = ppaRepository.findProductAttribute(code);
			if (list == null || list.isEmpty()) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询为空");
			}
			Map<String, String> values = new TreeMap<String, String>();
			Map<String, Integer> sorts = new TreeMap<String, Integer>();
			for (Object object : list) {
				Object[] data = (Object[]) object;
				String name = data[1].toString();
				String value = data[2].toString();
				Integer sort = Integer.valueOf(data[3].toString());
				if (values.containsKey(name)) {
					value = values.get(name) + "," + value;
					values.replace(name, value);
				} else {
					values.put(name, value);
				}
				if (sorts.containsKey(name)) {
					int _sort = sorts.get(name);
					if (sort < _sort) {
						sorts.replace(name, sort);
					}
				} else {
					sorts.put(name, sort);
				}
			}
			List<PcProductAttribute> data = new ArrayList<PcProductAttribute>();
			for (Entry<String, String> entry : values.entrySet()) {
				PcProductAttribute attribute = new PcProductAttribute();
				attribute.setName(entry.getKey());
				attribute.setValue(entry.getValue());
				attribute.setSort(sorts.get(entry.getKey()));
				data.add(attribute);
			}
			result.setCode(ResultType.SUCCESS);
			result.setData(data);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询商品属性失败");
		}
		return result;
	}

	@Transactional
	@Override
	public DataResult<PcSku> getSkuList(String code) {
		DataResult<PcSku> result = new DataResult<PcSku>();
		try {
			Set<PcSku> list = skuRepository.findProductSkuList(code);
			if (list == null || list.isEmpty()) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询为空");
			}
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
			List<PcSku> skuList = new ArrayList<>(list);
			result.setData(skuList);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询商品sku失败");
		}
		return result;
	}

	@Override
	public BaseResult skuConcatAttribute(String attributeCode) {
		BaseResult result = new BaseResult();
		try {
			int total = ppaRepository.skuConcatAttribute(attributeCode);
			if (total > 0) {
				result.setCode(ResultType.ERROR);
				result.setMessage("商品属性已绑定sku");
				return result;
			}
			result.setCode(ResultType.SUCCESS);
			result.setMessage("可以删除");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
