package skgspl.dao.impl;

import org.springframework.stereotype.Repository;

import skgspl.dao.api.LessonTimeDao;
import skgspl.entity.LessonTime;

@Repository
public class LessonTimeDaoImpl extends AbstractDaoImpl<LessonTime> implements LessonTimeDao {
		
	@Override
	public Class<LessonTime> getGenericClass() {
		return LessonTime.class;
	}

}
