package skgspl.dao.impl;

import java.util.List;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.stereotype.Repository;

import skgspl.dao.api.AuthorityDao;
import skgspl.entity.Authority;
import skgspl.entity.Authority_;
import skgspl.entity.RoleAuthority;
import skgspl.entity.RoleAuthority_;
import skgspl.entity.UserAuthority;
import skgspl.entity.UserAuthority_;
import skgspl.entity.util.DictionaryItem;

@Repository
public class AuthorityDaoImpl extends AbstractDaoImpl<Authority> implements AuthorityDao {

	@Override
	public Class<Authority> getGenericClass() {
		return Authority.class;
	}

	@Override
	public Authority create(Authority entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Authority entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Authority entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<DictionaryItem> getDictionaryByRole(Long idRole) {
		return getDictionaryByCriteria((root,builder,query) -> {
			Subquery<Long> subQuery = query.subquery(Long.class);
			Root<RoleAuthority> subRoot = subQuery.from(RoleAuthority.class);
			query.multiselect(root.get(Authority_.id),root.get(Authority_.name)).where(root.get(Authority_.id).in(subQuery.select(subRoot.get(RoleAuthority_.authority)).where(builder.equal(subRoot.get(RoleAuthority_.role),idRole))));
		});
	}

	@Override
	public List<DictionaryItem> getDictionaryByUser(Long idUser) {
		return getDictionaryByCriteria((root,builder,query) -> {
			Subquery<Long> subQuery = query.subquery(Long.class);
			Root<UserAuthority> subRoot = subQuery.from(UserAuthority.class);
			query.multiselect(root.get(Authority_.id),root.get(Authority_.name)).where(root.get(Authority_.id).in(subQuery.select(subRoot.get(UserAuthority_.authority)).where(builder.equal(subRoot.get(UserAuthority_.user),idUser))));
		});
	}
	
	
}
