package org.customer.jwt.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto implements Serializable {

	private static final long serialVersionUID = -1987157691000374427L;
	private String userName;
	private String password;
}
