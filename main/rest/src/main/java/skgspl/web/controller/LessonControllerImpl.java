package skgspl.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import skgspl.dao.search.SortParam;
import skgspl.dto.lesson.LessonCreateDto;
import skgspl.dto.lesson.LessonGetDto;
import skgspl.dto.lesson.LessonTimetableGetDto;
import skgspl.dto.lesson.LessonUpdateDto;
import skgspl.dto.report.TimetableReportItem;
import skgspl.dto.util.DateFormatterUtil;
import skgspl.entity.Lesson;
import skgspl.entity.util.DictionaryItem;
import skgspl.reports.builder.JasperReportBuilder;
import skgspl.reports.format.ReportFormat;
import skgspl.service.api.GroupService;
import skgspl.service.api.LessonLocationService;
import skgspl.service.api.LessonService;
import skgspl.service.api.SubjectService;
import skgspl.service.api.UserService;
import skgspl.service.api.LessonTimeService;
import skgspl.service.api.RoomService;

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
	@Autowired
	LessonLocationService lessonLocationService;
	@Autowired
	RoomService roomService;

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
	
	@RequestMapping(value = "timetable/{group}", method = RequestMethod.POST)
	public void updateTimetable(@RequestBody List<LessonTimetableGetDto> receivedLessons,
			@PathVariable("group") Long idGroup,@RequestParam("day") String startOfWeek) {
		LocalDateTime firstDay = DateFormatterUtil.getDateFromString(startOfWeek);
		lessonService.updateTimetable(firstDay, idGroup, receivedLessons);
	}
	
	@RequestMapping(value = "timetable/report", method = RequestMethod.GET)
	public void getTimetableReport(@RequestParam("day") String startOfWeek) {
		LocalDateTime firstDay = DateFormatterUtil.getDateFromString(startOfWeek);
		List<TimetableReportItem> report = lessonService.getTimetableReportData(firstDay);
		JasperReportBuilder builder = new JasperReportBuilder();
		try (FileOutputStream fos = new FileOutputStream("D://report.pdf")) {
			// Writer writer = new ByteWriter(new FileWriter("report.pdf"));
			Map<String, Object> map = new HashMap<>();
			map.put("firstDay","07.01");
			map.put("lastDay", "10.01");
			map.put("year", "2018");
			map.put("profPresident","А.А. Предко");
			map.put("director", "В.Н. Салей");
			byte[] bytes = builder.buildReportWithObjects(JasperReportBuilder.ReportTemplate.REPORT_TEMPLATE,
					ReportFormat.PDF, map, report);
			fos.write(bytes);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@RequestMapping(value = "{id}/add/group", method = RequestMethod.POST)
//	public void addGroupsToLesson(@PathVariable("id") Long idLesson, @RequestBody List<Long> groups) {
//		lessonService.addGroupsToLesson(idLesson, groups);
//	}
}
