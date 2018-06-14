package skgspl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name = "group_lessons")
public class GroupLessons extends AbstractEntity {

	@Column(name = "group_id")
	private Long group;

	@Column(name = "lesson_id")
	private Long lesson;

	public Long getGroup() {
		return group;
	}

	public void setGroup(Long group) {
		this.group = group;
	}

	public Long getLesson() {
		return lesson;
	}

	public void setLesson(Long lesson) {
		this.lesson = lesson;
	}
}
