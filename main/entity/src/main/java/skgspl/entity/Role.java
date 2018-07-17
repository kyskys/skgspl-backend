package skgspl.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role extends AbstractEntity {

	@ManyToMany
	@JoinTable( name = "role_authority", 
				joinColumns = { @JoinColumn(name = "role_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "authority_id") })
	private List<Authority> authorities;

	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> list) {
		this.authorities = list;
	}

}
