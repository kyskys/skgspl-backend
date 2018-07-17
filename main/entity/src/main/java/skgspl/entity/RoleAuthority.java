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
@IdClass(RoleAuthorityPK.class)
@Table(name = "role_authority")
public class RoleAuthority {
	@Id
	@Column(name = "role_id")
	private Long role;
	@Id
	@Column(name = "authority_id")
	private Long authority;

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public Long getAuthority() {
		return authority;
	}

	public void setAuthority(Long authority) {
		this.authority = authority;
	}
}

@Embeddable
class RoleAuthorityPK implements Serializable {

	private static final long serialVersionUID = 8557696002432831729L;

	private Long role;
	private Long authority;

	public RoleAuthorityPK() {

	}

	public RoleAuthorityPK(Long role, Long authority) {
		this.role = role;
		this.authority = authority;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
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
		if (!(obj instanceof RoleAuthorityPK))
			return false;
		RoleAuthorityPK that = (RoleAuthorityPK) obj;
		return (Objects.equals(this.role, that.getRole()) && Objects.equals(this.getAuthority(), that.getAuthority()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(getRole(), getAuthority());
	}
}
