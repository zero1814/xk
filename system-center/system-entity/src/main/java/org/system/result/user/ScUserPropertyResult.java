package org.system.result.user;

import java.util.List;

import org.system.entity.user.ScUserStatus;
import org.system.entity.user.ScUserType;

import lombok.Getter;
import lombok.Setter;
import zero.commons.basics.result.BaseResult;

/**
 * 
 * 类: UserPropertyResult <br>
 * 描述: 系統用户参数结果集 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月18日 上午9:09:23
 */
@Getter
@Setter
public class ScUserPropertyResult extends BaseResult {

	private List<ScUserType> typeList;

	private List<ScUserStatus> statusList;

}
