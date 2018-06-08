package skgspl.dao.api;

import skgspl.dao.search.SubjectSearchParams;
import skgspl.dao.search.Searchable;
import skgspl.entity.Subject;

public interface SubjectDao extends AbstractDao<Subject>, Searchable<SubjectSearchParams, Subject> {

	void addLessonToSubject(Long idLesson, Long idSubject);

	void removeLessonFromSubject(Long idLesson);
}
