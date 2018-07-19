package skgspl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.UserDao;
import skgspl.dto.user.UserAuthoritiesDto;
import skgspl.dto.util.CodeEnum;
import skgspl.entity.User;
import skgspl.entity.util.DictionaryItem;
import skgspl.service.api.UserService;

@Transactional
@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	protected AbstractDao<User> getDao() {
		return userDao;
	}

	@Override
	public List<DictionaryItem> getLecturerDictionary() {
		return userDao.getLecturerDictionary();
	}

	@Override
	public void updateUserRole(Long idUser, Long idRole) {
		userDao.updateUserRole(idUser, idRole);
	}

	@Override
	public List<DictionaryItem> getUserDictionary() {
		return userDao.getUserDictionary();
	}

	@Override
	public UserAuthoritiesDto getUserAuthorities(Long idUser) {
		User user = userDao.get(idUser);
		UserAuthoritiesDto dto = new UserAuthoritiesDto();
		if (user.getRole() != null) {
			dto.setRole(user.getRole().getId());
		} else if (!user.getAuthorities().isEmpty() && user.getAuthorities() != null) {
			dto.setAuthorities(
					user.getAuthorities().stream().map(authority -> authority.getId()).collect(Collectors.toList()));
		}
		return dto;
	}

	// @Override
	// public CodeEnum checkUser(String login, String password) {
	// try {
	// User user = userDao.getUserByLogin(login);
	// return user.getPassword().equals(password) ? CodeEnum.SUCCESS_AUTH :
	// CodeEnum.WRONG_PASSWORD;
	// } catch (NoResultException e) {
	// return CodeEnum.LOGIN_NOT_EXIST;
	// }
	// }
	//
	// @Override
	// public User getUserByLogin(String login) {
	// return userDao.getUserByLogin(login);
	// }
	//
	// @Override
	// public boolean isUserExist(String login) {
	// try {
	// getUserByLogin(login);
	// return true;
	// } catch (NoResultException e) {
	// return false;
	// }
	// }

}
