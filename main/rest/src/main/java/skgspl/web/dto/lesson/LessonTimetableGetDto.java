package skgspl.web.dto.lesson;

import skgspl.entity.Lesson;

import java.util.List;
import java.util.stream.Collectors;

import skgspl.dao.util.DateFormatterUtil;

public class LessonTimetableGetDto {
	private Long id;
	private String name;
	private Integer date;
	private String subject;
	private Long time;
	private List<LessonLocationGetDto> locations;

	public LessonTimetableGetDto() {

	}

	public LessonTimetableGetDto(Lesson lesson) {
		this.id = lesson.getId();
		this.date = lesson.getDate().getDayOfWeek().getValue();
		this.subject = lesson.getSubject().getName();
		this.time = lesson.getTime().getId();
		this.locations=lesson.getLocations().stream().map(LessonLocationGetDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public List<LessonLocationGetDto> getLocations() {
		return locations;
	}

	public void setLocations(List<LessonLocationGetDto> locations) {
		this.locations = locations;
	}

}
