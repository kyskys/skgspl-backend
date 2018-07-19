package skgspl.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(UserAuthorityPK.class)
@Table(name = "user_authority")
public class UserAuthority {

	@Id
	@Column(name = "user_id")
	private Long user;

	@Id
	@Column(name = "authority_id")
	private Long authority;

	public Long getUser() {
		return user;
	}

	public void setRole(Long user) {
		this.user = user;
	}

	public Long getAuthority() {
		return authority;
	}

	public void setAuthority(Long authority) {
		this.authority = authority;
	}
}

@Embeddable
class UserAuthorityPK implements Serializable {

	private static final long serialVersionUID = -5864259564289972258L;
	
	private Long user;
	private Long authority;

	public UserAuthorityPK() {

	}

	public UserAuthorityPK(Long user, Long authority) {
		this.user = user;
		this.authority = authority;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getAuthority() {
		return authority;
	}

	public void setAuthority(Long authority) {
		this.authority = authority;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof UserAuthorityPK))
			return false;
		UserAuthorityPK that = (UserAuthorityPK) obj;
		return (Objects.equals(this.user, that.getUser()) && Objects.equals(this.getAuthority(), that.getAuthority()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUser(), getAuthority());
	}
}
