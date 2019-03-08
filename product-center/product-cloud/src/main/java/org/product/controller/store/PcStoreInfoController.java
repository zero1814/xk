package org.product.controller.store;

import org.product.controller.BaseController;
import org.product.entity.store.PcStoreInfo;
import org.product.result.store.PcStoreInfoResult;
import org.product.service.store.IPcStoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/")
public class PcStoreInfoController extends BaseController<PcStoreInfo, IPcStoreInfoService> {

	@Autowired
	private IPcStoreInfoService service;

	@GetMapping("init/params")
	public PcStoreInfoResult initProperty() {
		return service.initProperty();
	}
}
