package skgspl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.AuthorityDao;
import skgspl.dao.api.RoleDao;
import skgspl.dao.api.UserDao;
import skgspl.entity.Authority;
import skgspl.entity.Role;
import skgspl.entity.RoleAuthority;
import skgspl.entity.User;
import skgspl.entity.util.DictionaryItem;
import skgspl.service.api.AuthorityService;

@Transactional
@Service
public class AuthorityServiceImpl extends AbstractServiceImpl<Authority> implements AuthorityService {

	@Autowired
	AuthorityDao authorityDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	UserDao userDao;

	@Override
	protected AbstractDao<Authority> getDao() {
		return authorityDao;
	}

	@Override
	public void updateAuthoritiesByRole(Long idRole, List<Long> authorities) {
		Role role = roleDao.get(idRole);
		List<Authority> newAuthorities = new ArrayList<Authority>();
		for (Long idAuthority : authorities) {
			newAuthorities.add(authorityDao.get(idAuthority));
		}
		role.setAuthorities(newAuthorities);
		roleDao.update(role);
	}
	
	@Override
	public void updateAuthoritiesByUser(Long idUser, List<Long> authorities) {
		User user = userDao.get(idUser);
		user.setRole(null);
		List<Authority> newAuthorities = new ArrayList<Authority>();
		for(Long idAuthority:authorities) {
			newAuthorities.add(authorityDao.get(idAuthority));
		}
		user.setAuthorities(newAuthorities);
		userDao.update(user);
	}

	@Override
	public List<DictionaryItem> getDictionaryByRole(Long idRole) {
		return authorityDao.getDictionaryByRole(idRole);
	}

	@Override
	public List<DictionaryItem> getDictionaryByUser(Long idUser) {
		return authorityDao.getDictionaryByUser(idUser);
	}

}
