package org.system.repository.role;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.system.entity.role.ScRole;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: ScRoleRepository <br>
 * 描述: 系统角色表JPA访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:01:04
 */
public interface ScRoleRepository extends BaseRepository<ScRole, String> {

	@Query(value = "select code,name from ScRole where flagEnabled = 0")
	List<ScRole> selRols();
}
