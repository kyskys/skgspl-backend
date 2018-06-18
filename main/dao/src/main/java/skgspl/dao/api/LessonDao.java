package skgspl.dao.api;

import java.time.LocalDateTime;
import java.util.List;

import skgspl.dao.search.LessonSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.entity.Lesson;

public interface LessonDao extends AbstractDao<Lesson>, Searchable<LessonSearchParams, Lesson> {

	void removeGroupFromLesson(Long idLesson);

	void addGroupToLesson(Long idGroup, Long idLesson);

	List<Lesson> getLessonsByGroupId(Long idGroup);

	List<Lesson> getLessonsWithoutGroup(Long idGroup);

	List<Lesson> getLessonsByWeek(LocalDateTime day, Long idGroup);

	
}
