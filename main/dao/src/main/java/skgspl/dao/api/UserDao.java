package skgspl.dao.api;

import java.util.List;

import skgspl.entity.User;
import skgspl.entity.util.DictionaryItem;

public interface UserDao extends AbstractDao<User> {

	User getUserByLogin(String login);

	List<DictionaryItem> getLecturerDictionary();

	void updateUserRole(Long idUser, Long idRole);

	List<DictionaryItem> getUserDictionary();
}
