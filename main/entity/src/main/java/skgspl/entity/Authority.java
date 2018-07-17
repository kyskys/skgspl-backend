package skgspl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import skgspl.entity.util.AuthorityEnum;

@Entity
public class Authority extends AbstractEntity {
	
	@Enumerated(EnumType.STRING)
	@Column(name = "code")
	private AuthorityEnum code;

	@Column(name = "name")
	private String name;

	public AuthorityEnum getCode() {
		return code;
	}

	public void setCode(AuthorityEnum code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
