package skgspl.dao.impl;

import org.springframework.stereotype.Repository;

import skgspl.dao.api.LessonLocationDao;
import skgspl.entity.LessonLocation;

@Repository
public class LessonLocationImpl extends AbstractDaoImpl<LessonLocation> implements LessonLocationDao{

	@Override
	public Class<LessonLocation> getGenericClass() {
		return LessonLocation.class;
	}

}
