package org.product.provider;

import org.apache.ibatis.jdbc.SQL;
import org.product.entity.PcBrandInfo;

public class PcBrandInfoProvider {

	public SQL insert(PcBrandInfo entity) {
		new SQL() {
			{
				INSERT_INTO("pc_product_info");
			}
		};
		return null;
	}
}
