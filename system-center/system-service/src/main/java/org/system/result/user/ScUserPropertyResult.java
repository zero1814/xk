package org.system.result.user;

import java.util.List;

import org.system.entity.user.ScUserStatus;
import org.system.entity.user.ScUserType;

import zero.commons.basics.result.BaseResult;

public class ScUserPropertyResult extends BaseResult{

	private List<ScUserType> typeList;
	
	private List<ScUserStatus> statusList;

	public List<ScUserType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<ScUserType> typeList) {
		this.typeList = typeList;
	}

	public List<ScUserStatus> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<ScUserStatus> statusList) {
		this.statusList = statusList;
	}
	
	
}
