package skgspl.dao.api;

import java.util.List;

import skgspl.entity.Authority;
import skgspl.entity.util.DictionaryItem;

public interface AuthorityDao extends AbstractDao<Authority> {

	List<DictionaryItem> getDictionaryByRole(Long idRole);

	List<DictionaryItem> getDictionaryByUser(Long idUser);

}
