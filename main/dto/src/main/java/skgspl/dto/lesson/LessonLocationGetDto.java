package skgspl.dto.lesson;

import skgspl.entity.LessonLocation;

public class LessonLocationGetDto {
	private Long lecturer;
	private Long room;
	
	public LessonLocationGetDto() {
		
	}
	
	public LessonLocationGetDto(LessonLocation location) {
		this.lecturer=location.getLecturer().getId();
		this.room=location.getRoom().getId();
	}
	
	public Long getLecturer() {
		return lecturer;
	}
	public void setLecturer(Long lecturer) {
		this.lecturer = lecturer;
	}
	public Long getRoom() {
		return room;
	}
	public void setRoom(Long room) {
		this.room = room;
	}
}
