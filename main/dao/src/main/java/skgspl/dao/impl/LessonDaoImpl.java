package skgspl.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import skgspl.dao.api.LessonDao;
import skgspl.dao.search.LessonSearchParams;
import skgspl.dao.search.SortParam;
import skgspl.entity.GroupLessons;
import skgspl.entity.Group_;
import skgspl.entity.Lesson;
import skgspl.entity.Lesson_;
import skgspl.entity.Subject_;

@Repository
public class LessonDaoImpl extends SearchableDaoImpl<LessonSearchParams, Lesson> implements LessonDao {

	private static final String REMOVE_PAIR_FROM_LESSON_HQL_QUERY = "update Lesson set group.id = null where id= :idLesson";
	private static final String ADD_PAIR_TO_LESSON_HQL_QUERY = "update Lesson set group.id = :idGroup where id= :idLesson";
	private static final String LESSON_PARAMETER = "idLesson";
	private static final String PAIR_PARAMETER = "idGroup";
	
	public Class<Lesson> getGenericClass() {
		return Lesson.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Lesson_.id);
		//sortMap.put(SortParam.NAME, Lesson_.name);
		sortMap.put(SortParam.SUBJECT_ID, Lesson_.subject);
	}

	@Override
	public void removeGroupFromLesson(Long idLesson) {
		Session session = getSession();
		Query query = session.createQuery(REMOVE_PAIR_FROM_LESSON_HQL_QUERY);
		query.setParameter(LESSON_PARAMETER, idLesson);
		query.executeUpdate();
	}

	@Override
	public void addGroupToLesson(Long idGroup, Long idLesson) {
		Session session = getSession();
		Query query = session.createQuery(ADD_PAIR_TO_LESSON_HQL_QUERY);
		query.setParameter(LESSON_PARAMETER, idLesson);
		query.setParameter(PAIR_PARAMETER, idGroup);
		query.executeUpdate();
	}

	@Override
	protected void applyBasicFilters(LessonSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Lesson> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Lesson_.id), searchParam.getId()));
		}
//		if (searchParam.getName() != null) {
//			predicates.add(builder.like(root.get(Lesson_.name), like(searchParam.getName())));
//		}
//		if (searchParam.getGroup() != null) {
//			predicates.add(builder.like(root.join(GroupLessons_.group).get(Group_.name), like(searchParam.getGroup())));
//		}
		if (searchParam.getSubject() != null) {
			predicates.add(builder.like(root.join(Lesson_.subject).get(Subject_.name), like(searchParam.getSubject())));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

	@Override
	public List<Lesson> getLessonsByGroupId(Long idGroup) {
		List<Lesson> result = searchWithAnotherFilter(null, null, -1, 0, true, (root, builder, query) -> {
			if (idGroup != null) {
				query.where(builder.equal(root.join(Lesson_.group).get(Group_.id),idGroup));
				
				}
		});
		return result;
	}

	@Override
	public List<Lesson> getLessonsWithoutGroup(Long idGroup) {
//		List<Lesson> result = searchWithAnotherFilter(null, null, -1, 0, true, (root, builder, query) -> {
//			Subquery<Long> subQuery = query.subquery(Long.class);
//			Root<GroupLessons> subRoot = subQuery.from(GroupLessons.class);
//			query.where(builder.not(root.get(Lesson_.id).in(subQuery.select(subRoot.get(GroupLessons_.lesson)).where(builder.equal(subRoot.get(GroupLessons_.lesson), idGroup)))));
//		
//		//	query.where(builder.isNull(root.get(Lesson_.Subject)));
//		});
//		return result;
		return null;
	}

	@Override
	public List<Lesson> getLessonsByWeek(LocalDateTime day, Long idGroup) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Lesson> query = builder.createQuery(Lesson.class);
		Root<Lesson> root = query.from(Lesson.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (idGroup != null) {
			predicates.add(builder.equal(root.join(Lesson_.group).get(Group_.id), idGroup));
		}
		if (day != null) {
			predicates.add(builder.and(builder.greaterThanOrEqualTo(root.get(Lesson_.date), day),
					builder.lessThanOrEqualTo(root.get(Lesson_.date), day.plusDays(6))));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));//.orderBy(builder.asc(root.get(Lesson_.date)),
//				builder.asc(root.join(Lesson_.time).get(PairTime_.startTime)));
		TypedQuery<Lesson> result = session.createQuery(query);
		return result.getResultList();
	}

}
