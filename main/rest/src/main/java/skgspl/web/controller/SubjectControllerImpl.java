package skgspl.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import skgspl.dao.search.SubjectSearchParams;
import skgspl.dto.subject.SubjectCreateDto;
import skgspl.dto.subject.SubjectGetDto;
import skgspl.dto.subject.SubjectUpdateDto;
import skgspl.dao.search.SortParam;
import skgspl.entity.Subject;
import skgspl.entity.util.DictionaryItem;
import skgspl.holder.support.CurrentUserSupport;
import skgspl.service.api.SubjectService;
import skgspl.service.api.UserService;

@RestController
@RequestMapping(value = "/api/subject/")
public class SubjectControllerImpl implements CurrentUserSupport {
	@Autowired
	SubjectService subjectService;
	@Autowired
	UserService lecturerService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET)
	public SubjectGetDto getSubject(@PathVariable("id") Long id) {
		return new SubjectGetDto(subjectService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public SubjectGetDto createSubject(@Valid @RequestBody SubjectCreateDto dto) {
		Subject subject = new Subject();
		subject.setName(dto.getName());
		//subject.setDescription(dto.getDescription());
		return new SubjectGetDto(subjectService.create(subject));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteSubject(@PathVariable("id") Long id) {
		Subject subject = new Subject();
		subject.setId(id);
		subjectService.delete(subject);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateSubject(@Valid @RequestBody SubjectUpdateDto dto, @PathVariable("id") Long id) {
		Subject subject = subjectService.get(id);
			subject.setName(dto.getName());
			subject.setDescription(dto.getDescription());
		subjectService.update(subject);
	}

	@RequestMapping(value="all", method = RequestMethod.GET)
	public List<SubjectGetDto> getAllSubjects() {
		return subjectService.getAll().stream().map(SubjectGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public List<SubjectGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		SubjectSearchParams searchParam = new SubjectSearchParams(id, name);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<SubjectGetDto> result = subjectService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(SubjectGetDto::new).collect(Collectors.toList());
		return result;
	}

//	@RequestMapping(value = "{subject}/add/lection/{lection}", method = RequestMethod.POST)
//	public void addLectionToSubject(@PathVariable("lection") Long idLection, @PathVariable("subject") Long idSubject) {
//		subjectService.addLectionToSubject(idLection, idSubject);
//	}
//
//	@RequestMapping(value = "{subject}/remove/lection/{lection}", method = RequestMethod.POST)
//	public void removeLectionFromSubject(@PathVariable("lection") Long idLection) {
//		subjectService.removeLectionFromSubject(idLection);
//	}

	@RequestMapping(value = "count", method = RequestMethod.GET)
	public Long subjectCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name) {
		SubjectSearchParams searchParam = new SubjectSearchParams(id, name);
		return subjectService.count(searchParam);
	}

//	@RequestMapping(value = "{id}/add/lection", method = RequestMethod.POST)
//	public void addLectionsToSubject(@PathVariable("id") Long idSubject, @RequestBody List<Long> lections) {
//		subjectService.addlectionsToSubject(idSubject, lections);
//	}

	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return subjectService.getDictionary();
	}
}
