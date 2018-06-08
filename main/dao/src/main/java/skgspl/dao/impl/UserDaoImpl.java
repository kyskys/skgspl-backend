package skgspl.dao.impl;

import java.util.List;

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
import skgspl.entity.util.RoleEnum;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

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
			query.multiselect(root.get(User_.id),root.join(User_.details).get(UserDetails_.name)).where(builder.equal(root.get(User_.role),(RoleEnum.LECTURER)));
		});
	}

}
