package skgspl.service.api;

import java.util.List;

import skgspl.dto.user.UserAuthoritiesDto;
import skgspl.dto.util.CodeEnum;
import skgspl.entity.User;
import skgspl.entity.util.DictionaryItem;

public interface UserService extends AbstractService<User> {
//	User getUserByLogin(String login);
//
//	CodeEnum checkUser(String login, String password);
//	
//	boolean isUserExist(String login);
	
	List<DictionaryItem> getLecturerDictionary();

	void updateUserRole(Long idUser, Long idRole);

	List<DictionaryItem> getUserDictionary();

	UserAuthoritiesDto getUserAuthorities(Long idUser);

}
