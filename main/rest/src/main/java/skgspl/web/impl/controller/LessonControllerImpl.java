package skgspl.web.impl.controller;

import java.time.LocalDateTime;
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

import skgspl.dao.search.LessonSearchParams;
import skgspl.dao.search.SortParam;
import skgspl.dao.util.DateFormatterUtil;
import skgspl.entity.Lesson;
import skgspl.entity.util.DictionaryItem;
import skgspl.holder.support.CurrentUserSupport;
import skgspl.service.api.GroupService;
import skgspl.service.api.LessonService;
import skgspl.service.api.SubjectService;
import skgspl.service.api.UserService;
import skgspl.web.dto.lesson.LessonCreateDto;
import skgspl.web.dto.lesson.LessonGetDto;
import skgspl.web.dto.lesson.LessonTimetableGetDto;
import skgspl.web.dto.lesson.LessonUpdateDto;
import skgspl.service.api.LessonTimeService;

@RestController
@RequestMapping("/api/lesson/")
public class LessonControllerImpl {

	@Autowired
	LessonService lessonService;
	@Autowired
	LessonTimeService lessonTimeService;
	@Autowired
	GroupService groupService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")

	public LessonGetDto getLesson(@PathVariable("id") Long id) {
		return new LessonGetDto(lessonService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public LessonGetDto createLesson(@Valid @RequestBody LessonCreateDto dto) {
		Lesson lesson = new Lesson();
		lesson.setDate(DateFormatterUtil.getDateFromString(dto.getDate()));
		lesson.setSubject(subjectService.get(dto.getSubject()));
		lesson.setTime(lessonTimeService.get(dto.getTime()));
		return new LessonGetDto(lessonService.create(lesson));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteLesson(@PathVariable("id") Long id) {
		Lesson lesson = new Lesson();
		lesson.setId(id);
		lessonService.delete(lesson);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)

	public void updateLesson(@Valid @RequestBody LessonUpdateDto dto, @PathVariable("id") Long id) {
		Lesson lesson = lessonService.get(id);
		LocalDateTime date = DateFormatterUtil.getDateFromString(dto.getDate());
		lesson.setDate(date);
		Long idLection = dto.getLection();
		if (idLection != null && idLection != 0) {
			//lesson.setLection(lessonService.get(idLection));
		}
		Long idLessonTime = dto.getTime();
		if (idLessonTime != null && idLessonTime != 0) {
			lesson.setTime(lessonTimeService.get(idLessonTime));
		}
		String name = dto.getName();
//		if (!StringUtils.isEmpty(name)) {
//			lesson.setName(name);
//		}
		lessonService.update(lesson);
	}

	@RequestMapping(value="all", method = RequestMethod.GET, produces = "application/json")
	public List<LessonGetDto> getAllLessons() {
		return lessonService.getAll().stream().map(LessonGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
	public List<LessonGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "lection", required = false) String lection, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
//		LessonSearchParams searchParam = new LessonSearchParams(id, name, DateFormatterUtil.getDateFromString(date),
//				lection);
		SortParam sortParam = SortParam.getValueOf(sortBy);
//		List<LessonGetDto> result = lessonService.search(sortParam, searchParam, limit, offset, asc).stream()
//				.map(LessonGetDto::new).collect(Collectors.toList());
//		return result;
		return null;
	}

	@RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
	public Long lessonCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "id", required = false) String name,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "lection", required = false) String lection) {
//		LessonSearchParams searchParam = new LessonSearchParams(id, name, DateFormatterUtil.getDateFromString(date),
//				lection);
		//return lessonService.count(searchParam);
		return null;
	}

	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return lessonService.getDictionary();
	}

	@RequestMapping(value = "time/dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getLessonTimeDictionary() {
		return lessonTimeService.getDictionary();
	}

	
	
	@RequestMapping(value = "timetable/{group}", method = RequestMethod.GET)
	public List<LessonTimetableGetDto> getTimetableByWeek(@RequestParam("day") String startOfWeek,
			@PathVariable("group") Long idGroup) {
		LocalDateTime day = DateFormatterUtil.getDateFromString(startOfWeek);
		return lessonService.getLessonsByWeek(day, idGroup).stream().map(LessonTimetableGetDto::new)
				.collect(Collectors.toList());
	}

//	@RequestMapping(value = "{id}/add/group", method = RequestMethod.POST)
//	public void addGroupsToLesson(@PathVariable("id") Long idLesson, @RequestBody List<Long> groups) {
//		lessonService.addGroupsToLesson(idLesson, groups);
//	}
}
