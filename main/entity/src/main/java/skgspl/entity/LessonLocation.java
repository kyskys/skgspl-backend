package skgspl.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lesson_location")
public class LessonLocation extends AbstractEntity {

	@OneToOne
	@JoinColumn(name = "lecturer_id")
	private User lecturer;

	@OneToOne
	@JoinColumn(name="room_id")
	private Room room;
	
	@ManyToOne
	@JoinColumn(name="lesson_id")
	private Lesson lesson;

	public User getLecturer() {
		return lecturer;
	}

	public void setLecturer(User lecturer) {
		this.lecturer = lecturer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

}
