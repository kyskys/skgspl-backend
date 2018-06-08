package skgspl.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import skgspl.dao.search.LectionSearchParams;
import skgspl.dao.search.SortParam;
import skgspl.entity.Lesson;
import skgspl.entity.util.DictionaryItem;
import skgspl.service.api.LessonService;
import skgspl.web.dto.lection.LectionCreateDto;
import skgspl.web.dto.lection.LectionDto;
import skgspl.web.dto.lection.LectionGetDto;
import skgspl.web.dto.subject.SubjectLectionDto;

@RestController
@RequestMapping("/api/lection/")
public class LectionControllerImpl {
/*
	@Autowired
	LessonService lessonService;
	@Autowired
	CourseService subjectService;
	@Autowired
	PairService pairService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public LectionGetDto getLection(@PathVariable("id") Long id) {
		return new LectionGetDto(lessonService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public LectionGetDto createLection(@Valid @RequestBody LectionCreateDto dto) {
		Lesson lection = new Lesson();
		lection.setName(dto.getName());
		return new LectionGetDto(lessonService.create(lection));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteLection(@PathVariable("id") Long id) {
		Lesson lection = new Lesson();
		lection.setId(id);
		lessonService.delete(lection);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateLection(@Valid @RequestBody LectionDto dto, @PathVariable("id") Long id) {
		Lesson lection = lessonService.get(id);
		String name = dto.getName();
		if (!StringUtils.isEmpty(name)) {
			lection.setName(name);
		}
		Long idCourse = dto.getCourse();
		if (idCourse != null && idCourse != 0) {
			lection.setSubject(subjectService.get(idCourse));
		}
		lessonService.update(lection);
	}

	@RequestMapping(value="all", method = RequestMethod.GET, produces = "application/json")
	public List<LectionDto> getAllLections() {
		return lessonService.getAll().stream().map(LectionDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
	public List<LectionGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "pair", required = false) String pair,
			@RequestParam(value = "course", required = false) String course, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		LectionSearchParams searchParam = new LectionSearchParams(id, name, pair, course);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<LectionGetDto> result = lessonService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(LectionGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
	public Long lectionCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "course", required = false) String course,
			@RequestParam(value = "pair", required = false) String pair) {
		LectionSearchParams searchParam = new LectionSearchParams(id, name, pair, course);
		return lessonService.count(searchParam);
	}

	@RequestMapping(value = "course/{course}", method = RequestMethod.GET)
	public List<SubjectLectionDto> getLectionsByCourseId(@PathVariable("course") Long idCourse) {
		List<SubjectLectionDto> result = lessonService.getLectionsByCourseId(idCourse).stream()
				.map(SubjectLectionDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "course/", method = RequestMethod.GET)
	public List<SubjectLectionDto> getLectionsWithoutCourse() {
		List<SubjectLectionDto> result = lessonService.getLectionsWithoutCourse().stream().map(SubjectLectionDto::new)
				.collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return lessonService.getDictionary();
	}*/
}
