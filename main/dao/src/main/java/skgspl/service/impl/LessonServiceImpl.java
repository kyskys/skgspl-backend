package skgspl.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.LessonDao;
import skgspl.dao.search.LessonSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.entity.Lesson;
import skgspl.service.api.LessonService;

@Transactional
@Service
public class LessonServiceImpl extends SearchableServiceImpl<LessonSearchParams, Lesson> implements LessonService {

	@Autowired
	LessonDao lessonDao;

	@Override
	protected AbstractDao<Lesson> getDao() {
		return lessonDao;
	}

	@Override
	protected Searchable<LessonSearchParams, Lesson> getSearchableDao() {
		return lessonDao;
	}

	@Override
	public List<Lesson> getLessonsByWeek(LocalDateTime day, Long idGroup) {
		List<Lesson> result = lessonDao.getTimetableByWeek(day,idGroup);
		result.stream().forEach(entity -> entity.getLocations().size());
		return result;
	}

//	@Override
//	public void addPairToLesson(Long idPair, Long idLesson) {
//		lessonDao.addPairToLesson(idPair, idLesson);
//	}
//
//	@Override
//	public void removePairFromLesson(Long idLesson) {
//		lessonDao.removePairFromLesson(idLesson);
//	}
//
//	@Override
//	public List<Lesson> getLessonsByCourseId(Long idCourse) {
//		return lessonDao.getLessonsByCourseId(idCourse);
//	}
//
//	@Override
//	public List<Lesson> getLessonsWithoutCourse() {
//		return lessonDao.getLessonsWithoutCourse();
	}


