package skgspl.web.dto;

import skgspl.entity.Lesson;

import skgspl.dao.util.DateFormatterUtil;

public class LessonTimeItemDto {
	private String name;
	private String lection;
	private String startTime;
	private String endTime;
	private String date;

	public LessonTimeItemDto() {

	}

	public LessonTimeItemDto(Lesson lesson) {
		this.name = lesson.getName();
		//this.lection = lesson.getLection().getName();
		//this.startTime = DateFormatterUtil.getTimeAsString(lesson.getTime().getStartTime());
		//this.endTime = DateFormatterUtil.getTimeAsString(lesson.getTime().getEndTime());
		this.date = DateFormatterUtil.getDateAsString(lesson.getDate());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLection() {
		return lection;
	}

	public void setLection(String lection) {
		this.lection = lection;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
