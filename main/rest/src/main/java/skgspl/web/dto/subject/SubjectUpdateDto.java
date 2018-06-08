package skgspl.web.dto.subject;

import javax.validation.constraints.Size;

import skgspl.entity.Subject;

public class SubjectUpdateDto {
	@Size(max=45)
	private String name;
	@Size(max=100)
	private String description;

	public SubjectUpdateDto(Subject subject) {
		this.name = subject.getName();
		//this.description = subject.getDescription();
	}

	public SubjectUpdateDto() {

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
