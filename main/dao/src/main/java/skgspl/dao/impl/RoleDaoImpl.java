package skgspl.dao.impl;

import org.springframework.stereotype.Repository;

import skgspl.dao.api.RoleDao;
import skgspl.entity.Role;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Role> implements RoleDao {

	@Override
	public Class<Role> getGenericClass() {
		return Role.class;
	}

}
