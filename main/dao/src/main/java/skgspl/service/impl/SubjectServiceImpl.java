package skgspl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.SubjectDao;
import skgspl.dao.search.CourseSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.dao.search.SubjectSearchParams;
import skgspl.entity.Subject;
import skgspl.entity.Lesson;
import skgspl.service.api.SubjectService;

@Transactional
@Service
public class SubjectServiceImpl extends SearchableServiceImpl<SubjectSearchParams, Subject> implements SubjectService {

	@Autowired
	SubjectDao subjectDao;

	@Override
	protected AbstractDao<Subject> getDao() {
		return subjectDao;
	}

	@Override
	protected Searchable<SubjectSearchParams, Subject> getSearchableDao() {
		return subjectDao;
	}

//	@Override
//	public void addLectionToCourse(Long idLection, Long idCourse) {
//		subjectDao.addLectionToCourse(idLection, idCourse);
//	}
//
//	@Override
//	public void removeLectionFromCourse(Long idLection) {
//		subjectDao.removeLectionFromCourse(idLection);
//	}
//
//	@Override
//	public List<Lesson> getLectionsByCourseId(Long idCourse) {
//		return subjectDao.getLectionsByCourseId(idCourse);
//	}
//	
//	@Override
//	public void addlectionsToCourse(Long idCourse, List<Long> lections) {
//		Subject subject = subjectDao.get(idCourse);
//		List<Long> courseLections = subject.getLections().stream().map(lection -> lection.getId())
//				.collect(Collectors.toList());
//		for (Long idLection : lections) {
//			if (courseLections.contains(idLection)) {
//				courseLections.remove(idLection);
//			} else {
//				subjectDao.addLectionToCourse(idLection, idCourse);
//			}
//		}
//		for (Long idLection : courseLections) {
//			subjectDao.removeLectionFromCourse(idLection);
//		}
//	}

}
