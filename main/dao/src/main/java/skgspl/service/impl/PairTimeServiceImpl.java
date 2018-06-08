package skgspl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.LessonTimeDao;
import skgspl.entity.LessonTime;
import skgspl.service.api.LessonTimeService;

@Transactional
@Service
public class PairTimeServiceImpl extends AbstractServiceImpl<LessonTime> implements LessonTimeService {

	@Autowired
	LessonTimeDao lessonTimeDao;

	@Override
	protected AbstractDao<LessonTime> getDao() {
		return lessonTimeDao;
	}

}
