package org.product.result.store;

import java.util.List;

import org.product.entity.store.PcStoreStatus;
import org.product.entity.store.PcStoreType;

import zero.commons.basics.result.BaseResult;

public class PcStoreInfoResult extends BaseResult {

	private List<PcStoreType> typeList;

	private List<PcStoreStatus> statusList;

	public List<PcStoreType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<PcStoreType> typeList) {
		this.typeList = typeList;
	}

	public List<PcStoreStatus> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<PcStoreStatus> statusList) {
		this.statusList = statusList;
	}

}
