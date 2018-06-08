package skgspl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import skgspl.dao.api.SubjectDao;
import skgspl.dao.search.SubjectSearchParams;
import skgspl.dao.search.SortParam;
import skgspl.entity.Subject;
import skgspl.entity.Subject_;

@Repository
public class SubjectDaoImpl extends SearchableDaoImpl<SubjectSearchParams, Subject> implements SubjectDao {

	private static final String ADD_LESSON_TO_SUBJECT_HQL_QUERY = "update Lesson set Subject.id = :idSubject where id= :idLesson";
	private static final String REMOVE_LESSON_FROM_SUBJECT_HQL_QUERY = "update Lesson set Subject.id = null where id= :idLesson";
	private static final String LESSON_PARAMETER = "idLesson";
	private static final String SUBJECT_PARAMETER = "idSubject";
	
	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Subject_.id);
		sortMap.put(SortParam.NAME, Subject_.name);
	}

	public Class<Subject> getGenericClass() {
		return Subject.class;
	}

	@Override
	public void addLessonToSubject(Long idLesson, Long idSubject) {
		Session session = getSession();
		Query query = session.createQuery(ADD_LESSON_TO_SUBJECT_HQL_QUERY);
		query.setParameter(LESSON_PARAMETER, idLesson);
		query.setParameter(SUBJECT_PARAMETER, idSubject);
		query.executeUpdate();
	}

	@Override
	public void removeLessonFromSubject(Long idLesson) {
		Session session = getSession();
		Query query = session.createQuery(REMOVE_LESSON_FROM_SUBJECT_HQL_QUERY);
		query.setParameter(SUBJECT_PARAMETER, idLesson);
		query.executeUpdate();
	}

//	@Override
//	public List<Lesson> getLessonsBySubjectId(Long idSubject) {
//		Session session = getSession();
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Lesson> query = builder.createQuery(Lesson.class);
//		Root<Lesson> root = query.from(Lesson.class);
//		query.select(root).where(builder.equal(root.join(Lesson_.Subject).get(Subject_.id), idSubject));
//		TypedQuery<Lesson> result = session.createQuery(query);
//		return result.getResultList();
//	}

	@Override
	protected void applyBasicFilters(SubjectSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder, Root<Subject> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Subject_.id), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			predicates.add(builder.like(root.get(Subject_.name), like(searchParam.getName())));
		}
//		if (searchParam.getLecturer() != null) {
//			predicates.add(builder.like(root.join(Subject_.lecturer).get(Lecturer_.name), like(searchParam.getLecturer())));
//		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

}
