package skgspl.dto.group;

import skgspl.entity.User;

public class GroupStudentDto {
	private Long id;
	private String email;
	private String name;
	private String number;
	private String login;

	public GroupStudentDto() {

	}

	public GroupStudentDto(User student) {
		this.id = student.getId();
		this.login = student.getLogin();
		this.name = student.getDetails().getName();
		this.email = student.getDetails().getEmail();
		//this.number = student.getDetails().getNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
