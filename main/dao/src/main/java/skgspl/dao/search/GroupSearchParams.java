package skgspl.dao.search;

public class GroupSearchParams {
	private Long id;
	private String name;
	private Long curator;

	public GroupSearchParams(Long id, String name, Long curator) {
		super();
		this.id = id;
		this.name = name;
		this.curator = curator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCurator() {
		return curator;
	}

	public void setCurator(Long curator) {
		this.curator = curator;
	}

}
