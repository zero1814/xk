package org.product.repository;

import java.util.List;

import org.product.entity.PcAlbum;
import org.product.entity.PcAlbumPic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

public interface PcAlbumPicRepository extends BaseRepository<PcAlbum, String> {

	@Query("select new PcAlbumPic(code,picUrl) from PcAlbumPic where album=:album")
	List<PcAlbumPic> all(@Param("album") String album);
}
