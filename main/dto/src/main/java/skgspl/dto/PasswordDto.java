package skgspl.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PasswordDto {
	@NotBlank
	@Size(min=8)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
