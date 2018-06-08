package skgspl.service.api;

import java.util.List;

import skgspl.dao.search.SubjectSearchParams;
import skgspl.entity.Subject;
import skgspl.dao.search.Searchable;

public interface SubjectService extends AbstractService<Subject>, Searchable<SubjectSearchParams, Subject> {

	
}
