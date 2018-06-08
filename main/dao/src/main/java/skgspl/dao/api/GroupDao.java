package skgspl.dao.api;

import java.util.List;

import skgspl.dao.search.GroupSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.entity.Group;

public interface GroupDao extends AbstractDao<Group>, Searchable<GroupSearchParams, Group> {

	/*List<Group> getGroupsByLessonId(Long idLesson);

	List<Group> getGroupsWithoutLesson(Long idLesson);*/
}
