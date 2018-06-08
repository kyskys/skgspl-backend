package skgspl.web.dto.subject;

import skgspl.entity.Subject;

public class SubjectGetDto {
	private Long id;
	private String name;
	private String description;

	public SubjectGetDto(Subject subject) {
		this.id = subject.getId();
		this.name = subject.getName();
		//this.description = subject.getDescription();
	}

	public SubjectGetDto() {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
