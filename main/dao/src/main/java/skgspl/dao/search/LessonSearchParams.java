package skgspl.dao.search;

import java.time.LocalDateTime;

public class LessonSearchParams {
	private Long id;
	private String name;
	private LocalDateTime date;
	private String subject;
	private String group;

	public LessonSearchParams(Long id, String name, LocalDateTime date, String subject, String group) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.subject = subject;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
