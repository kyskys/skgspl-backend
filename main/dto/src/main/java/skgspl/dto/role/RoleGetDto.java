package skgspl.dto.role;

import java.util.List;
import java.util.stream.Collectors;

import skgspl.entity.Role;
import skgspl.entity.util.DictionaryItem;

public class RoleGetDto {
	private Long id;
	private String name;

	public RoleGetDto() {
		
	}
	
	public RoleGetDto(Role role) {
		this.id=role.getId();
		this.name=role.getName();
		
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
