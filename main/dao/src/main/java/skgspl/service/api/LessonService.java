package skgspl.service.api;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import skgspl.dao.search.LectionSearchParams;
import skgspl.dao.search.LessonSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.entity.Lesson;

public interface LessonService extends AbstractService<Lesson>, Searchable<LessonSearchParams, Lesson> {

//	void addPairToLection(Long idPair, Long idLection);
//
//	void removePairFromLection(Long idLection);
//
//	List<Lesson> getLectionsByCourseId(Long idCourse);
//
//	Collection<Lesson> getLectionsWithoutCourse();

	List<Lesson> getLessonsByWeek(LocalDateTime day, Long idGroup);
}
