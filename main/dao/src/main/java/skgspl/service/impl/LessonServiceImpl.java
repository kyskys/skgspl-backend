package skgspl.service.impl;

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
	LessonDao LessonDao;

	@Override
	protected AbstractDao<Lesson> getDao() {
		return LessonDao;
	}

	@Override
	protected Searchable<LessonSearchParams, Lesson> getSearchableDao() {
		return LessonDao;
	}

//	@Override
//	public void addPairToLesson(Long idPair, Long idLesson) {
//		LessonDao.addPairToLesson(idPair, idLesson);
//	}
//
//	@Override
//	public void removePairFromLesson(Long idLesson) {
//		LessonDao.removePairFromLesson(idLesson);
//	}
//
//	@Override
//	public List<Lesson> getLessonsByCourseId(Long idCourse) {
//		return LessonDao.getLessonsByCourseId(idCourse);
//	}
//
//	@Override
//	public List<Lesson> getLessonsWithoutCourse() {
//		return LessonDao.getLessonsWithoutCourse();
	}


