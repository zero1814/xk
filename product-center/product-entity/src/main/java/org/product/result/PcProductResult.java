package org.product.result;

import java.util.List;

import org.product.entity.product.PcBrandInfo;
import org.product.entity.product.PcCategory;
import org.product.entity.product.PcLabel;
import org.product.entity.product.PcProductStatus;

import zero.commons.basics.result.BaseResult;

/**
 * 
 * 类: PcProductResult <br>
 * 描述: 商品结果集 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月6日 下午4:50:37
 */
public class PcProductResult extends BaseResult {

	private List<PcBrandInfo> brandList;

	private List<PcCategory> categoryList;

	private List<PcLabel> labelList;

	private List<PcProductStatus> statusList;

	public List<PcProductStatus> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<PcProductStatus> statusList) {
		this.statusList = statusList;
	}

	public List<PcBrandInfo> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<PcBrandInfo> brandList) {
		this.brandList = brandList;
	}

	public List<PcCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<PcCategory> categoryList) {
		this.categoryList = categoryList;
	}

	public List<PcLabel> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<PcLabel> labelList) {
		this.labelList = labelList;
	}

}
