package skgspl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.GroupDao;
import skgspl.dao.api.LessonDao;
import skgspl.dao.api.UserDao;
import skgspl.dao.search.GroupSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.entity.Group;
import skgspl.entity.Lesson;
import skgspl.entity.User;
import skgspl.service.api.GroupService;

@Transactional
@Service
public class GroupServiceImpl extends SearchableServiceImpl<GroupSearchParams, Group> implements GroupService {

	@Autowired
	GroupDao groupDao;
	@Autowired
	LessonDao lessonDao;
	@Autowired
	UserDao userDao;

	@Override
	protected AbstractDao<Group> getDao() {
		return groupDao;
	}

	@Override
	protected Searchable<GroupSearchParams, Group> getSearchableDao() {
		return groupDao;
	}

	@Override
	public void addLessonToGroup(Long idLesson, Long idGroup) {
		Group group = groupDao.get(idGroup);
		Lesson lesson = lessonDao.get(idLesson);
		//group.getLessons().add(lesson);
		groupDao.update(group);
	}

	@Override
	public void removeLessonFromGroup(Long idLesson, Long idGroup) {
		Group group = groupDao.get(idGroup);
		Lesson lesson = lessonDao.get(idLesson);
		//group.getLessons().remove(lesson);
		groupDao.update(group);
	}

	@Override
	public void addStudentToGroup(Long idStudent, Long idGroup) {
		Group group = groupDao.get(idGroup);
		User student = userDao.get(idStudent);
		//student.setGroup(group);
		userDao.update(student);
	}

	@Override
	public void removeStudentFromGroup(Long idStudent) {
		User student = userDao.get(idStudent);
		//student.setGroup(null);
		userDao.update(student);
	}

	@Override
	public void addstudentsToGroup(Long idGroup, List<Long> students) {
		Group group = groupDao.get(idGroup);
		List<Long> groupStudents = group.getStudents().stream().map(lection -> lection.getId())
				.collect(Collectors.toList());
		for (Long idStudent : students) {
			if (groupStudents.contains(idStudent)) {
				groupStudents.remove(idStudent);
			} else {
				User student = userDao.get(idStudent);
				//student.setGroup(group);
				userDao.update(student);
			}
		}
		for (Long idStudent : groupStudents) {
			User student = userDao.get(idStudent);
			//student.setGroup(null);
			userDao.update(student);
		}
	}

//	 @Override
//	 public List<Group> getGroupsByLessonId(Long idLesson) {
//	 return groupDao.getGroupsByLessonId(idLesson);
//	 }
//	
//	 @Override
//	 public List<Group> getGroupsWithoutLesson(Long idLesson) {
//	 return groupDao.getGroupsWithoutLesson(idLesson);
//	 }

}
