package skgspl.web.impl.controller;

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
import skgspl.dao.search.SortParam;
import skgspl.holder.support.CurrentUserSupport;
import skgspl.service.api.SubjectService;
import skgspl.web.dto.lesson.LessonMarkDto;
//import skgspl.web.dto.mark.MarkCreateDto;
//import skgspl.web.dto.mark.MarkGetDto;
//import skgspl.web.dto.mark.MarkStudentDto;
//import skgspl.web.dto.mark.MarkUpdateDto;

@RestController
@RequestMapping("/api/mark/")
public class MarkControllerImpl implements CurrentUserSupport {
/*
	@Autowired
	SubjectService subjectService;
	@Autowired
	PairService pairService;
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET)
	public MarkGetDto getMark(@PathVariable("id") Long id) {
		return new MarkGetDto(subjectService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void createMark(@Valid @RequestBody MarkCreateDto dto) {
		Mark mark = new Mark();
		mark.setPair(pairService.get(dto.getPair()));
		mark.setStudent(studentService.get(dto.getStudent()));
		mark.setMark(dto.getMark());
		subjectService.create(mark);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteMark(@PathVariable("id") Long id) {
		Mark Mark = new Mark();
		Mark.setId(id);
		subjectService.delete(Mark);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateMark(@Valid @RequestBody MarkUpdateDto dto, @PathVariable("id") Long id) {
		Mark mark = subjectService.get(id);
		Integer _mark = dto.getMark();
		if (_mark != null && _mark != 0) {
			mark.setMark(_mark);
		}
		Long idPair = dto.getPair();
		if (idPair != null && idPair != 0) {
			mark.setPair(pairService.get(idPair));
		}
		Long idStudent = dto.getStudent();
		if (idStudent != null && idStudent != 0) {
			mark.setStudent(studentService.get(idStudent));
		}
		subjectService.update(mark);
	}

	@RequestMapping(value="all", method = RequestMethod.GET)
	public List<MarkGetDto> getAllMarks() {
		return subjectService.getAll().stream().map(MarkGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public List<MarkGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "pair", required = false) String pair,
			@RequestParam(value = "student", required = false) String student, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		SubjectSearchParams searchParam = new SubjectSearchParams(id, pair, student);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<MarkGetDto> result = subjectService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(MarkGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "count", method = RequestMethod.GET)
	public Long markCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "pair", required = false) String pair,
			@RequestParam(value = "student", required = false) String student) {
		SubjectSearchParams searchParam = new SubjectSearchParams(id, pair, student);
		return subjectService.count(searchParam);
	}

	@RequestMapping(value = "pair/{pair}", method = RequestMethod.GET)
	public List<LessonMarkDto> getMarksByPairId(@PathVariable("pair") Long idPair) {
		return subjectService.getMarksByPairId(idPair).stream().map(LessonMarkDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "student/{student}", method = RequestMethod.GET)
	public List<LessonMarkDto> getMarksByStudentId(@PathVariable("pair") Long idStudent) {
		return subjectService.getMarksByStudentId(idStudent).stream().map(LessonMarkDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search/student", method = RequestMethod.GET)
	public List<MarkStudentDto> getMarksByCurrentStudent(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "pair", required = false) String pair, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		SubjectSearchParams searchParam = new SubjectSearchParams(id, pair, getCurrentUser().getName());
		SortParam sortParam = SortParam.getValueOf(sortBy);
		return subjectService.search(sortParam, searchParam, limit, offset, asc).stream().map(MarkStudentDto::new)
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "search/student/count", method = RequestMethod.GET)
	public Long markCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "pair", required = false) String pair) {
		SubjectSearchParams searchParam = new SubjectSearchParams(id, pair, getCurrentUser().getName());
		return subjectService.count(searchParam);
	}*/
}
