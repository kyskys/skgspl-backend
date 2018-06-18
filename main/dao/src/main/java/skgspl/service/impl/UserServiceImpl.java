package skgspl.service.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.UserDao;
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

//	@Override
//	public CodeEnum checkUser(String login, String password) {
//		try {
//			User user = userDao.getUserByLogin(login);
//			return user.getPassword().equals(password) ? CodeEnum.SUCCESS_AUTH : CodeEnum.WRONG_PASSWORD;
//		} catch (NoResultException e) {
//			return CodeEnum.LOGIN_NOT_EXIST;
//		}
//	}
//
//	@Override
//	public User getUserByLogin(String login) {
//		return userDao.getUserByLogin(login);
//	}
//
//	@Override
//	public boolean isUserExist(String login) {
//		try {
//			getUserByLogin(login);
//			return true;
//		} catch (NoResultException e) {
//			return false;
//		}
//	}
	
	

	
	
}
