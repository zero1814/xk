package org.system.result.user;

import java.util.List;

import org.system.entity.user.ScUserStatus;

import zero.commons.basics.result.BaseResult;

public class ScUserPropertyResult extends BaseResult {

	private List<ScUserStatus> statusList;

	public List<ScUserStatus> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<ScUserStatus> statusList) {
		this.statusList = statusList;
	}

}
