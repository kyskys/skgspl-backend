package skgspl.dto.lesson;

//import skgspl.entity.Mark;

public class LessonMarkDto {
	private Long id;
	private String student;
	private Integer mark;

	public LessonMarkDto() {

	}

//	public LessonMarkDto(Mark mark) {
//		this.id = mark.getId();
//		this.student = mark.getStudent().getName();
//		this.mark = mark.getMark();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
}
