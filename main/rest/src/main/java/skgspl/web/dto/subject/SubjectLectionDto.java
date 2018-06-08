package skgspl.web.dto.subject;

import skgspl.entity.Lesson;

public class SubjectLectionDto {
	private Long id;
	private String name;

	public SubjectLectionDto() {

	}

	public SubjectLectionDto(Lesson lection) {
		this.id = lection.getId();
		if (lection.getName() != null) {
			this.name = lection.getName();
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

}
