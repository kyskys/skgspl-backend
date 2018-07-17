package skgspl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.RoleDao;
import skgspl.entity.Role;
import skgspl.service.api.RoleService;

@Transactional
@Service
public class RoleServiceImpl extends AbstractServiceImpl<Role> implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Override
	protected AbstractDao<Role> getDao() {
		return roleDao;
	}

}
