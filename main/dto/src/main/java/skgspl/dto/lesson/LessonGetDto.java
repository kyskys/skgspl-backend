package skgspl.dto.lesson;

import skgspl.dto.util.DateFormatterUtil;
import skgspl.entity.Lesson;

public class LessonGetDto {
	private Long id;
	private String name;
	private String date;
	private String subject;
	private Long lecturer;
	private String time;

	public LessonGetDto() {

	}

	public LessonGetDto(Lesson lesson) {
		this.id = lesson.getId();
		//this.name = lesson.getName();
		this.date = DateFormatterUtil.getDateAsString(lesson.getDate());
		this.subject = lesson.getSubject().getName();
		this.time = lesson.getTime().getTime();
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getLecturer() {
		return lecturer;
	}

	public void setLecturer(Long lecturer) {
		this.lecturer = lecturer;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
