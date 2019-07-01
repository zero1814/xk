package org.product.service.impl.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.product.entity.PcKeyword;
import org.product.entity.PcLabel;
import org.product.entity.PcPicture;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcProductAttribute;
import org.product.entity.product.PcProductAttributeValue;
import org.product.entity.product.PcProductSpecification;
import org.product.entity.product.PcProductSpecificationValue;
import org.product.entity.product.PcSku;
import org.product.query.product.PcProductQuery;
import org.product.repository.product.PcPictureRepository;
import org.product.repository.product.PcProductAttributeRepository;
import org.product.repository.product.PcProductAttributeValueRepository;
import org.product.repository.product.PcProductRepository;
import org.product.repository.product.PcProductSpecificationRepository;
import org.product.repository.product.PcProductSpecificationValueRepository;
import org.product.repository.product.PcSkuRepository;
import org.product.service.product.IPcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.StringUtils;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.PageResult;
import zero.commons.basics.result.ResultType;
import zero.commons.basics.result.RootResult;

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
	private PcProductSpecificationValueRepository ppsVRepository;
	@Autowired
	private PcProductAttributeRepository ppaRepository;
	@Autowired
	private PcProductAttributeValueRepository ppaVRepository;
	@Autowired
	private PcPictureRepository picRepository;
	@Autowired
	private PcSkuRepository skuRepository;
	@Autowired
	private EntityManager em;

	@Transactional
	public EntityResult<PcProduct> create(PcProduct entity) {
		// 商品相册
		if (entity.getPics() != null && !entity.getPics().isEmpty()) {
			List<PcPicture> pictures = new ArrayList<PcPicture>(entity.getPics());
			for (PcPicture pic : pictures) {
				pic.setCode(CodeHelper.getCode(PcPicture.class));
			}
			picRepository.saveAll(pictures);
			picRepository.flush();
		}
		// 商品属性
		List<PcProductAttribute> attributes = new ArrayList<PcProductAttribute>();
		String user = entity.getCreateUser();
		Date date = new Date();
		if (entity.getAttributeList() != null && !entity.getAttributeList().isEmpty()) {
			for (PcProductAttribute ppa : entity.getAttributeList()) {
				List<PcProductAttributeValue> values = ppa.getValues();
				ppaVRepository.saveAll(values);
				ppaVRepository.flush();
				attributes.add(ppa);
			}
		}
		ppaRepository.saveAll(attributes);
		ppaRepository.flush();
		entity.setAttributeList(new HashSet<PcProductAttribute>(attributes));
		// 商品规格参数
		List<PcProductSpecification> specifications = new ArrayList<PcProductSpecification>();
		if (entity.getSpecList() != null && !entity.getSpecList().isEmpty()) {
			for (PcProductSpecification ppa : entity.getSpecList()) {
				List<PcProductSpecificationValue> values = ppa.getSpecValues();
				ppsVRepository.saveAll(values);
				ppsVRepository.flush();
				specifications.add(ppa);
			}
		}
		ppsRepository.saveAll(specifications);
		ppsRepository.flush();
		entity.setSpecList(new HashSet<PcProductSpecification>(specifications));
		BigDecimal minSellPrice = new BigDecimal(0.00);
		BigDecimal maxSellPrice = new BigDecimal(0.00);
		// 整理SKU
		if (!entity.getSkuList().isEmpty() && entity.getSkuList().size() > 0) {
			for (PcSku sku : entity.getSkuList()) {
				sku.setUid(CodeHelper.getUUID());
				sku.setProduct(entity);
				sku.setCode(CodeHelper.getCode(PcSku.class));
				sku.setCreateUser(user);
				sku.setCreateTime(date);
				sku.setUpdateUser(user);
				sku.setUpdateTime(date);
				sku.setFlagDeleted(0);
				if (sku.getSellPrice().compareTo(minSellPrice) == -1) {
					minSellPrice = sku.getSellPrice();
				} else if (sku.getSellPrice().compareTo(maxSellPrice) == 1) {
					maxSellPrice = sku.getSellPrice();
				}
			}
		}
		entity.setUid(CodeHelper.getUUID());
		entity.setCode(CodeHelper.getCode(PcProduct.class));
		entity.setMinSellPrice(minSellPrice);
		entity.setMaxSellPrice(maxSellPrice);
		entity.setCreateUser(user);
		entity.setCreateTime(date);
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
			List<PcProductSpecification> list = ppsRepository.findProductSpecification(code);
			result.setCode(ResultType.SUCCESS);
			result.setData(list);
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

			List<PcProductAttribute> list = ppaRepository.findAll();
			result.setCode(ResultType.SUCCESS);
			result.setData(list);
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
	public EntityResult<PcProduct> reorganize(PcProduct product) {
		EntityResult<PcProduct> result = new EntityResult<PcProduct>();
		try {
			if (product.getSpecList() != null && !product.getSpecList().isEmpty()) {
				// 整理商品参数列表
				for (PcProductSpecification spec : product.getSpecList()) {
					spec.setCode(CodeHelper.getCode(PcProductSpecification.class));
					List<PcProductSpecificationValue> values = spec.getSpecValues();
					for (PcProductSpecificationValue value : values) {
						value.setCode(CodeHelper.getCode(PcProductSpecificationValue.class));
					}
				}
			}
			if (product.getAttributeList() != null && !product.getAttributeList().isEmpty()) {
				// 整理商品属性列表
				for (PcProductAttribute attribute : product.getAttributeList()) {
					attribute.setCode(CodeHelper.getCode(PcProductAttribute.class));
					List<PcProductAttributeValue> values = attribute.getValues();
					for (PcProductAttributeValue value : values) {
						value.setCode(CodeHelper.getCode(PcProductAttributeValue.class));
					}
				}
			}
			result.setCode(ResultType.SUCCESS);
			result.setEntity(product);
			result.setMessage("整理成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("整理失败");
		}
		return result;
	}

	/**
	 * 
	 * 方法: concatSpecification <br>
	 * 
	 * @param param
	 * @return
	 * @see org.product.service.product.IPcProductService#concatSpecification(java.util.Map)
	 */
	@Override
	public RootResult concatSpecification(Map<String, String> param) {
		RootResult result = new RootResult();
		boolean isConcat = isConcatSpecification(param.get("code"), param.get("value"));
		try {
			int total = 0;
			if (isConcat) {
				total = 1;
			}
			result.setCode(ResultType.SUCCESS);
			result.setObj(total);
			result.setMessage("判断商品规格参数sku是否包含成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("判断商品规格参数sku是否包含报错");
		}
		return result;
	}

	/**
	 * 
	 * 方法: concatAttribute <br>
	 * 
	 * @param param
	 * @return
	 * @see org.product.service.product.IPcProductService#concatAttribute(java.util.Map)
	 */
	@Override
	public RootResult concatAttribute(Map<String, String> param) {
		RootResult result = new RootResult();
		try {
			boolean isConcat = isConcatAttributeValue(param.get("code"), param.get("value"));
			int total = 0;
			if (isConcat) {
				total = 1;
			}
			result.setCode(ResultType.SUCCESS);
			result.setObj(total);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("判断商品属性参数sku是否包含成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("判断商品属性参数sku是否包含报错");
		}
		return result;
	}

	/**
	 * 
	 * 方法: isConcatSpecification <br>
	 * 描述: 商品规格参数是否在sku中的规格参数有设置 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月27日 下午4:56:14
	 * 
	 * @param attributeName
	 * @param attributeValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean isConcatAttributeValue(String attributeCode, String attributeValue) {
		boolean isConcat = false;
		try {
			StringBuffer sql = new StringBuffer("SELECT DISTINCT ppav.value as value FROM pc_sku_attribute AS psa");
			sql.append(" LEFT JOIN pc_product_attribute_value AS ppav ON psa.attribute = ppav.code");
			sql.append(" LEFT JOIN pc_product_attribute AS ppa ON ppav.attribute = ppa.code");
			sql.append(" where ppa.code =:code");
			Query query = em.createNativeQuery(sql.toString());
			query.setParameter("code", attributeCode);
			List<Object> list = query.getResultList();
			if (list != null && list.size() > 0) {
				for (Object object : list) {
					String name = object.toString();
					if (StringUtils.contains(name, attributeValue)) {
						isConcat = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isConcat;
	}

	/**
	 * 
	 * 方法: isConcatAttributeValue <br>
	 * 描述: 商品规格参数是否在sku中的属性参数有设置 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月27日 下午4:40:32
	 * 
	 * @param attributeName
	 * @param attributeValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean isConcatSpecification(String specificationCode, String specificationValue) {
		boolean isConcat = false;
		try {
			StringBuffer sql = new StringBuffer("SELECT DISTINCT pps.value as value FROM pc_sku_specification AS pss");
			sql.append(" LEFT JOIN pc_product_specification_value AS ppsv ON ppsv.code = pss.specification");
			sql.append(" LEFT JOIN pc_product_specification AS pps ON ppsv.specification = pps.code");
			sql.append(" where pps.code =:code");
			Query query = em.createNativeQuery(sql.toString());
			query.setParameter("code", specificationCode);
			List<Object> list = query.getResultList();
			if (list != null && list.size() > 0) {
				for (Object object : list) {
					String name = object.toString();
					if (StringUtils.contains(name, specificationValue)) {
						isConcat = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isConcat;
	}
}
