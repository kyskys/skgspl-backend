package skgspl.entity.util;

public enum RoleEnum {

	LECTURER(Values.LECTURER), STUDENT(Values.STUDENT), ADMIN(Values.ADMIN);

	private String value;

	RoleEnum(String roleValue) {
		this.value = roleValue;
	}

	public String getValue() {
		return this.value;
	}

	public static class Values {
		public static final String ADMIN = "1";
		public static final String LECTURER = "2";
		public static final String STUDENT = "3";
	}
}
