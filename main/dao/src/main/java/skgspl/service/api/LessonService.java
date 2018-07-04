package skgspl.service.api;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import skgspl.dao.search.LectionSearchParams;
import skgspl.dao.search.LessonSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.dto.lesson.LessonLocationGetDto;
import skgspl.dto.lesson.LessonTimetableGetDto;
import skgspl.dto.report.TimetableReportItem;
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

	void updateLessonByDto(Lesson lesson, LessonTimetableGetDto dto);

	void updateTimetable(LocalDateTime firstDay, Long idGroup, List<LessonTimetableGetDto> receivedLessons);
	
	List<TimetableReportItem> getTimetableReportData(LocalDateTime firstDay);

	//void updateTimetable(List<LessonTimetableGetDto> data, Long idGroup);
}
