package skgspl.service.api;

import java.util.List;

import skgspl.dao.util.CodeEnum;
import skgspl.entity.User;
import skgspl.entity.util.DictionaryItem;

public interface UserService extends AbstractService<User> {
//	User getUserByLogin(String login);
//
//	CodeEnum checkUser(String login, String password);
//	
//	boolean isUserExist(String login);
	
	List<DictionaryItem> getLecturerDictionary();
}
