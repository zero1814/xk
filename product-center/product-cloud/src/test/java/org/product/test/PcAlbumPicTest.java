package org.product.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.PcAlbumPic;
import org.product.repository.PcAlbumPicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcAlbumPicTest {

	@Autowired
	private PcAlbumPicRepository repository;

	@Test
	public void all() {
		List<PcAlbumPic> list = repository.all("PA1138739094445092864");
		System.out.println(JSON.toJSONString(list));
	}
}
