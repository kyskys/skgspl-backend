package skgspl.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "user")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@SecondaryTables(value = { @SecondaryTable(name = "user_details") })
public class User extends AbstractEntity {

//	@Column(name = "role", insertable = false, updatable = false)
//	@Enumerated(value = EnumType.STRING)
	@ManyToOne
	@JoinColumn(name="role_id")
	protected Role role;

	@Column(name = "login")
	protected String login;

	@Column(name = "password")
	protected String password;

	@OneToOne(mappedBy = "user")
	private UserDetails details;
	
	@ManyToMany
	@JoinTable( name = "user_authority", 
				joinColumns = { @JoinColumn(name = "user_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "authority_id") })
	private List<Authority> authorities;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}
