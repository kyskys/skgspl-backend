package skgspl.dto.role;

import java.util.List;

public class RoleUpdateDto {
	private String name;
	private List<Long> authorities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Long> authorities) {
		this.authorities = authorities;
	}
}
