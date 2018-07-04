package item;

import java.util.ArrayList;
import java.util.List;

public class TimetableReportItem {
	
	private String firstGroupName;
	private String secondGroupName;
	private List<TimetableSubreportItem> firstGroupData;
	private List<TimetableSubreportItem> secondGroupData;

	public String getFirstGroupName() {
		return firstGroupName;
	}

	public void setFirstGroupName(String firstGroupName) {
		this.firstGroupName = firstGroupName;
	}

	public String getSecondGroupName() {
		return secondGroupName;
	}

	public void setSecondGroupName(String secondGroupName) {
		this.secondGroupName = secondGroupName;
	}

	public List<TimetableSubreportItem> getFirstGroupData() {
		return firstGroupData==null?new ArrayList<>():new ArrayList<>(firstGroupData);
	}

	public void setFirstGroupData(List<TimetableSubreportItem> firstGroupData) {
		this.firstGroupData = firstGroupData;
	}

	public List<TimetableSubreportItem> getSecondGroupData() {
		return secondGroupData==null?new ArrayList<>():new ArrayList<>(secondGroupData);
	}

	public void setSecondGroupData(List<TimetableSubreportItem> secondGroupData) {
		this.secondGroupData = secondGroupData;
	}

}
