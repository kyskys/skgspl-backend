package skgspl.dto.lesson;

import skgspl.entity.Lesson;

import java.util.List;
import java.util.stream.Collectors;

public class LessonTimetableGetDto {
	private Integer date;
	private Long subject;
	private Long time;
	private List<LessonLocationGetDto> locations;

	public LessonTimetableGetDto() {

	}

	public LessonTimetableGetDto(Lesson lesson) {
		this.date = lesson.getDate().getDayOfWeek().getValue();
		this.subject = lesson.getSubject().getId();
		this.time = lesson.getTime().getId();
		this.locations=lesson.getLocations().stream().map(LessonLocationGetDto::new).collect(Collectors.toList());
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
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

	public Long getSubject() {
		return subject;
	}

	public void setSubject(Long subject) {
		this.subject = subject;
	}

}
