package skgspl.dto.user;

import java.util.List;

public class UserAuthoritiesDto {
	List<Long> authorities;
	Long role;
	
	public List<Long> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Long> authorities) {
		this.authorities = authorities;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}
}
