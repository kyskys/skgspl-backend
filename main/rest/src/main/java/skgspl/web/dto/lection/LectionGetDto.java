package skgspl.web.dto.lection;

import skgspl.entity.Lesson;

public class LectionGetDto {
	private Long id;
	private String name;
	private String course;

	public LectionGetDto() {

	}

	public LectionGetDto(Lesson lection) {
		this.id = lection.getId();
		this.name = lection.getName();
		if (lection.getSubject() != null) {
			this.course = lection.getSubject().getName();
		}
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
