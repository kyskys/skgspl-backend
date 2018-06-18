package skgspl.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.GroupDao;
import skgspl.dao.api.LessonDao;
import skgspl.dao.api.LessonLocationDao;
import skgspl.dao.api.LessonTimeDao;
import skgspl.dao.api.RoomDao;
import skgspl.dao.api.SubjectDao;
import skgspl.dao.api.UserDao;
import skgspl.dao.search.LessonSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.dto.lesson.LessonTimetableGetDto;
import skgspl.entity.Lesson;
import skgspl.entity.LessonLocation;
import skgspl.service.api.LessonService;

@Transactional
@Service
public class LessonServiceImpl extends SearchableServiceImpl<LessonSearchParams, Lesson> implements LessonService {

	@Autowired
	LessonDao lessonDao;
	@Autowired
	LessonLocationDao lessonLocationDao;
	@Autowired
	SubjectDao subjectDao;
	@Autowired
	UserDao userDao;
	@Autowired
	RoomDao roomDao;
	@Autowired
	GroupDao groupDao;
	@Autowired
	LessonTimeDao lessonTimeDao;

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
		List<Lesson> result = lessonDao.getLessonsByWeek(day, idGroup);
		result.stream().forEach(entity -> entity.getLocations().size());
		return result;
	}

	@Override
	public void updateTimetable(LocalDateTime firstDay, Long idGroup, List<LessonTimetableGetDto> receivedLessons) {
		List<Lesson> storedLessons = lessonDao.getLessonsByWeek(firstDay, idGroup);
		List<Lesson> neww = new ArrayList<Lesson>();
		neww = storedLessons.stream().filter(storedLesson -> {
			boolean isToDelete = true;
			for (Iterator<LessonTimetableGetDto> iterator = receivedLessons.iterator(); iterator.hasNext();) {
				LessonTimetableGetDto receivedLesson = iterator.next();
				LocalDateTime day = firstDay.plusDays(receivedLesson.getDate() - 1);
				Long time = storedLesson.getTime().getId();
				if (storedLesson.getDate().equals(day) && time.equals(receivedLesson.getTime())) {
					isToDelete = false;
					updateLessonByDto(storedLesson, receivedLesson);
					receivedLessons.remove(receivedLesson);
					break;
				}
			}
			return isToDelete;
		}).collect(Collectors.toList());
		neww.forEach(lesson -> {
			lessonDao.delete(lesson);
		});
		receivedLessons.forEach(lessonToCreate -> {
			Lesson newLesson = new Lesson();
			newLesson.setGroup(groupDao.get(idGroup));
			newLesson.setDate(firstDay.plusDays(lessonToCreate.getDate() - 1));
			newLesson.setTime(lessonTimeDao.get(lessonToCreate.getTime()));
			newLesson.setSubject(subjectDao.get(lessonToCreate.getSubject()));
			lessonDao.create(newLesson);
			updateLessonByDto(newLesson, lessonToCreate);
		});
	}

	@Override
	public void updateLessonByDto(Lesson lesson, LessonTimetableGetDto dto) {
		lesson.setSubject(subjectDao.get(dto.getSubject()));
		if (lesson.getLocations() != null) {
			lesson.getLocations().forEach(location -> {
				lessonLocationDao.delete(location);
			});
		}
		if (dto.getLocations() != null) {
			dto.getLocations().forEach(location -> {
				LessonLocation newLocation = new LessonLocation();
				newLocation.setLecturer(userDao.get(location.getLecturer()));
				newLocation.setRoom(roomDao.get(location.getRoom()));
				newLocation.setLesson(lesson);
				lessonLocationDao.create(newLocation);
			});
		}
	}

	// @Override
	// public void addPairToLesson(Long idPair, Long idLesson) {
	// lessonDao.addPairToLesson(idPair, idLesson);
	// }
	//
	// @Override
	// public void removePairFromLesson(Long idLesson) {
	// lessonDao.removePairFromLesson(idLesson);
	// }
	//
	// @Override
	// public List<Lesson> getLessonsByCourseId(Long idCourse) {
	// return lessonDao.getLessonsByCourseId(idCourse);
	// }
	//
	// @Override
	// public List<Lesson> getLessonsWithoutCourse() {
	// return lessonDao.getLessonsWithoutCourse();
}
