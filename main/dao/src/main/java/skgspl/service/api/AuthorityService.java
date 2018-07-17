package skgspl.service.api;

import java.util.List;

import skgspl.entity.Authority;
import skgspl.entity.util.DictionaryItem;

public interface AuthorityService extends AbstractService<Authority> {

	void updateAuthoritiesByRole(Long idRole, List<Long> authorities);

	List<DictionaryItem> getDictionaryByRole(Long idRole);
}
