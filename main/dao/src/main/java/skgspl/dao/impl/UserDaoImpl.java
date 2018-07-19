package skgspl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import skgspl.dao.api.UserDao;
import skgspl.entity.User;
import skgspl.entity.UserDetails_;
import skgspl.entity.User_;
import skgspl.entity.util.DictionaryItem;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

	private static final String UPDATE_USER_ROLE_QUERY = "update User set role.id = :idRole where id = :idUser";
	private static final String USER_PARAMETER = "idUser";
	private static final String ROLE_PARAMETER = "idRole";
	
	@Override
	public Class<User> getGenericClass() {
		return User.class;
	}

	@Override
	public User getUserByLogin(String login) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get(User_.login), login));
		TypedQuery<User> result = session.createQuery(query);
		User user = result.getSingleResult();
		return user;
	}

	@Override
	public List<DictionaryItem> getLecturerDictionary() {
		return getDictionaryByCriteria((root,builder,query) -> {
			//query.multiselect(root.get(User_.id),root.join(User_.details).get(UserDetails_.name)).where(builder.equal(root.get(User_.role),(RoleEnum.LECTURER)));
		});
	}

	@Override
	public void updateUserRole(Long idUser, Long idRole) {
		Session session = getSession();
		Query query = session.createQuery(UPDATE_USER_ROLE_QUERY);
		query.setParameter(USER_PARAMETER, idUser);
		query.setParameter(ROLE_PARAMETER, idRole);
		query.executeUpdate();
		User user = session.get(User.class, idUser);
		user.getAuthorities().clear();
		session.merge(user);
	}

	@Override
	public List<DictionaryItem> getUserDictionary() {
		return getDictionaryByCriteria((root,builder,query) -> {
			query.multiselect(root.get(User_.id),root.join(User_.details).get(UserDetails_.name));
		});
	}

}
