package skgspl.service.api;

import java.util.List;

import skgspl.dao.search.GroupSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.entity.Group;

public interface GroupService extends AbstractService<Group>, Searchable<GroupSearchParams, Group> {
	void addLessonToGroup(Long idLesson, Long idGroup);

	void removeLessonFromGroup(Long idLesson, Long idGroup);

	void addStudentToGroup(Long idStudent, Long idGroup);

	void removeStudentFromGroup(Long idStudent);

	void addstudentsToGroup(Long idGroup, List<Long> students);

//	List<Group> getGroupsByLessonId(Long idLesson);
//
//	List<Group> getGroupsWithoutLesson(Long idLesson);
}
