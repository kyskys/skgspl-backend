package skgspl.web.dto.group;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GroupCreateDto {
	@NotBlank
	@Size(max = 45)
	private String name;
	
	@NotNull
	private Long curator;

	public Long getCurator() {
		return curator;
	}

	public void setCurator(Long curator) {
		this.curator = curator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
