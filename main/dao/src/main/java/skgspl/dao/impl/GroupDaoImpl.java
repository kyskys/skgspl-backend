package skgspl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import skgspl.dao.api.GroupDao;
import skgspl.dao.search.GroupSearchParams;
import skgspl.dao.search.SortParam;
import skgspl.entity.Group;
import skgspl.entity.Group_;

@Repository
public class GroupDaoImpl extends SearchableDaoImpl<GroupSearchParams, Group> implements GroupDao {

	public Class<Group> getGenericClass() {
		return Group.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Group_.id);
		sortMap.put(SortParam.NAME, Group_.name);
	}

	@Override
	protected void applyBasicFilters(GroupSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Group> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Group_.id), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			predicates.add(builder.like(root.get(Group_.name), like(searchParam.getName())));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

	/*@Override
	public List<Group> getGroupsByLessonId(Long idLesson) {
		List<Group> result = searchWithAnotherFilter(null, null, -1, 0, true, (root, builder, query) -> {
			query.where(builder.equal(root.join(Lesson_.groups).get(Group_.id), idLesson));
		});
		return result;
	}

	@Override
	public List<Group> getGroupsWithoutLesson(Long idLesson) {
		List<Group> result = searchWithAnotherFilter(null, null, -1, 0, true, (root, builder, query) -> {
			Subquery<Long> subQuery = query.subquery(Long.class);
			Root<GroupLessons> subRoot = subQuery.from(GroupLessons.class);
			query.where(builder.not(root.get(Group_.id).in(subQuery.select(subRoot.get(GroupLessons_.group)).where(builder.equal(subRoot.get(Timetable_.lessonId), idLesson)))));
		});
		return result;
	}*/

}
