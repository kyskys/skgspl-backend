package skgspl.dto.report;

import java.util.StringJoiner;

import skgspl.entity.Lesson;

public class TimetableSubreportItem {

	private String subjectName;
	private String roomNumber;
	private String lecturerFIO;

	public TimetableSubreportItem(Lesson lesson) {
		subjectName = lesson.getSubject().getName();
		StringJoiner roomJoiner = new StringJoiner("\n");
		StringJoiner lecturerJoiner = new StringJoiner("\n");
		lesson.getLocations().stream().forEach(location -> {
			roomJoiner.add(location.getRoom().getName());
			lecturerJoiner.add(location.getLecturer().getDetails().getName());
		});
		roomNumber = roomJoiner.toString();
		lecturerFIO = lecturerJoiner.toString();
	}

	public TimetableSubreportItem() {
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getLecturerFIO() {
		return lecturerFIO;
	}

	public void setLecturerFIO(String lecturerFIO) {
		this.lecturerFIO = lecturerFIO;
	}

}
