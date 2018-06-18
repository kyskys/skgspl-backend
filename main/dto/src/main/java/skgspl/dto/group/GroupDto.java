package skgspl.dto.group;

import javax.validation.constraints.Size;

import skgspl.entity.Group;

public class GroupDto {
	@Size(max = 45)
	private String name;
	private Long curator;

	public GroupDto() {

	}

	public GroupDto(Group group) {
		this.name = group.getName();
		this.curator = group.getCurator().getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCurator() {
		return curator;
	}

	public void setCurator(Long curator) {
		this.curator = curator;
	}

}
