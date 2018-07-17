package skgspl.entity.util;

public enum AuthorityEnum {

	CREATE_GROUP(1), 	DELETE_GROUP(2), 	READ_GROUP(3);
	
	private Integer value;

	AuthorityEnum(Integer roleValue) {
		this.value = roleValue;
	}

	public Integer getValue() {
		return this.value;
	}

}
