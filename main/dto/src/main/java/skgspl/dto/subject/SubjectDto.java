package skgspl.dto.subject;

import skgspl.entity.Subject;

public class SubjectDto {
	private String name;
	private String description;

	public SubjectDto(Subject subject) {
		this.name = subject.getName();
		// this.description = subject.getDescription();
	}

	public SubjectDto() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
