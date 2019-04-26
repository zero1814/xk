package org.system.result.user;

import lombok.Getter;
import lombok.Setter;
import zero.commons.basics.result.BaseResult;

@Getter
@Setter
public class LoginResult extends BaseResult{

	private String token;
}
