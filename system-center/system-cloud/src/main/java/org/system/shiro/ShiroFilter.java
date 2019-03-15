package org.system.shiro;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ShiroFilter {

	public Map<String, String> getFilter(String user) {
		Map<String, String> filters = new HashMap<String, String>();
		return filters;
	}
}
