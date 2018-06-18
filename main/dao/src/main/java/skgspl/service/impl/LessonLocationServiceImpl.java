package skgspl.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.LessonLocationDao;
import skgspl.dao.api.RoomDao;
import skgspl.dao.api.UserDao;
import skgspl.dto.lesson.LessonLocationGetDto;
import skgspl.entity.Lesson;
import skgspl.entity.LessonLocation;
import skgspl.service.api.LessonLocationService;

@Transactional
@Service
public class LessonLocationServiceImpl extends AbstractServiceImpl<LessonLocation> implements LessonLocationService {

	@Autowired
	LessonLocationDao lessonLocationDao;
	@Autowired
	UserDao userDao;
	@Autowired
	RoomDao roomDao;

	@Override
	protected AbstractDao<LessonLocation> getDao() {
		return lessonLocationDao;
	}

	
}
