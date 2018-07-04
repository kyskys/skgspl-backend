package skgspl.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lesson")
public class Lesson extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@OneToOne
	@JoinColumn(name = "group_id")
	private Group group;

	@Column(name = "date")
	private LocalDateTime date;

	@OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
	private List<LessonLocation> locations;

	@OneToOne
	@JoinColumn(name = "time_id")
	private LessonTime time;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public List<LessonLocation> getLocations() {
		return locations != null ? new ArrayList<LessonLocation>(locations) : new ArrayList<LessonLocation>();
	}

	public void setLocations(List<LessonLocation> locations) {
		this.locations = locations;
	}

	public LessonTime getTime() {
		return time;
	}

	public void setTime(LessonTime time) {
		this.time = time;
	}

}
