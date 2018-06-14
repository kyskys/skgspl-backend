package skgspl.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import skgspl.entity.util.RoleEnum;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@SecondaryTables(value = { @SecondaryTable(name = "user_details") })
public class User extends AbstractEntity {

	@Column(name = "role", insertable = false, updatable = false)
	@Enumerated(value = EnumType.STRING)
	protected RoleEnum role;

	@Column(name = "login")
	protected String login;

	@Column(name = "password")
	protected String password;

	@OneToOne(mappedBy = "user")
	private UserDetails details;

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

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
	}

}
