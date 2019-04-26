package org.system.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginParam implements Serializable {

	private static final long serialVersionUID = -1897400424370152382L;

	private String username;

	private String password;
}
