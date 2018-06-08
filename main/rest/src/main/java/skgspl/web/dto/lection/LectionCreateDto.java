package skgspl.web.dto.lection;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LectionCreateDto {
	@NotBlank
	@Size(max = 45)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
